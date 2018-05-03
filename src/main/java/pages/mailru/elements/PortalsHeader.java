package pages.mailru.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class PortalsHeader extends BasePage {

    @FindBy(id = "portal-headline")
    public WebElement portalsHeader;

    @FindBy(id = "PH_logoutLink")
    public WebElement logOutBtn;
}
