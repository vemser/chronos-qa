package br.com.dbccompany.chronos.utils;

import br.com.dbccompany.chronos.steps.BaseSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class Elements extends BaseSteps {
    public static WebElement element(By element){
        return Browser.driver.findElement(element);
    }
    public static WebElement lastElement(By element){
        List<WebElement> elements = driver.findElements(element);
        return elements.get(elements.size()-1);
    }

    public static void waitElement(By element){
        Browser.wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }
}
