package pages.mailru;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import utils.Driver;

import java.util.ArrayList;

public class LettersListPage extends BasePage {

    @FindBy(className = "b-datalists")
    public WebElement lettersList;

    private ArrayList<WebElement> letters = new ArrayList<>(Driver
            .getInstance()
            .findElements(By.xpath(".//*[@data-bem='b-datalist__item']")));
    public WebElement linkOnLetter;

    public boolean isInitialized() { return this.lettersList.isDisplayed(); }

    public WebElement findElementBySubject(String subject) {
        WebElement result = null;

        for (int i = 0; i < letters.size(); i++) {
            WebElement currentElement = letters.get(i);
            String currentSubject = subjectByElement(currentElement);

            if (currentSubject.toLowerCase().contains(subject.toLowerCase())) {
                result = currentElement;
                return result;
            }
        }

        return result;
    }

    private String subjectByElement(WebElement element) {
        WebElement subjElem = element.findElement(By.cssSelector("div[class='b-datalist__item__subj']"));
        return String.valueOf(subjElem.getText());
    }

    public LetterPage openLetter(String subject){
        linkOnLetter = this.findElementBySubject(subject).findElement(By.tagName("a"));
        linkOnLetter.click();
        return new LetterPage();
    }
}
