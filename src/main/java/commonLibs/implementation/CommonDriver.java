package commonLibs.implementation;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class CommonDriver {


    private WebDriver driver;
    private final String currentDirectory;

    private int elemantDetectionTimeout = 10;

    private int pageLoadTimeout = 10;

    public CommonDriver(String browserType) throws Exception {
        currentDirectory = System.getProperty("user.dir");
        if(browserType.equalsIgnoreCase("chrome"))
        {
            driver = new ChromeDriver();
            System.setProperty("webdriver.driver.chrome",currentDirectory+"/drivers/chromedriver.exe");
        }
        else if (browserType.equalsIgnoreCase("edge"))
        {
            driver = new EdgeDriver();
            System.setProperty("webdriver.driver.edge",currentDirectory+"/drivers/msedgedriver.exe");
        }
        else if (browserType.equalsIgnoreCase("firefox"))
        {
            driver = new FirefoxDriver();
            System.setProperty("webdriver.driver.firefox",currentDirectory+"/drivers/geckodriver.exe");
        }
        else
        {
            throw new Exception("Invalid Browser");
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }
    public void navigateToURL(String url)
    {
        driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(elemantDetectionTimeout, TimeUnit.SECONDS);
        driver.get(url);
    }
    public String currentPageTitle()
    {
        return driver.getTitle();
    }

    //getter & setter done with Lombok
    public WebDriver getDriver() {
        return driver;
    }

    public void setPageLoadTimeout(int pageLoadTimeout) {
        this.pageLoadTimeout = pageLoadTimeout;
    }

    public void setElemantDetectionTimeout(int elemantDetectionTimeout) {
        this.elemantDetectionTimeout = elemantDetectionTimeout;
    }
        public void closeAllBrowser ()
        {
            driver.quit();
        }

}
