package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;

public class C03_MouseActions1 extends TestBase {

    //1- Yeni bir class olusturalim: C03_MouseActions1
    //2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
    //3- Cizili alan uzerinde sag click yapalim
    //4- Alert’te cikan yazinin “You selected a context menu” oldugunu
    //   test edelim.
    //5- Tamam diyerek alert’I kapatalim
    //6- Elemental Selenium linkine tiklayalim
    //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim

@Test
    public void test()
{

    driver.get("https://the-internet.herokuapp.com/context_menu");

   Actions actions=new Actions(driver);

   WebElement ciziliAlan=driver.findElement(By.id("hot-spot"));

  actions.contextClick(ciziliAlan).perform();


  String expectedAlertMessage="You selected a context menu";

  String actualAlertYazi=driver.switchTo().alert().getText();

    Assert.assertEquals(actualAlertYazi,expectedAlertMessage,"the massages are not same");

    driver.switchTo().alert().accept();

    String actualWindowHandle=driver.getWindowHandle();

driver.findElement(By.xpath("//a[text()='Elemental Selenium']")).click();

    Set<String> windowHandles=driver.getWindowHandles();

           String secondPageHandle="";

    for (String each:windowHandles)

    {
        if (!each.equals(actualWindowHandle))

        {

            secondPageHandle=each;

        }

    }
         driver.switchTo().window(secondPageHandle);

        String expextedSecondPageText="Elemantal Selenium";

        String actualSecondPageText=driver.findElement(By.tagName("h1")).getText();

        Assert.assertEquals(actualSecondPageText,expextedSecondPageText,
            "second page text is different actualtext one");





}















}
