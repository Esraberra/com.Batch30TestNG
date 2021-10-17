package homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.util.Set;

public class DemoGuru2 extends TestBase {

     /*
      go to url : http://demo.guru99.com/popup.php
      get the first window
      clicking on click here button
      get all the window in the set
      switch to window
      input email id (somepne@gmail.com) and type something in that input
      Clicking on the submit button
      verify title as expected
      switch to first window

     */

    @Test
    public void test() throws InterruptedException {
        driver.get("http://demo.guru99.com/popup.php");

        String firstPageHandle= driver.getWindowHandle();

        driver.findElement(By.linkText("Click Here")).click();



        Set<String> allHandles= driver.getWindowHandles();

        String secondPageHandle="";

        for (String each:allHandles)
        {
            if (!each.equals(firstPageHandle))
            {
                secondPageHandle=each;

            }

        }
        driver.switchTo().window(secondPageHandle);

        String expectedTitle="Guru99 Bank Home Page";

        SoftAssert softAssert=new SoftAssert();

        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("esrasey_men@yahoo.com"+ Keys.ENTER);

       softAssert.assertEquals(driver.getTitle(),expectedTitle,"Titles are not same");

Thread.sleep(3000);

        driver.switchTo().window(firstPageHandle);

        softAssert.assertAll();

    }
























}
