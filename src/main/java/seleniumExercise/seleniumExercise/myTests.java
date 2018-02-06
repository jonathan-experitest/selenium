package seleniumExercise.seleniumExercise;
import org.junit.After;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class myTests implements Runnable{
    private static final String USERNAME = "jonathan.aharon";
    private static final String PASSWORD = "Sanford8";
    private static final String PROJECT = "Default";
    String CLOUDURL = "https://sales.experitest.com/wd/hub/";
    PlatformType platform;
    String testName;
    String version;
    String OS;
    WebDriver driver;

    public myTests(PlatformType _platform, String _version, String _OS, String _testName){
        this.platform= _platform;
        this.testName= _testName;
        this.version = _version;
        this.OS = _OS;
    }

    public void run(){
        try {
            getDriver(platform, version, OS, testName, true);

            driver.get("https://www.google.com");
            Thread.sleep(8000);
            WebElement searchBar = driver.findElement(By.id("lst-ib"));
            searchBar.click();
            Thread.sleep(5000);
            searchBar.sendKeys("Jerusalem");

            driver.findElement(By.xpath("//*[@id=\"hplogo\"]/div")).click();
            Thread.sleep(5000);
            driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[3]/center/input[1]")).click();
            Thread.sleep(5000);
            driver.findElement(By.xpath("//*[contains(text(), 'History of Jerusalem')]")).click();
            Thread.sleep(5000);
            System.out.println("url of page is: " + driver.getCurrentUrl());
            System.out.println("title of page is: " + driver.getTitle());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown(){
        driver.quit();
    }


    public void getDriver(PlatformType platform, String version, String OS, String testName, boolean generateReport) throws MalformedURLException {
        //Set Browser Type
        DesiredCapabilities dc = new DesiredCapabilities();

        if (platform == PlatformType.CHROME) {
            dc = DesiredCapabilities.chrome();
        } else if (platform == PlatformType.FIREFOX) {
            dc = DesiredCapabilities.firefox();
        } else if (platform == PlatformType.IE) {
            dc = DesiredCapabilities.internetExplorer();
        }
        //Set Grid capabilities
        dc.setCapability("user", USERNAME);
        dc.setCapability("password", PASSWORD);
        dc.setCapability("project", PROJECT);
        dc.setCapability("generateReport", generateReport);
        dc.setCapability("testName", testName);

        this.driver = new RemoteWebDriver(new URL(CLOUDURL), dc);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    private void getTitle_test() throws Exception {
        driver.get("https://experitest.com/");
        Thread.sleep(10000);
        System.out.println("title of page is: " + driver.getTitle());
    }
}