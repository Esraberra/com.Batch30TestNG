package tests.practise;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Test11 extends TestBase {


    @Test

    public void setUp() throws InterruptedException {


        driver.get("https://books-pwakit.appspot.com/");
        JavascriptExecutor jsExecuter=(JavascriptExecutor) driver;

        WebElement aramaKutusu = (WebElement) jsExecuter.executeScript("return document.querySelector(\"body > book-app\")." +
                "shadowRoot.querySelector(\"#input\")");

        aramaKutusu.sendKeys("Basitmis degil mi?");

        Thread.sleep(3000);
    }
}
