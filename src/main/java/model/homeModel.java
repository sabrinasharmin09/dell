package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class homeModel extends baseModel{

    public homeModel(WebDriver d){

        super(d);
    }

    public WebElement getLaptop(){
        WebElement e=driver.findElement(By.xpath("//div[text()='Laptops']"));
        return e;
    }
}
