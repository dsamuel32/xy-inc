/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.diego.beans;

import br.com.diego.beans.implementacoes.PontoInteresseBeanImpl;
import br.com.diego.beans.interfaces.PontoInteresseBean;
import br.com.diego.model.PontoInteresse;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

/**
 *
 * @author Diego NOTE
 */
public class PontoInteresseBeanImplTest {

    private static final Long ID = 8L;
    private static final String NOME = "Cinema";
    private static final Long COORDENADA_X = 49L;
    private static final Long COORDENADA_Y = 79L;

    @Mock
    private PontoInteresseBean pontoInteresseBean;

    public PontoInteresseBeanImplTest() {
    }

    @Before
    public void setUp() throws NamingException {
        List<PontoInteresse> pontoInteresses = criarListaPontoInteresse();
        PontoInteresse pontoInteresseBuscarPorId = criarPontoInteresseBuscarPorId();
        PontoInteresse pontoInteresseSalvar = criarPontoInteresseSalvar();

        pontoInteresseBean = Mockito.mock(PontoInteresseBeanImpl.class);

        when(pontoInteresseBean.findAll()).thenReturn(pontoInteresses);
        when(pontoInteresseBean.findById(1L)).thenReturn(pontoInteresseBuscarPorId);
        when(pontoInteresseBean.save(new PontoInteresse())).thenReturn(pontoInteresseSalvar);
        when(pontoInteresseBean.filtrarPontosProximos(criarListaPontoInteresse(), 20L, 10L, 10L)).thenReturn(pontosProximos());

    }

    private PontoInteresse criarPontoInteresseSalvar() {
        return new PontoInteresse(ID, NOME, COORDENADA_X, COORDENADA_Y);
    }

    private PontoInteresse criarPontoInteresseBuscarPorId() {
        List<PontoInteresse> pontosInteresses = criarListaPontoInteresse();
        return pontosInteresses.get(0);
    }

    private List<PontoInteresse> criarListaPontoInteresse() {
        List<PontoInteresse> pontosInteresses = new ArrayList<>();
        pontosInteresses.add(new PontoInteresse(1L, "Lanchonete", 27L, 12L));
        pontosInteresses.add(new PontoInteresse(2L, "Posto", 31L, 18L));
        pontosInteresses.add(new PontoInteresse(3L, "Joalheria", 15L, 12L));
        pontosInteresses.add(new PontoInteresse(4L, "Floricultura", 19L, 21L));
        pontosInteresses.add(new PontoInteresse(5L, "Pub", 12L, 8L));
        pontosInteresses.add(new PontoInteresse(6L, "Supermercado", 23L, 6L));
        pontosInteresses.add(new PontoInteresse(7L, "Churrascaria", 28L, 2L));
        return pontosInteresses;
    }

    private List<PontoInteresse> pontosProximos() {
        List<PontoInteresse> pontosInteresses = new ArrayList<>();
        pontosInteresses.add(new PontoInteresse(1L, "Lanchonete", 27L, 12L));
        pontosInteresses.add(new PontoInteresse(3L, "Joalheria", 15L, 12L));
        pontosInteresses.add(new PontoInteresse(4L, "Floricultura", 19L, 21L));
        pontosInteresses.add(new PontoInteresse(6L, "Supermercado", 23L, 6L));
        return pontosInteresses;
    }

    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");

        List<PontoInteresse> expResult = criarListaPontoInteresse();
        List<PontoInteresse> result = pontoInteresseBean.findAll();
        assertEquals(expResult, result);
        assertEquals(expResult.size(), result.size());
    }

    @Test
    public void testSave() throws Exception {
        System.out.println("save");

        List<PontoInteresse> pontosInteresses = criarListaPontoInteresse();

        PontoInteresse expResult = criarPontoInteresseSalvar();

        PontoInteresse pontoInteresse = new PontoInteresse(null, NOME, COORDENADA_X, COORDENADA_Y);

        PontoInteresse result = pontoInteresseBean.save(pontoInteresse);

        assertEquals(expResult, result);
    }

    @Test
    public void testFindById() throws Exception {
        System.out.println("findById");
        PontoInteresse expected = criarPontoInteresseBuscarPorId();

        PontoInteresse result = pontoInteresseBean.findById(1L);

        assertEquals(expected, result);

    }

    @Test
    public void testListarPorProximidade() throws Exception {
        System.out.println("listarPorProximidade");
       
        List<PontoInteresse> expected = pontosProximos();
        
        List<PontoInteresse> result = pontoInteresseBean.filtrarPontosProximos(criarListaPontoInteresse(), 20L, 10L, 10L);
        
        assertEquals(expected, result);
    }

}
