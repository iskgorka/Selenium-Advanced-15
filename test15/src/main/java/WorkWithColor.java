import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WorkWithColor {
    private final static Color HEX_COLLOR_BUTTON = Color.fromString("#00a046");

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        try {
            driver.get("https://rozetka.com.ua/");
            WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='button button_color_green button_size_medium search-form__submit']")));
            System.out.println(firstResult.getText());
            Color searchButtonBackgroundColor = Color
                    .fromString(driver.findElement(By.xpath("//button[@class='button button_color_green button_size_medium search-form__submit']"))
                            .getCssValue("background-color"));
            System.out.println(searchButtonBackgroundColor.equals(HEX_COLLOR_BUTTON));
        } finally {
            driver.quit();
        }
    }
}
