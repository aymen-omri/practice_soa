package com.istic.rest;

import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

import java.util.ArrayList;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/etudiant")
public class EtudiantRest {
	static ArrayList<Etudiant> liste ; 
	
	public EtudiantRest() {
		liste = new ArrayList<Etudiant>();
		liste.add(new Etudiant(1,"salah",15));
	    liste.add(new Etudiant(2,"salima",11));
		liste.add(new Etudiant(3,"slim",18));
    }
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		if(liste.size()==0) {
			return Response.status(Status.NO_CONTENT).entity(liste).build();
		}
		return Response.ok().entity(liste).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response getEtudiant(@PathParam("id") int id) {
		if(liste.size()==0) {
			return Response.status(Status.NO_CONTENT).entity(liste).build();
		}
		int i=0 ;
		Etudiant e = null ; 
		while(i<liste.size()) {
			if(id == liste.get(i).getId()) {
				e = liste.get(i);
				break;
			}
			i++;
		}
		if(e == null) {
			return Response.status(Status.NO_CONTENT).entity(e).build();	
		}
		return Response.ok().entity(e).build();	
	}
	
	@DELETE
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{id}")
	public String deleteEtudiant(@PathParam("id")int id) {
		if(liste.size()==0) {
			return "empty list!"; 
		}		
		int i=0 ;
		if(id == liste.get(liste.size()-1).getId()) {
			liste.remove(liste.size()-1);
			return "deleted successfully: " + liste.get(i).getNom() ; 
		}
		for(i=0;i<liste.size();i++){
			if(id == liste.get(i).getId()){
				liste.remove(i);
				return "deleted successfully: " + liste.get(i).getNom() ; 
			}
		}
		return "id doesn't exist!";	
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response updateEtudiant(@PathParam("id")int id ,Etudiant e ) {
		if(liste.size()==0) {
			return Response.status(Status.NO_CONTENT).entity(liste).build(); 
		}
		int i=0 ;
		for(i=0;i<liste.size();i++){
			if(id == liste.get(i).getId()){
				liste.set(i,e);
				return Response.ok().entity(liste).build() ; 
			}
		}
		return Response.status(Status.NO_CONTENT).entity(liste).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response postEtudiant(Etudiant e ) {
		if(liste==null) {
			liste = new ArrayList<Etudiant>();
		}
		liste.add(e);
		return Response.ok().entity(liste).build(); 
			
	}
	
}
	


















