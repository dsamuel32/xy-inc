/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diego.resources;

import br.com.diego.beans.PontoInteresseBean;
import br.com.diego.model.PontoInteresse;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
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

/**
 *
 * @author Diego NOTE
 */
@Stateless
@Path("ponto-interesse")
@Produces(MediaType.APPLICATION_JSON)
public class PontoInteresseResources {
    
    @EJB
    private PontoInteresseBean pontoInteresseBean;
    
    @GET
    public Response findAll() {
        List<PontoInteresse> pontosInterreses = pontoInteresseBean.findAll();
        return Response.ok(pontosInterreses).build();
    }
    
    @GET
    @Path("listar-proximidades/{x}/{y}/{max}")
    public Response listarProximidades(@PathParam("x") Long coordenadaX, 
                                       @PathParam("y") Long coordenadaY, 
                                       @PathParam("max") Long distanciaMaxima) {
        
        List<PontoInteresse> pontosEspessificosProximos = pontoInteresseBean.listarPorProximidade(coordenadaX, coordenadaY, distanciaMaxima);
        
        return Response.ok(pontosEspessificosProximos).build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(PontoInteresse pontoInteresse) {
        pontoInteresse = pontoInteresseBean.save(pontoInteresse);
        return Response.ok(pontoInteresse).build();
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(PontoInteresse pontoInteresse) {
        pontoInteresse = pontoInteresseBean.update(pontoInteresse);
        return Response.ok(pontoInteresse).build();
    }
    
    @DELETE
    @Path("{id}")
    public Response save(@PathParam("id") Long id) {
        pontoInteresseBean.delete(id);
        return Response.ok().build();
    }
    
}
