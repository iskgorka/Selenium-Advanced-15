package hometask;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;

import java.time.Duration;

public class KitchenMachineTest {
    private final static Color FILTERS_BUTTON_COLOR = Color.fromString("#e95d2a");
    private final static Color FREE_DELIVERY_LABEL_COLOR = Color.fromString("#4682B4");

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        try {
            driver.get("https://www.foxtrot.com.ua/");

            WebElement cityButton = driver.findElement(By.xpath("//span[@class='button user-confirm-location-button']"));
            cityButton.click();

            WebElement foxtrotSearchField = driver.findElement(By.xpath("//input[@type='search']"));
            foxtrotSearchField.sendKeys("кухонные комбайны");
            foxtrotSearchField.sendKeys(Keys.ENTER);

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,450)", "");

            Color filtersButtonColor = Color
                    .fromString(driver.findElement(By.xpath("//span[@class='button js-toggle-filter']"))
                            .getCssValue("background-color"));
            System.out.println(filtersButtonColor.equals(FILTERS_BUTTON_COLOR));

            Color freeDeliveryLabelColor = Color
                    .fromString(driver.findElement(By.xpath("//li[@class='card-tags__item card-tags__item_base tooltip_css']"))
                            .getCssValue("background-color"));
            System.out.println(freeDeliveryLabelColor.equals(FREE_DELIVERY_LABEL_COLOR));

            Color priceColor = Color.fromString(driver.findElement(By.xpath("//div[@class='card-price']")).getCssValue("color"));
            System.out.println(priceColor.asHex().equals("#0c061a"));

        } finally {
            driver.quit();
        }
    }
}
