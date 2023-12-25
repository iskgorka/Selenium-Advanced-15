import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        try {
            // Navigate to URL
            driver.get("https://crossbrowsertesting.github.io/drag-and-drop.html");
            // Store 'box A' as source element
            WebElement sourceEle = driver.findElement(By.id("draggable"));
            // Store 'box B' as target element
            WebElement targetEle = driver.findElement(By.id("droppable"));
            int targetEleXOffset = targetEle.getLocation().getX();
            int targetEleYOffset = targetEle.getLocation().getY();
            Actions actionProvider = new Actions(driver);
            //Performs dragAndDropBy into the target element offset position
            actionProvider.dragAndDropBy(sourceEle, targetEleXOffset, targetEleYOffset).build().perform();
        } finally {
            driver.quit();
        }
    }
}
