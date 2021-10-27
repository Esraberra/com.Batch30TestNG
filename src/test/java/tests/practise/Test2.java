package tests.practise;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Test2 extends TestBase {
    // 4 TEST METODU OLUSTURUN
    // https://www.n11.com/ SAYFASINA GiDİN.
    // https://www.gittigidiyor.com/ SAYFASINA GiDiN
    // https://getir.com/ SAYFASINA GiDiN
    // https://www.sahibinden.com/ SAYFASINA GiDiN


    @Test
    public void testmethod1() {
        driver.get("https://www.n11.com/");

    }

    @Test
    public void testmethod2() {
        driver.get("https://www.gittigidiyor.com/");


    }

    @Test
    public void testmethod3() {
        driver.get("https://getir.com/");


    }

    @Test
    public void testmethod4() {
        driver.get("https://www.sahibinden.com/");

    }

}