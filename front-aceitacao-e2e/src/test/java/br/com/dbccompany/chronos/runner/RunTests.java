package br.com.dbccompany.chronos.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/features",
        tags = {"@whip"},
        glue = "br/com/dbccompany/chronos/steps",
        plugin = { "pretty", "io.qameta.allure.cucumberjvm.AllureCucumberJvm"},
        //plugin = {"json:target/cucumber.json", "pretty","html:target/cucumber-reports"},
        snippets = SnippetType.CAMELCASE
)
public class RunTests {
}
