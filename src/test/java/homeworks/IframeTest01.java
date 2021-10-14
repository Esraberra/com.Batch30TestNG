package homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IframeTest01 extends TestBase {

    //go to web site : https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
    //maximize the web site
    //click on second emoji
    //click all second emoji's element
    //go back parent iframe
    //fill out the form,(Fill the form with the texts you want)
    //click on apply button


    @Test
    public void test() throws InterruptedException {

        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");

       driver.manage().window().maximize();   //div[@id='nature']//div

        driver.switchTo().frame("emoojis");

        driver.findElement(By.xpath(" //a[@href='#nature']")).click();

      List<WebElement> allEmojis=driver.findElements(By.xpath("//div[@class='mdl-tabs__panel is-active']/div/img"));

        for (WebElement each:allEmojis)
        {
            each.click();

        }

        //go back parent iframe

        driver.switchTo().defaultContent();

      List<WebElement> text=  driver.findElements(By.xpath("//*[@data-upgraded=',MaterialTextfield']/input"));


        List<String> words= Arrays.asList("Plan", "Zeytin","Frühstück","Java","Selenium","Deutschland","Türkei","Developer","Test","QA","Maven");

     //  bir string list var oraya text e eklenecek kelimeler yazdim her birine indexiyle ularisim.
      // text in icine  send yaparim


        for (int i = 0; i < text.size(); i++) {

            text.get(i).sendKeys(words.get(i));

        }
        try {

            Thread.sleep(2000);

        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

//button[text()='Apply']

        driver.findElement(By.xpath("//button[text()='Apply']")).click();
        //


    }















}
