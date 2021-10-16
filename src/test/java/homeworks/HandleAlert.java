package homeworks;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import utilities.TestBase;

public class HandleAlert extends TestBase {
    /*
    go to url : http://demo.automationtesting.in/Alerts.html
    click  "Alert with OK" and click 'click the button to display an alert box:'
    accept Alert(I am an alert box!) and print alert on console
    click "Alert with OK & Cancel" and click 'click the button to display a confirm box'
    cancel Alert  (Press a Button !)
    click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
    and then sendKeys 'TechProEducation' (Please enter your name)
    finally print on console this mesaaje "Hello TechproEducation How are you today"

     */
    @Test
    public void test() throws InterruptedException

    {
        driver.get("http://demo.automationtesting.in/Alerts.html");

        driver.findElement(By.xpath("//button[@onclick='alertbox()']")).click();

        Thread.sleep(2000);

        Alert alert=driver.switchTo().alert();

        Thread.sleep(2000);

       // accept Alert(I am an alert box!) and print alert on console
        System.out.println(alert.getText());

        driver.switchTo().alert().accept();


        driver.findElement(By.xpath("//a[@href='#CancelTab']")).click();

        driver.findElement(By.xpath("//button[@onclick='confirmbox()']")).click();

        driver.switchTo().alert().dismiss();

        driver.findElement(By.xpath("//a[@href='#Textbox']")).click();

        driver.findElement(By.xpath("//button[@onclick='promptbox()']")).click();

        Thread.sleep(2000);

        driver.switchTo().alert().sendKeys("ESRA");

        Thread.sleep(2000);

        driver.switchTo().alert().accept();

        System.out.println(driver.findElement(By.xpath("//p[text()='Hello ESRA How are you today']")).getText());



    }



}
