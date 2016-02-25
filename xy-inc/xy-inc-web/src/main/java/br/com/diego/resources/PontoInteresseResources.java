/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diego.resources;

import br.com.diego.beans.interfaces.PontoInteresseBean;
import br.com.diego.model.PontoInteresse;
import br.com.diego.resources.dtos.PontoInteresseDTO;
import br.com.diego.resources.utils.ConversorUtil;
import java.lang.reflect.Type;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
        return Response.ok(ConversorUtil.converter(pontosInterreses)).build();
    }

    @GET
    @Path("listar-proximidades/{x}/{y}/{max}")
    public Response listarProximidades(@PathParam("x") Long coordenadaX,
            @PathParam("y") Long coordenadaY,
            @PathParam("max") Long distanciaMaxima) {

        List<PontoInteresse> todosPontos = pontoInteresseBean.findAll();

        List<PontoInteresse> pontosEspessificosProximos = pontoInteresseBean.filtrarPontosProximos(todosPontos, coordenadaX, coordenadaY, distanciaMaxima);
        
        return Response.ok(ConversorUtil.converter(pontosEspessificosProximos)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(PontoInteresseDTO pontoInteresseDTO) throws IllegalAccessException {

        if (validarParametros(pontoInteresseDTO)) {
            PontoInteresse pontoInteresse = (PontoInteresse) ConversorUtil.converter(pontoInteresseDTO, PontoInteresse.class);
            pontoInteresse = pontoInteresseBean.save(pontoInteresse);
            return Response.ok(ConversorUtil.converter(pontoInteresse, PontoInteresseDTO.class)).build();
        }

        return Response.ok().status(Response.Status.BAD_REQUEST).build();
    }

    private Boolean validarParametros(PontoInteresseDTO pontoInteresseDTO) {
        if (pontoInteresseDTO.getCoordenadaX() == null || pontoInteresseDTO.getCoordenadaY() == null) {
            return Boolean.FALSE;
        } else if (pontoInteresseDTO.getCoordenadaX().longValue() < 0 || pontoInteresseDTO.getCoordenadaY().longValue() < 0) {
            return Boolean.FALSE;
        }

        return Boolean.TRUE;

    }
}
