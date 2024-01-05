package hometask;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class PromoGoods {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        try {
            driver.get("https://www.foxtrot.com.ua/");
            WebElement cityButton = new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='button user-confirm-location-button']")));
            cityButton.click();
            WebElement catalogButton = new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='header__categories-catalog-btn js-hover-catalog']")));
            catalogButton.click();

            List<WebElement> catalog = new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//li[@class='catalog__category-item jslink']"))));
            catalog.get(5).click();

            List<WebElement> categoryItems = new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//div[@class='category__item']"))));
            Actions actionProvider = new Actions(driver);
            actionProvider.doubleClick(categoryItems.get(1)).perform();

            List<WebElement> filters = driver.findElements(By.xpath("//div[@class='form-checkbox listing__sidebar-field listing-prop']"));
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(filters.get(2)));
            filters.get(2).click();

            List<WebElement> goods = driver.findElements(By.xpath("//div[@class='card__head']"));
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(goods.get(1)));
            goods.get(1).click();

            WebElement goodsTitle = new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[@class='page__title overflow']"))));
            System.out.println(goodsTitle.getText());

            WebElement buyButton = new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='button product-box__main-buy__button  buy-button product-buy-button']")));
            buyButton.click();

            Thread.sleep(2000);

            WebElement goToCartButton = new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//span[@class='button-link']"))));
            goToCartButton.click();

            getScreenShot(driver);

        } finally {
            driver.quit();
        }
    }

    public static void getScreenShot(WebDriver driver) {
        TakesScreenshot scr = ((TakesScreenshot) driver);
        byte[] screenshot = scr.getScreenshotAs(OutputType.BYTES);

        String fileName = "screenshot.png";
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
            fileOutputStream.write(screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


