import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Ozone {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://www.ozone.bg/");
    }

    @Test
    public void loginTest(){
     WebElement cookie = driver.findElement(By.xpath("//*[@id=\"cookie_info_agree\"]/a"));
     cookie.click();
        Actions builder = new Actions(driver);
        WebElement category = driver.findElement(By.cssSelector(".open-main-cat-nav-wrapper>a"));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".open-main-cat-nav-wrapper>a")));
        WebElement books = driver.findElement(By.xpath("/html/body/header/div[2]/div/div/div/nav/div/div[1]/div/ul/li[2]/a/span/h3"));
        builder.moveToElement(category);


       builder.moveToElement(books)
               .perform();
//        WebElement fantasy = driver.findElement(By.xpath("/html/body/header/div[2]/div/div/div/nav/div/div[1]/div/ul/li[2]/div/ul[1]/li[2]/a"));
//        fantasy.click();

        // builder.moveToElement(books)
//         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/header/div[2]/div/div/div/nav/div/div[1]/div/ul/li[2]/a/span/h3")));
//        fantasy.click();
    }
}
