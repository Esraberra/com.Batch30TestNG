package tests.practise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.List;

public class Test3 extends TestBase {

// 1) "https://www.facebook.com/" SAYFASINA GiDiN
    // 2) YENi HESAP OLUSTUR BUTONUNA TIKLAYIN
    // 3) DOGUM TARiHi BOLUMUNDEKi GUNLERiN LiSTESiNi ALIN
    // 4) DOGUM TARiHi BOLUMUNDEKi AYLARIN LiSTESiNi ALIN
    // 5) DOGUM TARiHi BOLUMUNDEKi YILLARIN LiSTESiNi ALIN





//_9407 _5dba _9hk6 _8esg
@Test
    public void test(){
    driver.get("https://www.facebook.com/");
    driver.findElement(By.xpath("//button[@value='1'][2]")).click();
    driver.findElement(By.linkText("Yeni Hesap Oluştur")).click();
   WebElement dropdown= driver.findElement(By.cssSelector("#day"));
    Select select=new Select(dropdown);


    List<WebElement> liste=select.getOptions();
    for (WebElement e:liste
         ) {
        System.out.println(e.getText());

    }


    WebElement month=driver.findElement(By.id("month"));
  Select  select1=new Select(month);
  List<WebElement> listeMonth=select1.getOptions();
    for (WebElement each:listeMonth
         ) {
        System.out.println(each.getText());

    }

WebElement year=driver.findElement(By.id("year"));

    Select select2=new Select(year);

    List<WebElement> listeyear=select2.getOptions();

    for (WebElement e:listeyear
         ) {
        System.out.println("years : " + e.getText());

    }


}







}
