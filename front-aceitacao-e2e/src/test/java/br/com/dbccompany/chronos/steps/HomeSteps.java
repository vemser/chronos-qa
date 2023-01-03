package br.com.dbccompany.chronos.steps;

import br.com.dbccompany.chronos.pages.HomePage;
import cucumber.api.java.pt.E;

public class HomeSteps {
    @E("entre na pagina de colaboradores")
    public void clicarEntrarPaginaColaboradores(){
        HomePage.clicarBtnColaboradores();
    }
    @E("entre na pagina de edicoes")
    public void clicarEntrarPaginaEdicoes(){
        HomePage.clicarBtnEdicoes();
    }
}
