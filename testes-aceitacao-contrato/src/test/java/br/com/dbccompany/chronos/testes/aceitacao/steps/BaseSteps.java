package br.com.dbccompany.chronos.testes.aceitacao.steps;

import br.com.dbccompany.chronos.testes.aceitacao.utils.Browser;
import org.junit.After;
import org.junit.Before;

public class BaseSteps extends Browser {
    @Before
    public void abrirNavegador(){
        browserUp("");
    }
    @After
    public void fecharNavegador(){
        browserDown();
    }
}

