package ca.i88.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Selenium2ExampleFirefox {

    public static void main(String[] args) {
        //if you didn't update the Path system variable to add the full directory path to the executable as above mentioned then doing this directly through code
        System.setProperty("webdriver.gecko.driver", "C:\\work\\geckodriver-v0.24.0-win64/geckodriver.exe");

        WebDriver driver = new FirefoxDriver();

        // And now use this to visit Google
        driver.get("http://g.i88.ca");
        // Alternatively the same thing can be done like this
        // driver.navigate().to("http://g.i88.ca");

        // Find the text input element by its name
        WebElement element = driver.findElement(By.name("q"));

        // Enter something to search for
        element.sendKeys("java");

        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();

        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());

        // Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
        (new WebDriverWait(driver, 10)).until((ExpectedCondition<Boolean>) (WebDriver d) -> d.getTitle().toLowerCase().startsWith("java"));

        // Should see: "cheese! - Google Search"
        System.out.println("Page title is: " + driver.getTitle());

        //Close the browser
        driver.quit();
    }
}
