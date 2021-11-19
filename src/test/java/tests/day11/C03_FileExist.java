package tests.day11;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist  {



@Test
    public void test(){
    System.out.println(System.getProperty("user.home"));

    //   /Users/esrakucuk/Downloads/picture.jpg

    String dosyaYolu=System.getProperty("user.home") + "/Downloads/picture.jpg";

 System.out.println(Files.exists(Paths.get(dosyaYolu)));
Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));


    System.out.println(System.getProperty("user.dir"));

}








}
