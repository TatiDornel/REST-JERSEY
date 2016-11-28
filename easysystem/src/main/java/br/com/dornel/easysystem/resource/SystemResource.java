package br.com.dornel.easysystem.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import br.com.dornel.easysystem.dao.ISystemDAO;
import br.com.dornel.easysystem.dao.SystemDAO;
import br.com.dornel.easysystem.entity.System;


@Path("/systems")
public class SystemResource {

	private static final Logger LOGGER = Logger.getLogger(SystemResource.class);

	private ISystemDAO<System, Long> dao;

	public SystemResource() {
		this.dao = new SystemDAO();
	}

	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	public Response save(System System) {
		try {
		
			dao.save(System);	
			
			return Response
					.status(200)
					.entity("Registro inserido: " + System.toString())
					.build();	
			
		} catch (Exception ex) {
			LOGGER.error(ex);
			throw new WebApplicationException(500);
		}
	}

	@PUT
	@Consumes({MediaType.APPLICATION_JSON})
	public Response update(System System) {
		try {
			
			dao.update(System);
			
			return Response
					.status(200)
					.entity("Registro editado.")
					.build();	
			
		} catch (Exception ex) {
			LOGGER.error(ex);
			throw new WebApplicationException(500);
		}
	}

	@DELETE
	@Path("/{id}")
	@Consumes({MediaType.APPLICATION_JSON})
	public Response delete(@PathParam("id") Long id) {
		try {
			
			dao.delete(id);
			
			return Response
					.status(200)
					.entity("Registro removido.")
					.build();
			
		} catch (Exception ex) {
			LOGGER.error(ex);
			throw new WebApplicationException(500);
		}
	}

	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public System findById(@PathParam("id") Long id) {
		try {

			return dao.findById(id);
			
		} catch (Exception ex) {
			LOGGER.error(ex);
			throw new WebApplicationException(500);
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<System> findAll() {
		try {
			
			return dao.findAll(); 
			
		} catch (Exception ex) {
			LOGGER.error(ex);
			throw new WebApplicationException(500);
		}
	}
	
	@GET
	@Path("/name/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findByName(@PathParam("name") String name) {
		LOGGER.info("NAME : " + name);
		try {
			
			List<System> Systems = dao.findByName(name);
			
			GenericEntity<List<System>> entities = new GenericEntity<List<System>>(Systems) {};
			
			return Response
					.ok(entities)
					.build();
			
		} catch (Exception ex) {
			LOGGER.error(ex);
			throw new WebApplicationException(500);
		}
	}
}
