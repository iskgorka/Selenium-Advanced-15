import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class SelectElement {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        try {
            driver.get("https://bt.rozetka.com.ua/kitchen_machines/c80163/");
            WebElement selectElement = driver.findElement(By.xpath("//select[@class='select-css ng-untouched ng-pristine ng-valid ng-star-inserted']"));

            Select selectObject = new Select(selectElement);
            List<WebElement> allSelectedOptions = selectObject.getAllSelectedOptions();
            List<WebElement> allAvailableOptions = selectObject.getOptions();
            String firstSelectedOption = selectObject.getFirstSelectedOption().getText();
            Boolean doesThisAllowMultipleSelections = selectObject.isMultiple();

            selectObject.selectByIndex(3);

            String secondSelectedOption = selectObject.getFirstSelectedOption().getText();
            for (WebElement e : allSelectedOptions) {
                System.out.println("allSelectedOptions = " + e.getText());
            }
            for (WebElement e : allAvailableOptions) {
                System.out.println("SelectedOption = " + e.getText());
            }
            System.out.println("firstSelectedOption = " + firstSelectedOption);
            System.out.println("secondSelectedOption = " + secondSelectedOption);
            System.out.println("doesThisAllowMultipleSelections = " + doesThisAllowMultipleSelections);
        } finally {
            driver.quit();
        }
    }
}
