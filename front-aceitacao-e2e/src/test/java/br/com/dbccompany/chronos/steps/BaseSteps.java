package br.com.dbccompany.chronos.steps;

import br.com.dbccompany.chronos.pages.GestorPage;
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
    public static void fazerLoginGestor(){
        LoginPage.preencherEmail(ConfigManipulation.getProp().getProperty("emailGestao"));
        LoginPage.preencherSenha(ConfigManipulation.getProp().getProperty("senhaGestao"));
        LoginPage.clicarEntrar();
    }
    public static void entrarNaPaginaDeEdicoes(){
        GestorPage.clicarBotaoEdicoes();
    }
    public static void fazerLoginAdm(){
        LoginPage.preencherEmail(ConfigManipulation.getProp().getProperty("emailAdm"));
        LoginPage.preencherSenha(ConfigManipulation.getProp().getProperty("senhaAdm"));
        LoginPage.clicarEntrar();
    }
}

