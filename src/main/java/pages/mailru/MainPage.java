package pages.mailru;

import pages.BasePage;
import pages.mailru.elements.MailBoxContainer;

public class MainPage extends BasePage {

    public MailBoxContainer mailBoxContainer;

    public MainPage() {
        super();
        mailBoxContainer = new MailBoxContainer();
    }

    public boolean isInitialized() { return this.mailBoxContainer.mailBoxContainer.isDisplayed(); }
}
