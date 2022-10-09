package com.istic.rest;

import jakarta.ws.rs.Path;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/print")
public class PrintRessource {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello() {
		return "hello jax-rs" ; 
	}
	
	@GET
	@Path("/helloYou")
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHelloYou(@QueryParam(value="name") String name) {
		return "Hello"+name;
	}
	
	@GET
	@Path("/helloYou2")
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHelloYou2(@FormParam(value="name") String name) {
		return "hello" + name ; 
	}
	
	@GET
	@Path("/sum")
	@Produces(MediaType.TEXT_PLAIN)
	public String somme(@QueryParam("first") int first , @QueryParam("second") int second) {
		int sum = first+second;
			return "somme= "+ sum; 
		
	}
}



