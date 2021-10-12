package homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class C3_DropDownAmazon {
//Bir class oluşturun: C3_DropDownAmazon
// https://www.amazon.com/ adresine gidin.
//- Test 1
//Arama kutusunun yanindaki kategori menusundeki kategori
//sayisinin 45 oldugunu test edin
//-Test 2
//1. Kategori menusunden Books secenegini secin
//2. Arama kutusuna Java yazin ve aratin
//3. Bulunan sonuc sayisini yazdirin
//4. Sonucun Java kelimesini icerdigini test edin


    WebDriver driver;
    @BeforeMethod


    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com/");
    }


    @Test
    public void test1(){
        //1. adim
        WebElement dropDownMenu=driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));
        //.adim
        Select select=new Select(dropDownMenu);
        //3.adim
        List<WebElement> kategorilerMenu=
        select.getOptions();

        Assert.assertEquals(45,kategorilerMenu.size(),"menude 45 option yoktur  ");

    }

@Test
    public void test2(){

        WebElement booksOption=driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));
Select select=new Select(booksOption);
select.selectByValue("search-alias=stripbooks-intl-ship");
// arama kutusunu bulacak java yazip enter a basacak
driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java" + Keys.ENTER);

WebElement javaResults=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
    System.out.println("bulunan java sonuclari : " +javaResults.getText());
    Assert.assertTrue(javaResults.getText().contains("Java"),"Java kelimesini icermiyor");

}
    @AfterClass
    public void tearDown(){

        driver.quit();
    }



}
