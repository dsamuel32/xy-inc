/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diego.exceptions;

/**
 *
 * @author Diego NOTE
 */
public class CamposInvalidosException extends RuntimeException {

    public CamposInvalidosException(String message) {
        super(message);
    }

    public CamposInvalidosException() {
        super("Campos Inválidos");
    }
    
    
    
}
