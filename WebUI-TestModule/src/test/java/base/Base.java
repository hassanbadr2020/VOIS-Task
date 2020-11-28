package base;

import Environments.EnviromnetHandler.DataManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class Base {
    public WebDriver driver;
    DataManager dataManager = new DataManager();

    public void startBrowser() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        driver.navigate().to(dataManager.getUIUrl());

    }

    public void tearBrowser() {
        driver.quit();

    }

}
