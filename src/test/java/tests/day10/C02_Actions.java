package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02_Actions extends TestBase {

    @Test
    public void test()

    {

        driver.get("https://amazon.com");

        WebElement searchbox= driver.findElement(By.id("twotabsearchtextbox"));

        searchbox.sendKeys("Nutella" + Keys.ENTER);

        driver.findElement(By.xpath("(//span[@class='data-image-index'])[9]")).click();
    }






















}
