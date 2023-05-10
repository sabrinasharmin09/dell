package page;

import model.homeModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class homePage extends homeModel {

   public homePage(WebDriver d){
    super(d);
    }


    public void clickLaptop(){
       WebElement e=getLaptop();
       e.click();
    }















  }
