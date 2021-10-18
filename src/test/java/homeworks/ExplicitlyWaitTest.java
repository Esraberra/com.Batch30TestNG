package homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class ExplicitlyWaitTest extends TestBase {

/*
Bir class olusturun : ExplicitlyWaitTest
2. Bir metod olusturun : enableTest()
3. https://demoqa.com/dynamic-properties adresine gidin.
4. Will enable 5 seconds’in etkin olmadigini(enabled) test edin
5.// Will enable 5 seconds etkin oluncaya kadar bekleyin ve enabled oldugunu test edin
6. Bir metod olusturun : visibleTest()
7. Ayni sayfaya tekrar gidin, Visible After 5 Seconds butonunun gorunmesini bekleyin,
ve gorunur oldugunu test edin
 */
    @Test
    public void enableTest()

    {

      driver.get("https://demoqa.com/dynamic-properties");

       WebElement firstButton= driver.findElement(By.xpath("//button[text()='Will enable 5 seconds']"));

        Assert.assertTrue(!firstButton.isEnabled(),"is enabled Failed");
// Will enable 5 seconds etkin oluncaya kadar bekleyin ve enabled oldugunu test edin

        WebDriverWait wait=new WebDriverWait(driver,20);

        WebElement    firstButton1=driver.findElement(By.id("enableAfter"));


        wait.until(ExpectedConditions.elementToBeClickable(firstButton1));

        Assert.assertTrue(firstButton1.isEnabled(), "is not enabled FAILED");

    }


@Test
    public void visibleTest()

{
    driver.get("https://demoqa.com/dynamic-properties");

    WebElement visibleAfterButton=driver.findElement(By.id("visibleAfter"));

WebDriverWait wait=new WebDriverWait(driver, 10);

 wait.until(ExpectedConditions.elementToBeClickable(visibleAfterButton));

 Assert.assertTrue(visibleAfterButton.isEnabled(),"FAILED Button is not enabled");
}





}
