package tests.practise;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Test14 extends TestBase {

@DataProvider
public static Object[][]signInTest(){
    Object[][] gmibankData = new Object[2][2];

    //{"username1@gmail.com","password1"},
    //{"username2@gmail.com","password2"},

    gmibankData [0][0] = "username1@gmail.com";
    gmibankData [0][1] = "password1";
    gmibankData [1][0] = "username2@gmail.com";
    gmibankData [1][1] = "password2";

    return gmibankData;
}


    @Test(dataProvider = "signInTest")
    public void test(String userName, String password){

        driver.get("https://www.gmibank.com");
        driver.findElement(By.xpath("(//a[@class='dropdown-toggle nav-link'])[2]")).click();

        driver.findElement(By.xpath("//span[text()='Sign in']"));
        driver.findElement(By.id("username")).sendKeys(userName);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("(//span[text()='Sign in'])[2]")).click();
    }

}
