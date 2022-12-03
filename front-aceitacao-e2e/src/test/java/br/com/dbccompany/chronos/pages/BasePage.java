package br.com.dbccompany.chronos.pages;
import br.com.dbccompany.chronos.utils.Browser;
import br.com.dbccompany.chronos.utils.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

public class BasePage extends Elements {
    public static final By toastMessage =
            By.cssSelector("div.Toastify__toast-body > div:nth-child(2)");
    public static void click(By by){
        waitElement(by);
        element(by).click();
    }
    public static void scrollBy(String pxQnt){
        JavascriptExecutor js = (JavascriptExecutor) Browser.driver;
        js.executeScript("window.scrollBy("+pxQnt+",0)", "");

    }
    public static void sendKeys(By by, String texto){
        waitElement(by);
        element(by).sendKeys(texto);
    }

    public static String getText(By by){
        waitElement(by);
        return element(by).getText();
    }

    public static void moveToElement(By by){
        waitElement(by);
        Actions action = new Actions(Browser.driver);
        action.moveToElement(element(by));
        action.build().perform();
    }

    public static String getUrl(){
        return Browser.driver.getCurrentUrl();
    }
    public static void moveToElementAndClick(By by){
        waitElement(by);
        Actions action = new Actions(Browser.driver);
        action.moveToElement(element(by));
        action.click().build().perform();
    }

    public static void clearElement(By by){
        element(by).clear();
    }

    public static boolean checkElementDisplayStatus(By by){
        waitElement(by);
        return element(by).isDisplayed();
    }

    public static boolean checkElementIsEnable(By by){
        waitElement(by);
        return element(by).isEnabled();
    }
    public static String getElementValue(By by){
        waitElement(by);
        return element(by).getAttribute("value");
    }
    public static String getPageUrl(){
        return Browser.driver.getCurrentUrl();
    }

    public static boolean checkElementTextContains(By by, String text){
        waitElement(by);
        return element(by).getText().contains(text);
    }
}