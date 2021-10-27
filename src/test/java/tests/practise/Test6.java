package tests.practise;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Test6 extends TestBase {


// "http://automationpractice.com/" ADRESiNE GiDiP UYE OL.

@Test

    public void test(){
    driver.get("http://automationpractice.com/");
driver.findElement(By.partialLinkText("Sign in")).click();
driver.findElement(By.id("email_create")).sendKeys("esrasey_men@yahoo.com");
driver.findElement(By.id("SubmitCreate")).click();

driver.findElement(By.id("uniform-id_gender2")).click();
Actions actions=new Actions(driver);
Faker faker=new Faker();

actions.sendKeys(Keys.TAB).
        sendKeys(faker.name().firstName()).sendKeys(Keys.TAB).
sendKeys(faker.name().lastName()).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
        sendKeys(faker.internet().password(5, 8)).sendKeys(Keys.TAB).perform();

Select select=new Select(driver.findElement(By.id("days")));
select.selectByValue("3");
select=new Select(driver.findElement(By.id("months")));
select.selectByValue("3");
select=new Select(driver.findElement(By.id("years")));
select.selectByValue("1985");
actions.sendKeys(Keys.TAB).sendKeys(Keys.SPACE).sendKeys(Keys.TAB).sendKeys(Keys.SPACE).perform();


actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
       sendKeys(faker.company().name()).sendKeys(Keys.TAB).
        sendKeys(faker.address().streetAddressNumber()).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
        sendKeys(faker.country().capital()).sendKeys(Keys.TAB).
        sendKeys(faker.address().state()).sendKeys(Keys.TAB).
        sendKeys(faker.address().zipCode()).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
        sendKeys(faker.phoneNumber().cellPhone()).sendKeys(Keys.TAB).sendKeys(faker.phoneNumber().phoneNumber()).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
        sendKeys(Keys.ENTER).perform();


}



}
