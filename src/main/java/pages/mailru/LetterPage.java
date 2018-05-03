package pages.mailru;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.mailru.elements.PortalsHeader;

public class LetterPage extends BasePage {

    @FindBy(id = "b-letter")
    public WebElement letter;

    @FindBy(className = "b-letter__head__subj__text")
    public WebElement subject;

    @FindBy(css = "[data-mnemo='from'] span")
    public WebElement from;

    @FindBy(css = "div.b-letter__body")
    public WebElement body;

    public PortalsHeader portalsHeader;

    public LetterPage(){
        super();
        portalsHeader = new PortalsHeader();
    }

    public boolean isInitialized() { return this.letter.isDisplayed(); }

    public String getSendersEmail() {
        return from.getAttribute("data-contact-informer-email");
    }

    public String getSendersName() {
        return from.getAttribute("data-contact-informer-name");
    }

    public void logOut(){
        this.portalsHeader.logOutBtn.click();
    }
}
