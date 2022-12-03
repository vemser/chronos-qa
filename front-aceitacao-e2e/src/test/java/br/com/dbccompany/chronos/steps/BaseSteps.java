package br.com.dbccompany.chronos.steps;

import br.com.dbccompany.chronos.pages.LoginPage;
import br.com.dbccompany.chronos.utils.Browser;
import br.com.dbccompany.chronos.utils.ConfigManipulation;
import org.junit.After;
import org.junit.Before;

public class BaseSteps extends Browser {
    @Before
    public void abrirNavegador(){
        browserUp("http://vemser-dbc.dbccompany.com.br:39000/vemser/chronos-front");
    }
    @After
    public void fecharNavegador(){
        browserDown();
    }
    public void fazerLoginGestor(){
        LoginPage.preencherEmail(ConfigManipulation.getProp().getProperty("emailGestao"));
        LoginPage.preencherSenha(ConfigManipulation.getProp().getProperty("senhaGestao"));
        LoginPage.clicarEntrar();
    }
    public void fazerLoginAdm(){
        LoginPage.preencherEmail(ConfigManipulation.getProp().getProperty("emailAdm"));
        LoginPage.preencherSenha(ConfigManipulation.getProp().getProperty("senhaAdm"));
        LoginPage.clicarEntrar();
    }
    public void fazerLoginTeste(){
        LoginPage.preencherEmail(ConfigManipulation.getProp().getProperty("emailTeste"));
        LoginPage.preencherSenha(ConfigManipulation.getProp().getProperty("senhaTeste"));
        LoginPage.clicarEntrar();
    }

}

