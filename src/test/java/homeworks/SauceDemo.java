package homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class SauceDemo {
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
    public void test()
    {

        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.xpath("//input[@type='submit']")).click();


        List<WebElement> priceList=driver.findElements(By.xpath("//div[@class='inventory_item_price']"));


        List<String> pricesNumbers=new ArrayList<>();


               for (WebElement each:priceList)

              {
                 pricesNumbers.add(each.getText());

              }


        System.out.println("****************************************");
// Double type a list created and convert String data to Double and add them to Double ArrayList

        List<Double> doublePrices=new ArrayList<>();

                for (String each:pricesNumbers)
              {

                  doublePrices.add(Double.parseDouble(each.substring(1))) ;

              }

Collections.sort(doublePrices);

       System.out.println(doublePrices);
       List<Double> expectedDoubleNumbers = Arrays.asList(7.99, 9.99, 15.99, 15.99, 29.99, 49.99);

        SoftAssert softAssert=new SoftAssert();


      softAssert.assertTrue(expectedDoubleNumbers.equals(doublePrices),"the result is not verified with expectednumbers");

        softAssert.assertAll();



    }





@AfterClass
    public void tearDownn(){

        driver.close();
}








}
