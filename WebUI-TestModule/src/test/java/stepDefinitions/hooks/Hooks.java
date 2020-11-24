package stepDefinitions.hooks;

import base.Base;
import io.cucumber.java8.En;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Hooks extends Base implements En {

    private Base base;

    public Hooks(Base base) {
        this.base = base;

        Before(1, () -> {

            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
            base.driver = new ChromeDriver(chromeOption());
            base.driver.manage().window().maximize();
            base.driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
            base.driver.navigate().to("http://automationpractice.com/index.php");

        });

        After(1, () -> {
            base.driver.quit();

        });
    }

    public String downloadPath = System.getProperty("user.dir") + "\\Downloads";

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
}
