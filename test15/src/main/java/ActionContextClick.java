import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ActionContextClick {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        try {
            driver.get("https://bt.rozetka.com.ua/kitchen_machines/c80163/");
            WebElement firstResult = driver.findElement(By.className("goods-tile__title"));
            System.out.println(firstResult.getText());
            Actions actionProvider = new Actions(driver);
            actionProvider.contextClick(firstResult).build().perform();
        } finally {
            driver.quit();
        }
    }
}
