import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Ozone {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://www.ozone.bg/");
    }

    @Test
    public void loginTest() throws InterruptedException {
        WebElement cookie = driver.findElement(By.xpath("//*[@id=\"cookie_info_agree\"]/a"));
        cookie.click();
        Actions builder = new Actions(driver);
        WebElement category = driver.findElement(By.cssSelector(".open-main-cat-nav-wrapper>a"));
        builder.moveToElement(category)
                .perform();

        WebElement books = driver.findElement(By.linkText("Книжарница"));
        builder.moveToElement(books).perform();

        WebElement calendars = driver.findElement(By.linkText("Календари"));
        builder.moveToElement(calendars).perform();
        Thread.sleep(500);
        calendars.click();

        WebElement maxHandle = driver.findElement(By.cssSelector(".handle.max"));
        builder.scrollToElement(maxHandle)
                .clickAndHold(maxHandle)
                .moveByOffset(-40, 0)
                .release()
                .perform();


//        WebElement precision = driver.findElement(By.cssSelector(".precision"));
//        WebElement price = driver.findElement(By.cssSelector(".price"));
//        System.out.println(element.getCssValue(String.valueOf(price)));



        List<WebElement> discountedProducts = driver.findElements(By.cssSelector(".col-xs-3"));
        for (WebElement element: discountedProducts ) {
            System.out.println(element.getText());
        }
    }
}
