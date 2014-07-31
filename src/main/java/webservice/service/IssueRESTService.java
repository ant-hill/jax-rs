package webservice.service;

import webservice.entity.Issue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/issue")
public class IssueRESTService {
//    @Inject
//    private EntityManager manager;

    @GET
    public Response getIssues(@MatrixParam("year") String year,
                              @MatrixParam("author") String author,
                              @MatrixParam("country") String country) {
        return Response
                .status(200)
                .entity("getBooks is called, year : " + year
                        + ", author : " + author + ", country : " + country)
                .build();

    }

    @POST
    @Path("/add")
    public Response addIssue(@FormParam("id") int id,
                             @FormParam("name") String name,
                             @FormParam("type") String type) {
        Issue issue = new Issue(id, name, type);
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("primary");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(issue);
        em.getTransaction().commit();
        return Response.status(200)
                .entity("addIssue is called, name : " + name)
                .build();
    }
}
