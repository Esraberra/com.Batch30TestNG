package homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

import javax.swing.*;

public class MouseAction extends TestBase {


    //https://www.facebook.com
    //new account button click
    //name surname mail and password boxes fill
    //register


    @Test

    public void test() throws InterruptedException


    {


        driver.get("https://www.facebook.com");

      driver.findElement(By.xpath("//button[text()='Tüm Çerezlere İzin Ver']")).click();;


      driver.findElement(By.xpath("//*[text()='Yeni Hesap Oluştur']")).click();


      Actions actions=new Actions(driver);


      WebElement name= driver.findElement(By.xpath("//input[@placeholder='Adın']"));


      Thread.sleep(3000);


      actions.sendKeys("Esra", Keys.TAB)

        .sendKeys("Kücük",Keys.TAB)

        .sendKeys("ESRA@hotmail.com",Keys.TAB)

        .sendKeys("",Keys.TAB)

        .sendKeys("1234567",Keys.TAB)

        .perform();


      driver.findElement(By.xpath("//button[text()='Kaydol']")).click();










    }










}
