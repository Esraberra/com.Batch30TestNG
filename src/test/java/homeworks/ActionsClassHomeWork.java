package homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class ActionsClassHomeWork extends TestBase {
/*
    Yeni Class olusturun ActionsClassHomeWork
1- "http://webdriveruniversity.com/Actions" sayfasina gidin
//2- Hover over Me First" kutusunun ustune gelin
//4- Popup mesajini yazdirin
//5- Popup'i tamam diyerek kapatin
 //6- “Click and hold" kutusuna basili tutun
    // 7-“Click and hold" kutusunda cikan yaziyi yazdirin
         //8- “Double click me" butonunu cift tiklayin
*/

    @Test

    public void test() throws InterruptedException

    {

driver.get("http://webdriveruniversity.com/Actions");

        Actions actions=new Actions(driver);

        WebElement HoverOver= driver.findElement(By.xpath("//button[@class='dropbtn']"));

        actions.moveToElement(HoverOver).perform();

        WebElement link1= driver.findElement(By.xpath("//a[@href='#']"));

        actions.click(link1).perform();

        System.out.println(driver.switchTo().alert().getText());

        Thread.sleep(2000);

        driver.switchTo().alert().accept();


        WebElement clickandholdButton= driver.findElement(By.id("click-box"));


        actions.clickAndHold(clickandholdButton).perform();

        Thread.sleep(2000);


        System.out.println(clickandholdButton.getText());

        actions.doubleClick(driver.findElement(By.tagName("h2"))).perform();



    }








}
