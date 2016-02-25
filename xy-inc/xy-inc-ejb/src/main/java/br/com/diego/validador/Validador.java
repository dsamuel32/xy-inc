/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diego.validador;

import br.com.diego.exceptions.CamposInvalidosException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;

/**
 *
 * @author Diego NOTE
 */
public abstract class Validador <T> {
    
    public abstract void validacao(Object objeto, String mensagem) 
            throws IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, CamposInvalidosException;
    
    protected Class<?> getTypeClass() {
        Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
        return clazz;
    }
    
}
