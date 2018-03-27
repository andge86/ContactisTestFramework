package Steps;

import PageObjects.ContactPage;
import PageObjects.MainPage;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.IOException;

import java.io.UnsupportedEncodingException;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;


public class ContactTests{

    MainPage mainPage;
    ContactPage contactPage;

    Properties properties;
    public WebDriver driver;
    public String testRunMode;


    @Before
    public void setUpTestRunConfig() {

        // Initialise properties file to achieve tests run mode (web or mobile)
        properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("config.properties");
            properties.load(fileInputStream);
            testRunMode = properties.getProperty("testsRunMode");
            System.out.println("TestsRunMode = " + testRunMode);
        } catch (IOException e) {
            System.err.println("No config.properties file found!");
            e.printStackTrace();
        }

        // Choosing ChromeDriver for your OS
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("mac")) {System.setProperty("webdriver.chrome.driver", "chromedriver");}
        else {System.setProperty("webdriver.chrome.driver", "chromedriver.exe");}

        // Applying tests run config options (web or mobile)
        if (testRunMode.equals("web")) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        } else if (testRunMode.equals("mobile")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            Map<String, String> mobileEmulation = new HashMap<String, String>();
            mobileEmulation.put("deviceName", "iPhone 7");
            chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
            driver = new ChromeDriver(chromeOptions);
        } else {
            System.err.println("Tests run mode is incorrect in config.properties file");
        }

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(3L, TimeUnit.SECONDS);
    }

    @Given("^Client is on Contactis main page$")
    public void client_is_on_Contactis_main_page() throws InterruptedException {
        driver.get("https://contactis.pl/");
        Thread.sleep(2000);
    }

    @When("^Client navigates to Kontakt page$")
    public void client_navigates_to_Kontact_page() throws InterruptedException {
        mainPage = new MainPage(driver);
        if (testRunMode.equals("web")) {contactPage = mainPage.goToContactPage(driver);}
        else if (testRunMode.equals("mobile")) {contactPage = mainPage.clickOnMobileMenuElement().goToContactPage(driver);}
        Thread.sleep(2000);
    }

    @Then("^Contact form is opened$")
    public void Kontact_form_is_opened() {
        assertTrue(driver.getTitle().contains("Kontakt"));
    }

    @Then("^Client can see fields Imie i nazwisko, Adres e-mail, Numer telefonu, Tresc wiadomosci$")
    public void client_can_see_fields_Imie_i_nazwisko_Adres_e_mail_Numer_telefonu_Tresc_wiadomosci() throws InterruptedException, UnsupportedEncodingException {
        assertTrue(contactPage.nameTextField.isDisplayed());
        //    System.out.println(contactPage.nameTextField.getAttribute("placeholder"));
        assertTrue(contactPage.nameTextField.getAttribute("placeholder").equals("Imię i nazwisko"));

        assertTrue(contactPage.emailTextField.isDisplayed());
         //   System.out.println(contactPage.emailTextField.getAttribute("placeholder"));
        assertTrue(contactPage.emailTextField.getAttribute("placeholder").equals("Adres e-mail"));

        assertTrue(contactPage.phoneTextField.isDisplayed());
         //  System.out.println(contactPage.phoneTextField.getAttribute("placeholder"));
        assertTrue(contactPage.phoneTextField.getAttribute("placeholder").equals("Numer telefonu"));

        assertTrue(contactPage.messageTextField.isDisplayed());
         //   System.out.println(contactPage.messageTextField.getAttribute("placeholder"));
        assertTrue(contactPage.messageTextField.getAttribute("placeholder").equals("Treść wiadomości"));
    }


    @Then("^Client can fill Contact form with \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void client_can_fill_Contact_form_with(String name, String email, String phone, String message) throws InterruptedException {

        contactPage.enterName(name).enterEmail(email).enterPhone(phone).enterMessage(message);
        Thread.sleep(2000);

     //   System.out.println(contactPage.nameTextField.getAttribute("value"));
     //   System.out.println(contactPage.emailTextField.getAttribute("value"));
     //   System.out.println(contactPage.phoneTextField.getAttribute("value"));
     //   System.out.println(contactPage.messageTextField.getAttribute("value"));

        assertTrue(contactPage.nameTextField.getAttribute("value").equals(name));
        assertTrue(contactPage.emailTextField.getAttribute("value").equals(email));
        assertTrue(contactPage.phoneTextField.getAttribute("value").equals(phone));
        assertTrue(contactPage.messageTextField.getAttribute("value").equals(message));
    }


    @After
    public void closeBrowser() {
        driver.quit();
    }
}