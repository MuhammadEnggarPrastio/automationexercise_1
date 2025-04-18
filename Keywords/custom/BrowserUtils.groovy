package custom

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

public class BrowserUtils {

    @Keyword
    def openSecureChromeBrowser() {
        Map<String, Object> prefs = new HashMap<>()

        prefs.put('credentials_enable_service', false)
        prefs.put('profile.password_manager_enabled', false)
        prefs.put('autofill.profile_enabled', false)
        prefs.put('autofill.addresses_enabled', false)
        prefs.put('autofill.credit_card_enabled', false)
        prefs.put("profile.default_content_setting_values.notifications", 2)
        prefs.put("profile.default_content_setting_values.popups", 2)
        prefs.put("profile.default_content_setting_values.automatic_downloads", 1)

        ChromeOptions options = new ChromeOptions()
        options.setExperimentalOption('prefs', prefs)
        options.addArguments('--incognito')
        options.addArguments('--disable-infobars')
        options.addArguments('--disable-save-password-bubble')
        options.addArguments('--disable-extensions')
        options.addArguments('--disable-popup-blocking')
        options.addArguments('--disable-notifications')
        options.addArguments('--disable-translate')
        options.addArguments('--disable-password-manager-reauthentication')
        options.addArguments('--disable-features=PasswordManager,AutofillServerCommunication,PasswordChange')
        options.addArguments('--start-maximized')
        options.addArguments("user-data-dir=/tmp/katalon-profile")

        ChromeDriver driver = new ChromeDriver(options)
        DriverFactory.changeWebDriver(driver)
    }
}
