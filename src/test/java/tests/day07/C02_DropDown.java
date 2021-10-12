package tests.day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class C02_DropDown {

    // https://the-internet.herokuapp.com/dropdown adresine gidin.
    //    1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    //    2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    //    3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    //    4.Tüm dropdown değerleri(value) yazdırın
    //    5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.
    WebDriver driver;
    @BeforeMethod


        public void setup(){
            WebDriverManager.chromedriver().setup();
            driver= new ChromeDriver();
            driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);

        }

    @Test
    public void test1(){
        driver.get("https://the-internet.herokuapp.com/dropdown");
WebElement dropDown= driver.findElement(By.id("dropdown"));
        Select select=new Select(dropDown);
select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());

       // Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2"); //index ile secip
        System.out.println(select.getFirstSelectedOption().getText());// get ile yazdiriyorutz

        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());


        //üm dropdown değerleri(value) yazdırın
        List<WebElement> opsiyonlar=select.getOptions();
        System.out.println("tüm opsiyonlar listesi");

        for (WebElement each:opsiyonlar
             ) {
            System.out.println(each.getText());

        }

        //Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.



    }



}
