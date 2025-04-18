import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions as ChromeOptions
import java.util.HashMap as HashMap
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

// === SETUP CHROME OPTIONS ===
ChromeOptions options = new ChromeOptions()

// Mode incognito
options.addArguments('--incognito')

// Optional tapi disarankan
options.addArguments('--disable-infobars')

options.addArguments('--disable-notifications')

options.addArguments('--start-maximized')

options.addArguments('--no-default-browser-check')

options.addArguments('--disable-translate')

// Matikan password manager
Map<String, Object> prefs = new HashMap()

prefs.put('credentials_enable_service', false)

prefs.put('profile.password_manager_enabled', false)

options.setExperimentalOption('prefs', prefs)

// Ganti WebDriver dengan custom options
ChromeDriver driver = new ChromeDriver(options)

DriverFactory.changeWebDriver(driver)

// === TEST START ===
// Tidak perlu openBrowser(''), karena driver sudah aktif
WebUI.navigateToUrl('https://automationexercise.com/')

WebUI.click(findTestObject('Object Repository/Page_Automation Exercise - Signup  Login/a_Signup  Login'))

WebUI.verifyTextPresent('Login to your account', false)

String currentURL = WebUI.getUrl()

WebUI.verifyEqual(currentURL, 'https://automationexercise.com/login')

WebUI.setText(findTestObject('Object Repository/Page_Automation Exercise - Signup  Login/input_Login to your account_email'), 
    'enggar@gmail.com')

// Ganti 'password' dengan value sebenarnya atau pakai GlobalVariable
WebUI.setText(findTestObject('Object Repository/Page_Automation Exercise - Signup  Login/input_Login to your account_password'), 
    password)

WebUI.click(findTestObject('Object Repository/Page_Automation Exercise - Signup  Login/button_Login'))

WebUI.delay(5)

WebUI.verifyTextPresent('Logged in as Enggar', false)

WebUI.click(findTestObject('Object Repository/Page_Automation Exercise/a_Delete Account'))

WebUI.verifyTextPresent('ACCOUNT DELETED!', false)

WebUI.closeBrowser()

