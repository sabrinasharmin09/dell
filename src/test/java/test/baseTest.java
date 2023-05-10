package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import page.delllaptoppage;
import page.homePage;

import java.util.concurrent.TimeUnit;

public class baseTest {

    static WebDriver driver;

    static homePage hm;

    static delllaptoppage del;



    @BeforeSuite
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","driver/chromedriver1.exe");
        driver=new ChromeDriver();
        driver.get("http://www.dell.com");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }


    public void gethomePage(){

        hm = new homePage(driver);
    }



    public void getdelllaptopPage(){

        del =new delllaptoppage(driver);
    }
}
