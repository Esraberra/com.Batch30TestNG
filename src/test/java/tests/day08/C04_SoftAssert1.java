package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class C04_SoftAssert1 {
    //Yeni bir Class Olusturun : D11_SoftAssert1
    //1.“https://www.hepsiburada.com/” Adresine gidin
    //2.Basliginin “Turkiye’nin En Buyuk Alisveris Sitesi" icerdigini dogrulayin
    //3.search kutusuna araba yazip arattirin
    //4.bulunan sonuc sayisini yazdirin
    //5.sonuc yazisinin "araba" icerdigini dogrulayin
    //6.Sonuc yazisinin “oto” kelimesi icermedigini dogrulayin

    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }
    @Test
    public void test() {
        driver.get("http://hepsiburada.com/");
        //verify edin diyorsa soft assert kullanin
        String expectedTitle= "Turkiye’nin En Buyuk Alisveris Sitesi";
        String actualBaslik=driver.getTitle();
        SoftAssert softAssert=new SoftAssert();
       softAssert.assertTrue(actualBaslik.equals(expectedTitle),"baslik beklenen ile eslesmedi");


        driver.findElement(By.xpath("//input[@class='desktopOldAutosuggestTheme-input']")).sendKeys("araba"+ Keys.ENTER);
        //bulunan sonuc sayisini yazdirin
        WebElement sonucYazisiElementi=driver.findElement(By.className("category-suggestion-title"));
        System.out.println(sonucYazisiElementi.getText());
//5.sonuc yazisinin "araba" icerdigini dogrulayin
        softAssert.assertTrue(sonucYazisiElementi.getText().contains("araba"),",\" araba kelimesini icermiyor\"");

        //Sonuc yazisinin “oto” kelimesi icermedigini dogrulayin
        softAssert.assertFalse(sonucYazisiElementi.getText().contains("oto"),"sonuc yazisi oto iceriyor");

        softAssert.assertAll();
    }







    @AfterClass
    public void tearDown(){
        //driver.close();
    }
}