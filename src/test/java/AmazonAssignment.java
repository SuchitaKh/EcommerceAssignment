import Assignment1.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class AmazonAssignment extends BaseClass {

    @Test
    public void search() throws InterruptedException {

        driver.get("https://amazon.in");

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("watch", Keys.ENTER);

        List<WebElement> list = driver.findElements(By.xpath("//li[contains(@id,'p_n_material_browse')]"));


        // List cb=driver.findElements(By.)

        for (WebElement l : list) {
           // System.out.println(l.getText());
            String text = l.getText();
            if (l.getText().equalsIgnoreCase("Leather")) {
                l.findElement(By.xpath("//span[text()='" + text + "']/../div")).click();
                Thread.sleep(3000);
                break;
            }
        }

        driver.findElement(By.xpath("//span[text()='Men']")).click();
        driver.findElement(By.xpath("//span[text()='Watches']")).click();
        driver.findElement(By.xpath("//span[contains(text(),'25%')]")).click();
        driver.findElement(By.xpath("//span[text()='See more']")).click();

       // List<WebElement> Brand = driver.findElements(By.xpath("//div[@id='brandsRefinements']/ul/li"));

        List<WebElement> Brand= driver.findElements(By.xpath("//li[contains(@id,'p_89')]"));

        for(WebElement brand :Brand){
           // System.out.println(brand.getText());
            String text= brand.getText();
            if(brand.getText().equalsIgnoreCase("Relish")){
                brand.findElement(By.xpath("//span[text()='" + text + "']/../div")).click();
             break;
            }
        }

        Thread.sleep(3000);
        List<WebElement> product= driver.findElements(By.xpath("//div[@class='s-main-slot s-result-list s-search-results sg-row']/div"));
       //System.out.println(product.size());

      for(int i=0;i<=product.size();i++){
          if(i==5){
              product.get(i).click();
              break;
          }
      }

       // System.out.println(driver.getWindowHandle());
        Set<String> handles=driver.getWindowHandles();
        Iterator<String> it= handles.iterator();
        String parentid= it.next();
        //System.out.println(parentid);

        String childid= it.next();
       //System.out.println(childid);
        driver.switchTo().window(childid);
        System.out.println(driver.getTitle());
       //String price = driver.findElement(By.id("priceblock_ourprice")).getText();
        String price = driver.findElement(By.xpath("//span[contains(@id,'priceblock')]")).getText();
       String title = driver.findElement(By.id("title")).getText();

       System.out.println("price of the " +title + "is "+price );


    }


}

