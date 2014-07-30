package webservice.service;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;

@Path("/user")
public class UserRESTService {

    @GET
    public Response getUser() {
        return Response.status(200).entity("getUser is called").build();
    }

    @GET
    @Path("/vip")
    public Response getUserVIP() {
        return Response.status(200).entity("getUserVIP is called").build();
    }

    @GET
    @Path("{name}")
    public Response getUserByName(@PathParam("name") String name) {
        return Response.status(200)
                .entity("getUserByName is called, name : " + name).build();
    }

    @GET
    @Path("{id : \\d+}")
    public Response getUserById(@PathParam("id") String id) {
        return Response.status(200).entity("getUserById is called, id : " + id).build();
    }

    //REGULAR EXPRESSION CAUSES ERROR
    @GET
    @Path("/username/{username: [a-zA-Z][a-zA-Z_0-9]*}")
    public Response getUserByUserName(@PathParam("username") String username) {
        return Response.status(200)
                .entity("getUserByUserName is called, username : " + username).build();
    }

    @GET
    @Path("{year}/{month}/{day}")
    public Response getUserHistory(
            @PathParam("year") int year,
            @PathParam("month") int month,
            @PathParam("day") int day) {

        String date = year + "/" + month + "/" + day;

        return Response.status(200)
                .entity("getUserHistory is called, year/month/day : " + date)
                .build();

    }

    @GET
    @Path("/query")
    public Response getUsers(
            @QueryParam("from") int from,
            @QueryParam("to") int to,
            @QueryParam("orderBy") List<String> orderBy) {

        return Response
                .status(200)
                .entity("getUsers is called, from : " + from + ", to : " + to
                        + ", orderBy" + orderBy.toString()).build();

    }

    @GET
    @Path("/query")
    public Response getUsersViaGetMethods(@Context UriInfo info) {

        String from = info.getQueryParameters().getFirst("from");
        String to = info.getQueryParameters().getFirst("to");
        List<String> orderBy = info.getQueryParameters().get("orderBy");

        return Response
                .status(200)
                .entity("getUsers is called, from : " + from + ", to : " + to
                        + ", orderBy" + orderBy.toString()).build();

    }

    @GET
    @Path("/default-query/")
    public Response getUsersWithDefaultParameters(
            @DefaultValue("1000") @QueryParam("from") int from,
            @DefaultValue("999")@QueryParam("to") int to,
            @DefaultValue("name") @QueryParam("orderBy") List<String> orderBy) {

        return Response
                .status(200)
                .entity("getUsers is called, from : " + from + ", to : " + to
                        + ", orderBy " + orderBy.toString()).build();

    }
}