package br.com.dbccompany.chronos.steps;

import br.com.dbccompany.chronos.utils.Browser;
import cucumber.api.java.Before;
import cucumber.api.java.After;

public class BaseSteps extends Browser {
    @Before
    public void abrirNavegador(){
        browserUp("http://vemser-dbc.dbccompany.com.br:39000/vemser/chronos-front");
    }
    @After
    public void fecharNavegador(){
        browserDown();
    }
}

