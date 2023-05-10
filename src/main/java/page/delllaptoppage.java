package page;

import model.dellaptopModel;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;


public class delllaptoppage extends dellaptopModel {
  //  WebDriver driver;


    public delllaptoppage(WebDriver d) {


        super(d);
    }


    public void clickFalsePopUp() throws InterruptedException {

       List< WebElement> box = getFalsePopup();
       if (box.size()>0){
           box.get(0).click();
       }

//
//        JavascriptExecutor executor = (JavascriptExecutor)driver;
//       executor.executeScript("arguments[0].click();", e);
    }

    public void clickProductLine(String p) throws InterruptedException {

        //Actions act = new Actions(driver);
        WebElement e = getProductLine(p);
        //act.sendKeys(e);
        //act.perform();
        //  Select mul = new Select(e);
        // mul.selectByVisibleText(p);
        e.click();
//          String s=e.getText();
//          return s;

    }

    public void clickNoThanks() throws InterruptedException {
        List<WebElement> e = noThanks();
        if (e.size() > 0) {
            e.get(0).click();

        }
     //   driver.switchTo().activeElement();
//       JavascriptExecutor executor = (JavascriptExecutor)driver;
//       executor.executeScript("arguments[0].click();", e);

    }

    public void clickShipping(String s) throws InterruptedException {
        WebElement e = getShippping(s);
        e.click();
//        String a =e.getText();
//        return a;
    }


    public void clickScreenSize(String c) throws InterruptedException {
        WebElement e = getScreenSize(c);
        e.click();
//       String l=e.getText();
//       return l;

    }


    public String verifyFilterResult1(String filteritem) {
        WebElement e = getFilterResults1(filteritem);
        String s = e.getText();
        // System.out.println(s);
        return s;
    }

    public String verifyFilterResultShipping(String filterDays) {
        WebElement e = getFilterResultsShipping(filterDays);
        String s = e.getText();
        // System.out.println(s);
        return s;
    }

    public String verifyFilterResultSize(String filterSize) {
        WebElement e = getFilterResultsSize(filterSize);
        String s = e.getText();
        // System.out.println(s);
        return s;
    }


    public int checknoOfItems() {
        WebElement e = getNoOfItems();
        int totalPage = 0;
        String s = e.getText();
        String[] word = s.split(" ");
        int noofItems=0;
        if (word.length>2){
             noofItems = Integer.parseInt(word[4]);
        }else {
             noofItems = Integer.parseInt(word[0]);
        }

       // int noofItems=12;
        System.out.println(noofItems);
        if (noofItems % 12 != 0) {
            totalPage = noofItems / 12 + 1;
        } else {
            totalPage = noofItems / 12;
        }
        return totalPage;
    }

    public boolean checkLaptpoTitles(String title,String size) throws InterruptedException {

        List<WebElement> titles = getLaptopTitles();
        List<WebElement> sizes = getLaptopSize();
        boolean result = false;
        boolean result1 = false;
        int totalPage = checknoOfItems();
        System.out.println(sizes.size());
       // Thread.sleep(5000);
      //  for (WebElement e : titles) {
        for (int j=0;j<titles.size();j++){
            String t =titles.get(j).getText();
            String s=sizes.get(j).getText();
         //   System.out.println(t);
            System.out.println(s);
            if (t.contains(title)) {
                result = true;
            }
            else {
                result=false;
                break;
            }
            if (s.contains(size)){
                result1=true;

            }
            else {
                result1=false;
                break;
            }

        }
        System.out.println(totalPage);
        for (int i = 2; i <= totalPage; i = i + 1) {
             result = false;
             result1=false;
            WebElement pagination = getNextPage(i);
            pagination.click();
            titles.clear();
            sizes.clear();
//            System.out.println(driver.getCurrentUrl());
//            driver.get(driver.getCurrentUrl());
            driver.navigate().refresh();
            Thread.sleep(15000);
            titles = getLaptopTitles();
            sizes = getLaptopSize();

         //   for (int j = 0; j < w; j = j + 1) {

            for (int j=0;j<titles.size();j++){
                String t =titles.get(j).getText();
                String s=sizes.get(j).getText();
               // System.out.println(t);
                System.out.println(s);
                if (t.contains(title)) {
                    result = true;
                }
                else {
                    result=false;
                    break;
                }

                if (s.contains(size)){
                    result1=true;

                }
                else {
                    result1=false;
                    break;
                }

            }
            if (result==false || result1==false){
                result=false;
                break;
            }



                result = result  && result1 && true;


            }
            return result;
        }


//    public boolean checkLaptpoSize(String laptopSize){
//        List<WebElement> titles =getLaptopSize(laptopSize);
//        boolean result=false;
//        for (WebElement e:titles) {
//            String t =e.getText();
//            if (t.contains(laptopSize)){
//                result = true;
//            }
//
//        }
//        return result;
//    }


    }

