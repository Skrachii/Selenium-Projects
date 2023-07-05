import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Ozone {
    WebDriver driver;
    WebDriverWait wait;

    boolean hasNextPage = true;
    int attempts = 0;
    int maxAttempts = 3;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://www.ozone.bg/");

        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    @Test
    public void loginTest() throws InterruptedException {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"cookie_info_agree\"]/a")));


        WebElement cookie = driver.findElement(By.xpath("//*[@id=\"cookie_info_agree\"]/a"));
        cookie.click();
        Actions builder = new Actions(driver);
        WebElement category = driver.findElement(By.cssSelector(".open-main-cat-nav-wrapper>a"));
        builder.moveToElement(category)
                .perform();

        // wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Книжарница")));
        WebElement books = driver.findElement(By.linkText("Книжарница"));
        builder.moveToElement(books)
                .perform();

        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Научна фантастика, фентъзи и хорър")));
        WebElement horrorBooks = driver.findElement(By.linkText("Научна фантастика, фентъзи и хорър"));
        builder.moveToElement(horrorBooks)
                .perform();
        //Thread.sleep(500);
        horrorBooks.click();

        WebElement provider = driver.findElement(By.cssSelector("#filter-link-nalichnost-na-sklad"));
        provider.click();
        WebElement scienceFiction = driver.findElement(By.cssSelector("#filter-link-zhanrove-nauchna-fantastika"));
        builder.scrollToElement(scienceFiction)
                .perform();
        scienceFiction.click();
        WebElement showElements = driver.findElement(By.xpath("//*[@id=\"products-list\"]/div[1]/div/div[3]/div"));
        builder.moveToElement(showElements)
                .perform();
        WebElement hundred = driver.findElement(By.xpath("//*[@id=\"products-list\"]/div[1]/div/div[3]/ul/li[3]/span"));
        hundred.click();

        WebElement maxHandle = driver.findElement(By.cssSelector(".handle.max"));
        builder.scrollToElement(maxHandle)
                .clickAndHold(maxHandle)
                .moveByOffset(-80, 0)
                .release()
                .perform();

        Thread.sleep(500);
        WebElement discountedPrice = driver.findElement(By.cssSelector(".special-price"));
        List<WebElement> discountedProducts = new ArrayList<>();


        while (hasNextPage) {
            WebElement nextPageButton = driver.findElement(By.cssSelector(".next"));

            if (nextPageButton.getAttribute("class").contains("disable")) {
                hasNextPage = false;
            } else {
                discountedProducts.add(discountedPrice);
                nextPageButton.click();
            }
            System.out.println("All discounted products: " + discountedProducts.size());
        }
    }
}



