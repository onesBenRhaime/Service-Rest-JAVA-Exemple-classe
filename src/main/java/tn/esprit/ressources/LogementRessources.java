package tn.esprit.ressources;

import tn.esprit.business.LogementBusiness;
import tn.esprit.entites.Logement;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/logements")
public class LogementRessources {
    public  LogementBusiness logB=new LogementBusiness();
    @GET
    @Produces(MediaType.APPLICATION_JSON)  //type de res return : format eu niveau de la reponse
    public List <Logement> getLogements ( ) {
        return logB.getLogements();
    }
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addLogement(Logement log) {
       // logB.addLogement(log)
        if ( logB.addLogement(log) )
            return Response.status(Response.Status.CREATED).entity(logB.getLogements()).build();
    return  Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    //@Path("?delegation=")
    //@QueryParam("delegation")
   // @PathParam("delegation")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Logement> rechercheLogement(@QueryParam("delegation") String del) {

        return logB.getLogementsByDeleguation(del) ;
    }


}


