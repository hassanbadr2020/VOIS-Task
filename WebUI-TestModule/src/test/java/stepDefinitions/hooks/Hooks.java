package stepDefinitions.hooks;

import Environments.EnviromnetHandler.DataManager;
import Utilities.MethodHelper;
import base.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java8.En;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Hooks extends Base implements En {
    MethodHelper methodHelper = new MethodHelper();
    DataManager dataManager = new DataManager();
    private Base base;
    public String downloadPath = System.getProperty("user.dir") + "\\ScreenShots";

    public Hooks(Base base) {
        this.base = base;
    }

    public FirefoxOptions firefoxOption() {
        FirefoxOptions option = new FirefoxOptions();
        option.addPreference("browser.download.folderList", 2);
        option.addPreference("browser.download.dir", downloadPath);
        option.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");
        option.addPreference("browser.download.manager.showWhenStarting", false);
        option.addPreference("pdfjs.disabled", true);
        return option;
    }

    public ChromeOptions chromeOption() {
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default.content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadPath);
        options.setExperimentalOption("prefs", chromePrefs);
        options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        return options;
    }

    @Before
    public void getStart(Scenario scenario) {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
        base.driver = new ChromeDriver(chromeOption());
        base.driver.manage().window().maximize();
        base.driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        base.driver.navigate().to(dataManager.getUIUrl());
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            methodHelper.captureScreenshot(base.driver, scenario.getName());
        }
        base.driver.quit();
    }
}
