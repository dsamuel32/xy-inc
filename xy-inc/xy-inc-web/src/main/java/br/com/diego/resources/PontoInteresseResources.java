/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diego.resources;

import br.com.diego.beans.interfaces.PontoInteresseBean;
import br.com.diego.exceptions.CamposInvalidosException;
import br.com.diego.model.PontoInteresse;
import br.com.diego.resources.dtos.PontoInteresseDTO;
import br.com.diego.resources.utils.ConversorUtil;
import br.com.diego.validador.Validador;
import br.com.diego.validador.ValidadorNumeroNegativo;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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

        return Response.ok(ConversorUtil.converter(todosPontos)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(PontoInteresseDTO pontoInteresseDTO) throws IllegalAccessException {

        PontoInteresse pontoInteresse = (PontoInteresse) ConversorUtil.converter(pontoInteresseDTO, PontoInteresse.class);
        pontoInteresse = pontoInteresseBean.save(pontoInteresse);
        return Response.ok(ConversorUtil.converter(pontoInteresse, PontoInteresseDTO.class)).build();

    }

}
