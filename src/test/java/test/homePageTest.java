package test;

import lib.ExcelRead;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class homePageTest extends baseTest{



    @Test(dataProvider = "del")
    public void homepagetest(String p,String d,String c) throws InterruptedException {

        gethomePage();
        hm.clickLaptop();
        getdelllaptopPage();
        del.clickFalsePopUp();
        del.clickProductLine(p);
        del.clickNoThanks();
        del.clickShipping(d);
       del.clickScreenSize(c);
      // del.checknoOfItems();
        String actual= del.verifyFilterResult1(p);
      //System.out.println(del.verifyFilterResult1());
        Assert.assertEquals(actual,p);
        boolean actual4=del.checkLaptpoTitles(p,c);
        Assert.assertTrue(actual4);

//        String actual2= del.verifyFilterResultShipping(d);
//        Assert.assertTrue(actual2.contains(d));
//
//        String actual3=del.verifyFilterResultSize(c);
//        Assert.assertTrue(actual3.contains(c));


//        boolean actual5=del.checkLaptpoSize(c);
//        Assert.assertTrue(actual5);

    }


   @DataProvider(name="del")
  public Object[][]getdata() throws IOException {
        Object[][] t;

        String filename="data/del.xlsx";
        String sheetname="Sheet4";
        ExcelRead er=new ExcelRead(filename,sheetname);
        t=er.excelToArray();

        return t;

    }

}
