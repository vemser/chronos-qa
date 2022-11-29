package br.com.dbccompany.chronos.testes.frontend.steps;

import br.com.dbccompany.chronos.testes.frontend.utils.Browser;
import org.junit.After;
import org.junit.Before;

public class BaseSteps extends Browser {
    @Before
    public void abrirNavegador(){
        browserUp("https://chronos-vemser.vercel.app/");
    }
    @After
    public void fecharNavegador(){
        browserDown();
    }
}

