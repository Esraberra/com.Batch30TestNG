package tests.day9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class C04_WindowHandle extends TestBase {

    //● Tests package’inda yeni bir class olusturun: C04_WindowHandle
    //● https://the-internet.herokuapp.com/windows adresine gidin.
    //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    //● Click Here butonuna basın.
    //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
    //● Sayfadaki textin “New Window” olduğunu doğrulayın.
    //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.


@Test
    public void test(){

driver.get("https://the-internet.herokuapp.com/windows");

   WebElement text= driver.findElement(By.tagName("h3"));

   String text1=text.getText();

    SoftAssert softAssert=new SoftAssert();

    softAssert.assertTrue(text1.equals("“Opening a new window”"),"is not verified");




    String actualTitle=driver.getTitle();

    String expectedTitle="The Internet";

    softAssert.assertEquals(actualTitle,expectedTitle,"title is different");


//● Click Here butonuna basın.
    driver.findElement(By.linkText("Click Here")).click();

    //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.

    driver.switchTo().window("");

    String actualYeniTitle= driver.getTitle();

    String expectedYeniTitle="New Window";

    softAssert.assertEquals(actualYeniTitle,expectedYeniTitle,"yeni sayfanin title'i yanlis");

    softAssert.assertAll();

    //● Sayfadaki textin “New Window” olduğunu doğrulayın.
    //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.






}
}