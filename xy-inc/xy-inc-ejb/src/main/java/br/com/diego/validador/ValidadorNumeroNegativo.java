/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diego.validador;

import br.com.diego.anotacoes.ValorPositivo;
import br.com.diego.exceptions.CamposInvalidosException;
import br.com.diego.utils.StringUtils;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diego NOTE
 */
public class ValidadorNumeroNegativo extends Validador <ValorPositivo> {
    
    private Class<ValorPositivo> anotacao;

    public ValidadorNumeroNegativo() {
        anotacao = (Class<ValorPositivo>) getTypeClass();
    }
    
    @Override
    public void validacao(Object objeto, String mensagem) 
            throws IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, CamposInvalidosException {

        Field[] fields = objeto.getClass().getDeclaredFields();
        List<String> camposInvalidos = new ArrayList<>();
        
        for (Field field : fields) {
            if (field.isAnnotationPresent(anotacao)) {
                adicionarCampoInvalido(camposInvalidos, field, objeto);
            }
        }

        if (!camposInvalidos.isEmpty()) {
            throw new CamposInvalidosException(mensagem + ": " + StringUtils.formatarListToString(camposInvalidos));
        }

    }

    private void adicionarCampoInvalido(List<String> camposInvalidos, Field field, Object objeto) throws IllegalArgumentException, IllegalAccessException {
        field.setAccessible(true);
        System.out.println(">>>>>>>>>>>>>" + field.getLong(objeto));
        if (field.get(objeto) == null || field.getLong(objeto) < 0) {
            camposInvalidos.add(field.getName());
        }
//        field.setAccessible(false);
    }

}
