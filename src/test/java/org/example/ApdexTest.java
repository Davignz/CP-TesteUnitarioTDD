// Davi Gonzaga Ferreira - RM 554890
package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ApdexTest {

    private Apdex apdex;

    @BeforeEach
    public void setup() {
        apdex = new Apdex(554890, 500000, 30000, 24860);
    }

    @Test
    public void testCalculoApdex() {
        double resultado = apdex.calcularApdex();
        assertTrue(resultado >= 0 && resultado <= 1, "Apdex deve estar entre 0 e 1");
    }

    @Test
    public void testClassificacaoExcelente() {
        Apdex apdexExcelente = new Apdex(554890, 554000, 500, 390);
        assertEquals("Excelente", apdexExcelente.classificarApdex());
    }

    @Test
    public void testClassificacaoBom() {
        Apdex apdexBom = new Apdex(554890, 470000, 30000, 54890);
        assertEquals("Bom", apdexBom.classificarApdex());
    }

    @Test
    public void testClassificacaoRegular() {
        Apdex apdexRegular = new Apdex(554890, 400000, 40000, 114890);
        assertEquals("Regular", apdexRegular.classificarApdex());
    }

    @Test
    public void testClassificacaoRuim() {
        Apdex apdexRuim = new Apdex(554890, 200000, 50000, 304890);
        assertEquals("Ruim", apdexRuim.classificarApdex());
    }

    @Test
    public void testTotalAmostrasInvalido() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Apdex(0, 10, 5, 2).calcularApdex();
        });
        assertEquals("Total de amostras deve ser > 0", exception.getMessage());
    }
}
