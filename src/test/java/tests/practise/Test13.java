package tests.practise;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Test13 extends TestBase {


    @DataProvider
    public static Object[] aranacakKelimeler(){
        String[] data= new String[]{"Java", "Pyhton", "JavaScript"};


        return data;

    }



    @Test (dataProvider ="aranacakKelimeler")

    public void test(String aranacakKelimeler){
driver.get("https://www.gittigidiyor.com");

WebElement searchBox= driver.findElement(By.xpath("//input[@name='k']"));

searchBox.sendKeys(aranacakKelimeler + Keys.ENTER);



    }





}
