package pages.mailru.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.mailru.LettersListPage;

public class MailBoxContainer extends BasePage {

    @FindBy(css = "div#mailbox-container")
    public WebElement mailBoxContainer;

    @FindBy(css = "input[id*='mailbox:login']")
    private WebElement loginInput;

    @FindBy(css = "input[id*='mailbox:password']")
    private WebElement passwordInput;

    @FindBy(css = "input[class='o-control']")
    private WebElement submitBtn;

    public void fillLoginForm(String login, String password) {
        this.loginInput.clear();
        this.loginInput.sendKeys(login);

        this.passwordInput.clear();
        this.passwordInput.sendKeys(password);
    }

    public LettersListPage submitForm(){
        this.submitBtn.click();
        return new LettersListPage();
    }
}
