package br.com.dbccompany.chronos.testes.runners;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages("br.com.dbccompany.chronos.testes")
@IncludeTags("todos")
public class TodosOsTestesRunner {

}
