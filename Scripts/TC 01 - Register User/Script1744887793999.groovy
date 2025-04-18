import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.chrome.ChromeDriver as ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions as ChromeOptions
import java.util.HashMap as HashMap
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

// ===== MULAI TESTCASE REGISTER =====
ChromeOptions options = new ChromeOptions()

options.addArguments('--incognito')
options.addArguments('--disable-popup-blocking')
options.addArguments('--disable-notifications')
options.addArguments('--disable-extensions') // Hindari ekstensi yang bisa munculin iklan
Map<String, Object> prefs = new HashMap<>()
prefs.put("profile.default_content_setting_values.notifications", 2) // 1 = allow, 2 = block
prefs.put("profile.default_content_setting_values.popups", 2)
options.setExperimentalOption("prefs", prefs)

ChromeDriver driver = new ChromeDriver(options)

DriverFactory.changeWebDriver(driver)

WebUI.maximizeWindow()

WebUI.navigateToUrl('https://automationexercise.com/')

// Mendapatkan URL saat ini
String currentUrl = WebUI.getUrl()

// URL yang diharapkan
String expectedUrl = 'https://automationexercise.com/'

// Verifikasi URL apakah sesuai dengan yang diharapkan (langsung)
WebUI.verifyEqual(currentUrl, expectedUrl)

WebUI.click(findTestObject('Object Repository/Page_Automation Exercise - Signup  Login/a_Signup  Login'))

WebUI.verifyTextPresent('New User Signup!', false)

WebUI.setText(findTestObject('Object Repository/Page_Automation Exercise - Signup  Login/input_New User Signup_name'), 'Enggar')

WebUI.setText(findTestObject('Object Repository/Page_Automation Exercise - Signup  Login/input_New User Signup_email'), 
    'enggar@gmail.com')

WebUI.click(findTestObject('Object Repository/Page_Automation Exercise - Signup  Login/button_Signup'))

WebUI.delay(5)

WebUI.verifyTextPresent('ENTER ACCOUNT INFORMATION', false)

WebUI.click(findTestObject('Object Repository/Page_Automation Exercise - Signup/input_Mr_title'))

WebUI.setEncryptedText(findTestObject('Object Repository/Page_Automation Exercise - Signup/input__password'), 'lIdUre64oRo=')

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Automation Exercise - Signup/select_Day123456789101112131415161718192021_40ab5b'), 
    '2', true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Automation Exercise - Signup/select_MonthJanuaryFebruaryMarchAprilMayJun_aa9ebb'), 
    '7', true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Automation Exercise - Signup/select_Year20212020201920182017201620152014_f874ed'), 
    '2000', true)

WebUI.setText(findTestObject('Object Repository/Page_Automation Exercise - Signup/input__first_name'), 'eng')

WebUI.setText(findTestObject('Object Repository/Page_Automation Exercise - Signup/input__last_name'), 'gar')

WebUI.setText(findTestObject('Object Repository/Page_Automation Exercise - Signup/input_Company_company'), 'testtest')

WebUI.setText(findTestObject('Object Repository/Page_Automation Exercise - Signup/input_(Street address, P.O. Box, Company na_957d3e'), 
    'test')

WebUI.setText(findTestObject('Object Repository/Page_Automation Exercise - Signup/input_Address 2_address2'), 'test')

WebUI.setText(findTestObject('Object Repository/Page_Automation Exercise - Signup/input__state'), 'test')

WebUI.setText(findTestObject('Object Repository/Page_Automation Exercise - Signup/input__city'), 'test')

WebUI.setText(findTestObject('Object Repository/Page_Automation Exercise - Signup/input__zipcode'), 'test')

WebUI.setText(findTestObject('Object Repository/Page_Automation Exercise - Signup/input__mobile_number'), '0832827372')

WebUI.click(findTestObject('Object Repository/Page_Automation Exercise - Signup/button_Create Account'))

WebUI.verifyTextPresent('ACCOUNT CREATED!', false)

WebUI.delay(5)

WebUI.closeBrowser()

