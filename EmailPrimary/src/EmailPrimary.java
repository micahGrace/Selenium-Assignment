import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class EmailPrimary {


//    private static String primary;
     static List<WebElement> primaryEmail = new ArrayList<>();

    public static  void main(String [] args){

        //Setting up the Driver property
        System.setProperty("Webdriver.chrome.driver","C:\\Users\\Micky\\IdeaProjects\\EmailPrimary\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        // driver to mail.google.com
        driver.navigate().to("http://mail.google.com");

        //Finding the input elements
        driver.findElement(By.cssSelector("#identifierId")).sendKeys("mikagrace36@gmail.com");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        // Pressing the Next button
        driver.findElement(By.cssSelector("#identifierNext")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        // Findint the password input
        driver.findElement(By.cssSelector("#password > div.aCsJod.oJeWuf > div > div.Xb9hP > input")).sendKeys("Milkiasbekana1");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //Find the send button
        driver.findElement(By.cssSelector("#passwordNext")).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //get the primary emails
        primaryEmail =  driver.findElements(By.xpath("//*[@id=\":at\"]/div/div[2]/span/a"));

        for(int i = 0; i < primaryEmail.size(); i++){
            System.out.println("You Have: " + primaryEmail.get(i).getText() + "Unread Messages!");
        }

//
     driver.close();
     driver.quit();
    }

}
