package webservice.service;

import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/issue")
public class IssueRESTService {

    @GET
    public Response getBooks(@MatrixParam("year") String year,
                             @MatrixParam("author") String author,
                             @MatrixParam("country") String country) {

        return Response
                .status(200)
                .entity("getBooks is called, year : " + year
                        + ", author : " + author + ", country : " + country)
                .build();

    }

}
