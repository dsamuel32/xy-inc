/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diego.resources.utils;

import br.com.diego.model.PontoInteresse;
import br.com.diego.resources.dtos.PontoInteresseDTO;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import java.lang.reflect.Type;

/**
 *
 * @author Diego NOTE
 */
public class ConversorUtil {

    public static List<PontoInteresseDTO> converter(List<PontoInteresse> pontosInteresses) {
        List<PontoInteresseDTO> pontos = new ArrayList<>();

        for (PontoInteresse pontoInteresse : pontosInteresses) {
            pontos.add((PontoInteresseDTO) converter(pontoInteresse, PontoInteresseDTO.class));
        }

        return pontos;

    }

    public static <T> T converter(Object source, Class<T> target) {

        if (source == null) {
            return null;
        }

        ModelMapper map = new ModelMapper();
        map.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        T retorno = map.map(source, target);

        return retorno;
    }

}
