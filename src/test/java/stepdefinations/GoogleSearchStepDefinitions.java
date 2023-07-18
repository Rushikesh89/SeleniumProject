package stepdefinations;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GoogleSearchStepDefinitions {
    private WebDriver driver;
    private String driverPath = "driver/chrome_114/chromedriver.exe";

    @Before
    public void setup() {
        // Set up WebDriver and navigate to Google homepage
        System.setProperty("webdriver.chrome.driver", driverPath);
    }

    @Given("^I am on the Google homepage$")
    public void iAmOnGoogleHomepage() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
    }

    @When("I enter the keyword {string} in the search box")
    public void iEnterKeywordInSearchBox(String keyword) {
        // Enter keyword in the search box
        driver.findElement(By.name("q")).sendKeys(keyword);
    }

    @When("I click the search button")
    public void iClickSearchButton() {
        // Click the search button
        driver.findElement(By.name("btnK")).submit();
    }

    @Then("I should see search results related to {string}")
    public void iShouldSeeSearchResults(String keyword) {
        // Perform assertions or further actions
        // ...
        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.contains(keyword));
    }

    @After
    public void tearDown() {
        // Quit the driver and close the browser
        if(driver!=null){
            driver.quit();
        }
    }
}
