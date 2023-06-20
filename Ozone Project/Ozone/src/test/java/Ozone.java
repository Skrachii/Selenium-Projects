import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://www.ozone.bg/");
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

        WebElement maxHandle = driver.findElement(By.cssSelector(".handle.max"));
        builder.scrollToElement(maxHandle)
                .clickAndHold(maxHandle)
                .moveByOffset(-80, 0)
                .release()
                .perform();

        Thread.sleep(500);
        WebElement discountedPrice = driver.findElement(By.cssSelector(".special-price"));

        while (hasNextPage) {
            WebElement nextPageButton = driver.findElement(By.cssSelector(".next"));
            if (nextPageButton.getAttribute("class").contains("disable")) {
                hasNextPage = false;
            } else {
                nextPageButton.click();
            }
        }


//            List<WebElement> discountedProducts = new ArrayList<>();

//        try {
//            WebElement nextPageButton = driver.findElement(By.cssSelector(".next"));
//
//            while (hasNextPage) {
////                if (discountedPrice.isDisplayed()) {
////                    discountedProducts.add(discountedPrice);
//                     wait.until(ExpectedConditions.(nextPageButton));
//                    nextPageButton.click();
////            } else {
////                nextPageButton.click();
//                }
//
//        } catch (StaleElementReferenceException e) {
//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
//            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".next")));
//            WebElement nextPageButton = driver.findElement(By.cssSelector(".next"));
//            while (hasNextPage) {
//                nextPageButton.click();
//            }
//            if (nextPageButton.isEnabled()) {
//                nextPageButton.click();
//            }
        //else {
        //  hasNextPage = false;

        //System.out.println(discountedProducts.size());
    }
////        WebElement precision = driver.findElement(By.cssSelector(".precision"));
//        WebElement specialPrice = driver.findElement(By.cssSelector(".special-price"));
////        System.out.println(element.getCssValue(String.valueOf(price)));
//
//


//        WebElement discountedElement = discountedProducts.get(0);
//        WebElement toCart = driver.findElement(By.cssSelector(".add-to-cart"));
//    public void nextPage(){
//        nextPageButton.click();
//    }
}



