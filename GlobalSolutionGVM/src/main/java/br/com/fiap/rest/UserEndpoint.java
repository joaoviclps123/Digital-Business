package br.com.fiap.rest;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.fiap.dao.UserDAO;
import br.com.fiap.model.User;

@Path("/user")
public class UserEndpoint {
	
	private UserDAO dao = new UserDAO();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> index() {
		return dao.getAll();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(User user) {
		if (user == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		dao.save(user);
		return Response.status(Response.Status.CREATED).entity(user).build();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response show(@PathParam("id") int id) {
		User user;
		try {
			user = dao.findById(id);
			if(user == null) {
				return Response.status(Response.Status.NOT_FOUND).build();
			}
			return Response.status(Response.Status.OK).entity(user).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response update(@PathParam("id") int id, User user) {
		user.setId(id);
		dao.update(user);
		return Response.status(Response.Status.OK).entity(user).build();

	}
	
	@DELETE
	@Path("{id}")
	public Response destroy(@PathParam("id") int id) {
		User user;
		try {
			user = dao.findById(id);
			if(user == null ) {
				return Response.status(Response.Status.NOT_FOUND).build();
			}
			dao.delete(user);
			return Response.status(Response.Status.OK).entity(user).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}

}
