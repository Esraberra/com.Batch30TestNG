package homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.List;

public class IframeTest02 extends TestBase {
//http://demo.guru99.com/test/guru99home/
    @Test
    public void Test(){

        driver.navigate().to("http://demo.guru99.com/test/guru99home/");

     List<WebElement> iframeList=driver.findElements(By.tagName("iframe"));

       System.out.println(iframeList.size());

       driver.switchTo().frame(0);

        driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']")).click();    //button[@class='ytp-large-play-button ytp-button']


        driver.switchTo().parentFrame();

        driver.switchTo().frame(1);

        driver.findElement(By.xpath("//img[@src='Jmeter720.png']")).click();

    }











}
