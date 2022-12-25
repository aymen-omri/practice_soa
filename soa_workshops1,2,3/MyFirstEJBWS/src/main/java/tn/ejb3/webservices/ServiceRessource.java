package tn.ejb3.webservices;

import java.util.ArrayList;
import java.util.List;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

/**
 * Session Bean implementation class ServiceRessource
 */
@Stateless
@LocalBean
@Path("MyRestRessource")
public class ServiceRessource {
	@PersistenceContext(unitName="MyFirstEJBWS")
    /**
     * Default constructor. 
     */
	public EntityManager em ; 
    public ServiceRessource() {
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("test")
    public String test() {
    	return "Hello i m ejb stateless session!" ; 
    }
    
    
    @Path("/learners")
    @GET
    @Produces(value= {MediaType.APPLICATION_JSON})
    public Response getAllLearners()
    {
    List<Learner> learners = new ArrayList<Learner>();
    TypedQuery<Learner> query = em.createNamedQuery("Learner.findAll",Learner.class);
    learners = query.getResultList();
   
    if(learners.size()!=0) {
    	return Response.status(Status.FOUND).entity(learners).build();
	}
	return Response.status(Status.NOT_FOUND).entity("there is no learner in database").build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/learners/{name}")
    public Response getLearnersByName(@PathParam("name") String name) {
    	List<Learner> learners = new ArrayList<Learner>();
    	TypedQuery<Learner> query = em.createNamedQuery("Learner.findByName", Learner.class).setParameter(1,name);
    	learners = query.getResultList();
    	
    	if(learners.size()!=0) {
    		return Response.status(Status.FOUND).entity(learners).build();
    	}
    	return Response.status(Status.NOT_FOUND).entity("Empty!").build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/learners/{name}/{email}")
    public Response getByNameEmail(@PathParam("name") String name , @PathParam("email")String email) {
    	List<Learner> learner = new ArrayList<Learner>();
    	TypedQuery<Learner> query = em.createNamedQuery("Learner.emailName",Learner.class).setParameter(1,name).setParameter(2, email);
    	learner = query.getResultList();
    	
    	if(learner.size()!=0) {
    		return Response.status(Status.FOUND).entity(learner).build();
    	}
    	return Response.status(Status.NOT_FOUND).entity("empty!").build();
    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/learners/{id}")
    public Response deleteById(@PathParam("id") int id) {
    	Query query = em.createQuery("DELETE FROM Learner WHERE LearnerId="+id) ; 
    	int a = query.executeUpdate();
    	
    	if(a!=0) {
    		return Response.status(Status.FOUND).entity("deleted successfully !").build();

    	}
    	return Response.status(Status.NOT_FOUND).entity("id not found!").build();

    }
    
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/learner")
    public Response addLearner(Learner newL) {
    	
    	try {
    		em.persist(newL);
    		return Response.status(200).entity("added successfully !").build();

    	}
    	
    	catch(Exception e) {
        	return Response.status(500).entity("id not found!").build();

    	}

    }
    
    
}
