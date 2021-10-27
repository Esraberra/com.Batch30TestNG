package tests.practise;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.util.Set;

public class Test4 extends TestBase {

    // 1) https://www.ntv.com.tr/ ADRESİNE GİT
    // 2) SAYFANIN TiTLE'NIN "NTV HABER - Haberler, Son Dakika Haberleri" OLDUGUNU DOGRULA
    // 3) SAYFANIN HANDLE DEGERiNi AL.
    // 4) SPOR SAYFASINA TIKLA
    // 5) URL'iN "https://www.ntvspor.net/" OLDUGUNU DOGRULA
    // 6) ANA SAYFAYA GERi DON
@Test
    public void test() throws InterruptedException {
    driver.get("https://www.ntv.com.tr/");
   String actualTitle= driver.getTitle();
   String expectedTitle="NTV HABER - Haberler, Son Dakika Haberleri";

    SoftAssert softAssert=new SoftAssert();
    System.out.println("sayfanin handle degeri : = >>" +driver.getWindowHandle());
  // driver.findElement(By.id("onetrust-accept-btn-handler")).click();
    driver.findElement(By.linkText("SPOR")).click();

    softAssert.assertEquals(actualTitle,expectedTitle,"failed");
String ilkHandle=driver.getWindowHandle();
Set<String> handles=driver.getWindowHandles();
String secondWindowHandle="";
    for (String each:handles
         ) {
        if (! each.equals(ilkHandle)) {
            secondWindowHandle=each;

        }
    }
    System.out.println("second window handle degeri : " +secondWindowHandle);

    driver.switchTo().window(secondWindowHandle);
    String expectedUrl="https://www.ntvspor.net/";
    String actualUrl=driver.getCurrentUrl();
    softAssert.assertEquals(actualUrl,expectedUrl,"failed ");
    driver.switchTo().window(ilkHandle);

    softAssert.assertAll();

}




}
