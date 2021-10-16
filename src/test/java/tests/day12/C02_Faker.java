package tests.day12;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02_Faker extends TestBase {


    @Test
    public void test() throws InterruptedException {

        driver.get("https://facebook.com");
        driver.findElement(By.xpath("//button[text()='Tüm Çerezlere İzin Ver']")).click();;


        driver.findElement(By.xpath("//*[text()='Yeni Hesap Oluştur']")).click();
        WebElement nameKutusu=driver.findElement(By.xpath("//input[@name='firstname']"));
        Faker faker=new Faker();
        String email=faker.internet().emailAddress();
        Actions actions=new Actions(driver);
        actions
                .click(nameKutusu)
                .sendKeys(faker.name().name())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(String.valueOf(faker.number().numberBetween(1,31)))
                .sendKeys(Keys.TAB)
                .sendKeys("May")
                .sendKeys(Keys.TAB)
                .sendKeys(String.valueOf(faker.number().numberBetween(1955,2001)))
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.ARROW_LEFT)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).perform();
        Thread.sleep(15000);
        actions.sendKeys(Keys.ENTER)
                .perform();
        //Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        //Sayfayi kapatin
    }
}