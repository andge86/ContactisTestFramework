package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {


    public MainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        }


    @FindBy(linkText = "KONTAKT")
    public WebElement contactPageLink;

    @FindBy(xpath = "//*[@class = 'icon icon-menu pull-right']")
    public WebElement navigationMenuMobileElement;


    public ContactPage goToContactPage(WebDriver driver){
       contactPageLink.click();
       return new ContactPage(driver);
    }

    // Method only for mobile testing
    public MainPage clickOnMobileMenuElement(){
        navigationMenuMobileElement.click();
        return this;
    }
}
