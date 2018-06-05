import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class RetrevingNews {

    private static List<WebElement> newsCollection = new ArrayList<>();

    private static String[][] newsString;

    public static void main(String [] args){

            String baseUrl = "https://www.ethiopianreporter.com/bizines";
            String blogUrl = "http://localhost:3000/";
            System.setProperty("Webdriver.chrome.driver", "C:\\Users\\Micky\\IdeaProjects\\RetrevingNews\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.navigate().to(baseUrl);

            newsCollection = driver.findElements(By.xpath("//*[@id=\"block-gavias-kama-content\"]/div/div/div"));
            newsString  = new String[newsCollection.size()][2];
            int i = 0;

            for(WebElement news : newsCollection){
                newsString[i][0] = news.findElement(By.xpath("//*[@id=\"block-gavias-kama-content\"]/div/div/div/div/div[1]/article/div/div[2]/h3")).getText();
                newsString[i][1] = news.findElement(By.xpath("//*[@id=\"block-gavias-kama-content\"]/div/div/div/div/div[1]/article/div/div[2]/div[2]/div/p")).getText();

            }

             driver.navigate().to(blogUrl);

            for(int k = 0; k < newsString.length; k++){

                String title =  newsString[k][0];
                String content = newsString[k][1];
                driver.findElement(By.xpath("/html/body/div[1]/article/h1")).sendKeys("Title" + title);
                driver.findElement(By.xpath("/html/body/div[1]/article/p[2]")).sendKeys("Content" + content);
                driver.findElement(By.xpath("/html/body/button")).click();
//                System.out.println("Title: " + newsString[k][0]);
//                System.out.println("Content: " + newsString[k][1]);
//                System.out.println();
            }

        driver.close();
        driver.quit();

    }



}
