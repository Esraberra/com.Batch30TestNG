package tests.day9;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class C01_Alert {

    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

    }
    @Test
    public void acceptAlert() throws InterruptedException {

        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
// okey butonuna basmak

        driver.switchTo().alert().accept();

        Thread.sleep(5000);

        WebElement alertMessage=driver.findElement(By.id("result"));

        String expectedMessage="You successfully clicked an alert";

        Assert.assertEquals(alertMessage.getText(),expectedMessage,"result text is not same with expected one");
    }


    @Test
    public void dismissAlert(){

        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();

        driver.switchTo().alert().dismiss();


        WebElement actualCancelMessage=driver.findElement(By.id("result"));


        String unexpectedMessage="successfuly";


       Assert.assertFalse(actualCancelMessage.getText().contains(unexpectedMessage),"failed DOES contain!!");



    }


    @Test
    public void sendKeysAllert() throws InterruptedException {

        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();

        driver.switchTo().alert().sendKeys("Esra");

        Thread.sleep(3000);

        driver.switchTo().alert().accept();


        WebElement resultText=driver.findElement(By.id("result"));

        SoftAssert softAssert=new SoftAssert();
        //softAssert.assertTrue(resultText.isDisplayed(),"fail");
        softAssert.assertTrue(resultText.getText().contains("Esra"),"your name is NOT displayed");

        softAssert.assertAll();
    }


}
