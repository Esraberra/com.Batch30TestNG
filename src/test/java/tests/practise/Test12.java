package tests.practise;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Test12 extends TestBase {


    @Test

    public void setUp(){
driver.get("https://www.facebook.com");

        JavascriptExecutor js=(JavascriptExecutor) driver;
        driver.findElement(By.xpath("//*[.='Tüm Çerezlere İzin Ver']")).click();

        js.executeScript("document.getElementById('email').value='deneme@abc.com';");
        //value='123456'; locate edilen yere deger gönderir. senKeys islevini görür
        js.executeScript("document.getElementById('pass').value='123456';");


    }





}
