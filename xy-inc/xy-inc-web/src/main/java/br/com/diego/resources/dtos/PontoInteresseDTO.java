/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diego.resources.dtos;

import br.com.diego.anotacoes.ValorPositivo;

/**
 *
 * @author Diego NOTE
 */
public class PontoInteresseDTO {
    
    private Long id;
    
    private String nome;
    
    private Long coordenadaX;
    
    private Long coordenadaY;

    public PontoInteresseDTO() {
    }

    public PontoInteresseDTO(Long id, String nome, Long coordenadaX, Long coordenadaY) {
        this.id = id;
        this.nome = nome;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCoordenadaX() {
        return coordenadaX;
    }

    public void setCoordenadaX(Long coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public Long getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaY(Long coordenadaY) {
        this.coordenadaY = coordenadaY;
    }
    
}
