package model;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class dellaptopModel extends baseModel{

    public dellaptopModel(WebDriver d){

        super(d);
    }



   public List<WebElement> getFalsePopup() throws InterruptedException {
     By locator =By.xpath("(//button[@type='button'])[5]");
       List<WebElement> ele;
       try {


         WebDriverWait wait = new WebDriverWait(driver, 10);
         wait.until(ExpectedConditions.elementToBeClickable(locator));
         ele = driver.findElements(locator);
     }
     catch (Exception e){
          ele = driver.findElements(locator);
     }
      //Thread.sleep(10000);
     // WebElement e=driver.findElement(By.xpath("(//button[@type='button'])[5]"));

//

        return ele;
    }

    public WebElement getProductLine(String productline) throws InterruptedException {


        //Thread.sleep(3000);
       // WebElement e =driver.findElement(By.xpath("//button[text()='Product Line']"));
      //  WebElement e =driver.findElement(By.xpath("//input[@title='"+ProductLine+"']"));
        WebElement e =driver.findElement(By.xpath("//input[@tinytitle='"+productline+"']"));
        return e;
    }

    public List<WebElement>  noThanks() throws InterruptedException {

        By locator = By.xpath("//button[@aria-label='No, thanks']");
        if (driver.findElements(By.xpath("//div/iframe")).size()>0) {


        driver.switchTo().frame(driver.findElement(By.xpath("//div/iframe")));
    }
        List<WebElement> e =new ArrayList<>();
       try {

           WebDriverWait wait = new WebDriverWait(driver, 10);
           wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator,0));
           e = driver.findElements(locator);
       }
       catch (Exception ex){
           e = driver.findElements(locator);
        }
        // Actions actions =new Actions(driver);
      //List<WebElement>  e = driver.findElements(By.xpath("//button[@aria-label='No, thanks']"));
        //actions.moveToElement(e);
        //actions.perform();
         return e;
    }


    public WebElement getShippping(String Days) throws InterruptedException {
      //  Thread.sleep(3000);
       // WebElement e =driver.findElement(By.xpath("//input[@tinytitle='"+shippingdelivery+"']"));
        WebElement e =driver.findElement(By.xpath("//input[contains(@title,'Ships Within "+Days+" Days')]"));
      //   WebElement e =driver.findElement(By.xpath("//input[contains(@title,'Ships Within "+filterDays+" Days')]"));
        return e;
    }
//
    public WebElement getScreenSize(String ScreenSize) throws InterruptedException {
     //   Thread.sleep(3000);
        //WebElement e =driver.findElement(By.xpath("//input[@title='"+ScreenSize+
        WebElement e = driver.findElement(By.xpath("//input[contains(@title,'"+ScreenSize+"')]"));
        return e;
    }

    public WebElement getFilterResults1(String filteritem){
        WebElement e=driver.findElement(By.xpath("//div[contains(text(),'"+filteritem+"')]"));
        return e;
    }
    public WebElement getFilterResultsShipping(String filterDays){
        WebElement e=driver.findElement(By.xpath("//div[contains(text(),'Ships Within "+filterDays+" Days')]"));
       // WebElement e =driver.findElement(By.xpath("//input[contains(@title,'Ships Within "+filterDays+" Days')]"));
        return e;
    }
    public WebElement getFilterResultsSize(String filterSize){
       // WebElement e=driver.findElement(By.xpath("//div[contains(text(),'"+filterSize+"')]"));
        WebElement e =driver.findElement(By.xpath("//div[contains(text(),' "+filterSize+" inch')]"));
        return e;
    }

    public List<WebElement> getLaptopTitles(){

          List<WebElement> all =driver.findElements(By.xpath("//h3/a"));
        return all;
    }
    public List<WebElement> getLaptopSize(){

        List<WebElement> all =driver.findElements(By.xpath("//span[contains(text(),'display')]"));
        return all;
    }
    public WebElement getNoOfItems(){
        WebElement e =driver.findElement(By.xpath("(//div[@class='system-result-info'])[2]"));
        return e;
    }
    public WebElement getNextPage(int no){
        WebElement element=driver.findElement(By.xpath("(//button[@data-to-page='"+no+"'])[1]"));
        return element;
    }

}

