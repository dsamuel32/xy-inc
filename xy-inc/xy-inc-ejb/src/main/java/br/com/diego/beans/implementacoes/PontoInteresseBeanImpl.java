package br.com.diego.beans.implementacoes;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import br.com.diego.beans.interfaces.PontoInteresseBean;
import br.com.diego.model.PontoInteresse;
import br.com.diego.repository.PontoInteresseRepository;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author martin
 */
@Stateless
public class PontoInteresseBeanImpl implements PontoInteresseBean {

    @EJB
    private PontoInteresseRepository pontoInteresseRepository;
    
    @Override
    public List<PontoInteresse> findAll() {
        return pontoInteresseRepository.findAll();
    }

    @Override
    public PontoInteresse save(PontoInteresse pontoInteresse) {
       return pontoInteresseRepository.save(pontoInteresse);
    }

    @Override
    public PontoInteresse findById(Long id) {
        return pontoInteresseRepository.findById(id);
    }
    
    @Override
    public List<PontoInteresse> filtrarPontosProximos(List<PontoInteresse> pontos, Long coordenadaX, Long coordenadaY, Long distanciaMaxima) {
        return pontos.stream()
                .filter(p -> (Math.abs(p.getCoordenadaX() - coordenadaX) 
                             + Math.abs(p.getCoordenadaY() - coordenadaY)) <= distanciaMaxima)
                .collect(Collectors.toList());
    }
    

}
