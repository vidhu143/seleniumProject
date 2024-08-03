package abc.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Sample {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\shali\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // Initialize a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Open a website
        driver.get("https://www.fitpeo.com/");
        driver.manage().window().fullscreen();

        WebElement element = driver.findElement(By.xpath("//div[text()='Revenue Calculator']"));





        element.click();

        String xpath_slider = "//span[@data-index='0' and contains(@class, 'MuiSlider-thumb') and contains(@class, 'css-sy3s50')]";

        String xpath_slider_bar = "//span[contains(@class, 'MuiSlider-track') and contains(@class, 'css-10opxo5')]";



        // Locate the element using WebDriverWait to ensure it is present
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement slider = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath_slider)));

        System.out.println(slider);

        WebElement slider_bar = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath_slider_bar)));

//	        WebElement input = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(":r0:")));

        // Define the XPath for the input element
        String xpath_input = "//input[@class='MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputSizeSmall css-1o6z5ng']";

        // Locate the element using WebDriverWait to ensure it is present

        WebElement inputElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath_input)));

        // Change the value of the input element using JavaScript


        // Scroll the slider into view
        js.executeScript("arguments[0].scrollIntoView(true);", slider);

        int initialPositionOfSlider = (int) ((820 / 2000.0) * 100);

        String widthValue = initialPositionOfSlider + "%";
        System.out.println( widthValue );

        // Change the style of the slider
        js.executeScript("arguments[0].style.width = arguments[1];", slider_bar, widthValue);

        js.executeScript("arguments[0].style.left = arguments[1];", slider, widthValue);



        js.executeScript("arguments[0].value = '820';", inputElement);

        // Trigger change and input events to ensure the new value is recognized
        js.executeScript("arguments[0].dispatchEvent(new Event('change', { bubbles: true }));", inputElement);
        js.executeScript("arguments[0].dispatchEvent(new Event('input', { bubbles: true }));", inputElement);









        System.out.println("Script Ran");
        // Close the browser
        //driver.quit();
    }
}
