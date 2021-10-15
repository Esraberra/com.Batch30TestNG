package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;

public class C05_MouseActions extends TestBase {

    //Yeni bir class olusturalim: C05_MouseActions3
    //1- https://www.amazon.com/ adresine gidelim
    //2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin mouse’u bu menunun ustune getirelim
    //3- “Create a list” butonuna basalim
    //4- Acilan sayfada “Your Lists” yazisi oldugunu test edelim

    @Test
    public void test(){

driver.get("https://www.amazon.com/");

Actions actions=new Actions(driver);

WebElement accountList=driver.findElement(By.id("nav-link-accountList-nav-line-1"));

actions.moveToElement(accountList).perform();

String firstPageHandel=driver.getWindowHandle();

driver.findElement(By.xpath("//span[text()='Create a List']")).click();

String secondPageHandle="";

Set<String> allHandles=driver.getWindowHandles();

        for (String each:allHandles)

        {
            if (!each.equals(firstPageHandel))

            {
                each=secondPageHandle;

            }
        }

        driver.switchTo().window(secondPageHandle);



        WebElement actualText=driver.findElement(By.xpath("//li[@class='a-tab-heading a-active a-size-large']"));

        Assert.assertTrue(actualText.isEnabled());

    }









}
