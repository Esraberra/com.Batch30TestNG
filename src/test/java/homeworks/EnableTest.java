package homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class EnableTest extends TestBase {

    /*
    1 bir method olustur
    2 https://the-internet.herokuapp.com/dynamic_controls
    Textbox’in etkin olmadigini(enabled) dogrulayın

5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin

6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.

7. Textbox’in etkin oldugunu(enabled) dogrulayın.
     */


@Test
    public void test() throws InterruptedException {


    driver.get("https://the-internet.herokuapp.com/dynamic_controls");

    WebElement textBox= driver.findElement(By.xpath("//input[@type='text']"));
    SoftAssert softAssert= new SoftAssert();

    softAssert.assertTrue(!textBox.isEnabled(),"texbox is enabled Failed");
////////////////////////////////////////////////////////////////////////
    //with explicitly wait
    WebDriverWait wait=new WebDriverWait(driver,20);


    driver.findElement(By.xpath("//button[@onclick='swapInput()']")).click();

    WebElement messageAfterClick= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));


    softAssert.assertTrue(messageAfterClick.isEnabled(),"texbox is  NOT!!! enabled Failed");

    softAssert.assertAll();

}









}
