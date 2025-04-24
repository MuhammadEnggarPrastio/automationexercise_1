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

options.addArguments('--disable-extensions' // Hindari ekstensi yang bisa munculin iklan
	)

Map<String, Object> prefs = new HashMap()

prefs.put('profile.default_content_setting_values.notifications', 2 // 1 = allow, 2 = block
	)

prefs.put('profile.default_content_setting_values.popups', 2)

options.setExperimentalOption('prefs', prefs)

ChromeDriver driver = new ChromeDriver(options)

DriverFactory.changeWebDriver(driver)

WebUI.maximizeWindow()

WebUI.navigateToUrl('https://automationexercise.com/')

WebUI.click(findTestObject('Object Repository/Page_Automation Exercise/a_Contact us'))

WebUI.setText(findTestObject('Object Repository/Page_Automation Exercise - Contact Us/input_Get In Touch_name'), 'andy')

WebUI.setText(findTestObject('Object Repository/Page_Automation Exercise - Contact Us/input_Get In Touch_email'), 'andy@gmail.com')

WebUI.setText(findTestObject('Object Repository/Page_Automation Exercise - Contact Us/input_Get In Touch_subject'), 'testing')

WebUI.setText(findTestObject('Object Repository/Page_Automation Exercise - Contact Us/textarea_Get In Touch_message'), 'testing')

WebUI.scrollToElement(findTestObject('Page_Automation Exercise - Contact Us/input_Get In Touch_submit'), 3)

WebUI.uploadFile(findTestObject('Object Repository/Page_Automation Exercise - Contact Us/input_Get In Touch_upload_file'), 
    'C:\\Users\\muhammad.enggar\\Pictures\\Screenshots\\test.png')

WebUI.click(findTestObject('Page_Automation Exercise - Contact Us/input_Get In Touch_submit'))

WebUI.acceptAlert()

WebUI.verifyTextPresent('Success! Your details have been submitted successfully.', false)

WebUI.closeBrowser()

