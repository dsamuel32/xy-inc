package br.com.diego.beans;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


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
public class PontoInteresseBean {

    @EJB
    private PontoInteresseRepository pontoInteresseRepository;
    
    public List<PontoInteresse> findAll() {
        return pontoInteresseRepository.findAll();
    }

    public PontoInteresse save(PontoInteresse pontoInteresse) {
       return pontoInteresseRepository.save(pontoInteresse);
    }

    public void delete(Long id) {
        PontoInteresse pontoInteresse = pontoInteresseRepository.findById(id);
        pontoInteresseRepository.delete(pontoInteresse);
    }

    public PontoInteresse update(PontoInteresse pontoInteresse) {
        return pontoInteresseRepository.update(pontoInteresse);
    }

    public PontoInteresse findById(Long id) {
        return pontoInteresseRepository.findById(id);
    }
    
    public List<PontoInteresse> listarPorProximidade(Long coordenadaX, Long coordenadaY, Long distanciaMaxima) {
        List<PontoInteresse> pontos = pontoInteresseRepository.findAll();
        
        return pontos.stream()
                .filter(p -> (Math.abs(p.getCoordenadaX() - coordenadaX) 
                             + Math.abs(p.getCoordenadaY() - coordenadaY)) <= distanciaMaxima)
                .collect(Collectors.toList());
    }
    

}
