package homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class DemoGuru extends TestBase {
   // Go to http://demo.guru99.com/test/drag_drop.html url
    //    Drag and drop the BANK button to the Account section in DEBIT SIDE
    //    Drag and drop the SALES button to the Account section in CREDIT SIDE
    //    Drag and drop the 5000 button to the Amount section in DEBIT SIDE
    //    Drag and drop the second 5000 button to the Amount section in CREDIT SIDE


    @Test
    public void test() throws InterruptedException

    {
        driver.get("http://demo.guru99.com/test/drag_drop.html");

         Actions actions= new Actions(driver);

         WebElement bankButton=driver.findElement(By.xpath("//li[@class='block14 ui-draggable']"));

         WebElement debitSide=driver.findElement(By.xpath("//li[@class='placeholder']"));
        //    Drag and drop the BANK button to the Account section in DEBIT SIDE
         actions.dragAndDrop(bankButton,debitSide).perform();


        WebElement salesButton=driver.findElement(By.xpath("//li[@class='block15 ui-draggable']"));
        Thread.sleep(2000);

        WebElement accountCredit=driver.findElement(By.xpath("//ol[@class='field15 ui-droppable ui-sortable']"));
        //    Drag and drop the SALES button to the Account section in CREDIT SIDE
       actions.dragAndDrop(salesButton,accountCredit).perform();

        WebElement fivethousandButton= driver.findElement(By.xpath("//li[@class='block13 ui-draggable']"));

        Thread.sleep(2000);
//

       WebElement amountDebit=driver.findElement(By.xpath("//ol[@class='field13 ui-droppable ui-sortable']"));
        //    Drag and drop the 5000 button to the Amount section in DEBIT SIDE

     actions.dragAndDrop(fivethousandButton,amountDebit).perform();

        WebElement secondFivethousandButton= driver.findElement(By.xpath("//li[@class='block13 ui-draggable'][2]"));

        Thread.sleep(2000);

        WebElement amountCredit=driver.findElement(By.xpath("//ol[@id='amt8']"));

        Thread.sleep(2000);
//    Drag and drop the second 5000 button to the Amount section in CREDIT SIDE

        actions.dragAndDrop(secondFivethousandButton,amountCredit).perform();



    }









}
