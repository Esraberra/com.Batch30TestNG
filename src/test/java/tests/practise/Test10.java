package tests.practise;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Test10 extends TestBase {

@Test
    public void Setup() throws InterruptedException {
    driver.get("https://shop.polymer-project.org/");

    Thread.sleep(3000);

    JavascriptExecutor jsExecutor=(JavascriptExecutor) driver;
    WebElement shopNowButton=(WebElement) jsExecutor.executeScript(
            "return document.querySelector(\"body > shop-app\")." +
                    "shadowRoot.querySelector(\"iron-pages > shop-home\")." +

                    "shadowRoot.querySelector(\"div:nth-child(2) > shop-button > a\")");
shopNowButton.click();
Thread.sleep(3000);

}

}
