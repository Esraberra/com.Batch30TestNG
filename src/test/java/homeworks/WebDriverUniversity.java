package homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;

public class WebDriverUniversity extends TestBase {

/*
“ http://webdriveruniversity.com/IFrame/index.html ” sayfasina gidin

“Our Products” butonuna basin

“Cameras product”i tiklayin

Popup mesajini yazdirin

“close” butonuna basin

"WebdriverUniversity.com (IFrame)" linkini tiklayin

"http://webdriveruniversity.com/index.html" adresine gittigini test edin
 */








    @Test
    public void test() throws InterruptedException
    {

        driver.get("http://webdriveruniversity.com/IFrame/index.html");

        WebElement iframe= driver.findElement(By.id("frame"));

        driver.switchTo().frame(iframe);

        driver.findElement(By.xpath("//a[@href='products.html']")).click();

        driver.findElement(By.id("camera-img")).click();

        Thread.sleep(3000);

        System.out.println(driver.findElement(By.tagName("h4")).getText());

        driver.findElement(By.xpath("//button[text()='Close']")).click();
       // Thread.sleep(3000);

        driver.switchTo().defaultContent();

        Thread.sleep(3000);



        driver.findElement(By.xpath("//a[@class='navbar-brand']")).click();

        WebElement secondIframe=driver.findElement(By.id("udemy-promo-video"));

        driver.switchTo().frame(secondIframe);

WebElement expectedResponse= driver.findElement(By.xpath("//h1[text()='Sorry']"));

        System.out.println(expectedResponse.getText());


        Assert.assertTrue(expectedResponse.isEnabled(),"failed");






    }

}
