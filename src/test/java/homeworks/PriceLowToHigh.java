package homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PriceLowToHigh {



    /**
     * Navigate to  https://www.saucedemo.com/
     * Enter the user name  as standard_user
     * Enter the password as   secret_sauce
     * Click on login button
     * Choose price low to high
     * Verify item prices are sorted from low to high
     */
    WebDriver driver;
    private Object Comparator;

    @BeforeClass

    public void setup()
    {

        WebDriverManager.chromedriver().setup();

        driver=new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.manage().window().maximize();

    }

    @Test
    public void test() {

        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.xpath("//input[@type='submit']")).click();


        WebElement dropDown=driver.findElement(By.xpath("//select[@class='product_sort_container']"));

        Select select=new Select(dropDown);

        select.selectByValue("lohi");

        WebElement firstLowPriceProductName=driver.findElement(By.xpath("//div[@class='inventory_item_name']"));

        String actualFirstProductName= firstLowPriceProductName.getText();

        String expectedFirstProductName="Sauce Labs Onesie";


        SoftAssert softAssert=new SoftAssert();

        softAssert.assertTrue(actualFirstProductName.equals(expectedFirstProductName),"Assertion is not verified");


        softAssert.assertAll();



    }





    @AfterClass
    public void tearDownn(){

        driver.close();
    }








}


















