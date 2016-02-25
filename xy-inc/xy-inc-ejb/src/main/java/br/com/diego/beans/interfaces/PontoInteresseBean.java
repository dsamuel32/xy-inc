/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diego.beans.interfaces;

import br.com.diego.model.PontoInteresse;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Diego NOTE
 */
@Local
public interface PontoInteresseBean {
    
    public List<PontoInteresse> findAll();

    public PontoInteresse save(PontoInteresse pontoInteresse);

    public PontoInteresse findById(Long id);
    
    public List<PontoInteresse> filtrarPontosProximos(List<PontoInteresse> pontos, Long coordenadaX, Long coordenadaY, Long distanciaMaxima);
    
}
