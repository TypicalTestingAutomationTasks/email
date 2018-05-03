package tests.mailru;

import entities.Email;
import entities.Letter;
import org.testng.annotations.Test;
import pages.mailru.LetterPage;
import pages.mailru.MainPage;
import pages.mailru.LettersListPage;
import tests.BaseTest;
import utils.PropertyReader;
import utils.helpers.WaitingsHelpers;

import static org.testng.Assert.assertTrue;

public class CheckThemaAndBodyOfMailTest extends BaseTest {

    private String baseUrl = PropertyReader
            .getPropertyFromFile("properties/mailru.properties", "baseUrl");

    private Email email = new Email.EmailBuilder().createEmail();
    private Letter letter = new Letter.LetterBuilder().createLetter();

    private MainPage mainPage = new MainPage();
    private LettersListPage lettersListPage;
    private LetterPage letterPage;

    @Test
    public void test() throws InterruptedException {
        letter.setSender("");
        letter.setSubject("Узнайте о супервозможностях Почты Mail.");
        letter.setBody("");

        driver.get(baseUrl);
        WaitingsHelpers.waitForLoadPageByElementToBePresent(mainPage.mailBoxContainer.mailBoxContainer);
        assertTrue(mainPage.isInitialized());

        mainPage.mailBoxContainer.fillLoginForm(email.getEmail(), email.getPassword());
        lettersListPage = mainPage.mailBoxContainer.submitForm();
        WaitingsHelpers.waitForLoadPageByElementToBePresent(lettersListPage.lettersList);
        assertTrue(lettersListPage.isInitialized());

//        lettersListPage.linkOnLetter = lettersListPage.findElementBySubject(letter.getSubject()).findElement(By.tagName("a"));
//        lettersListPage.linkOnLetter.click();

        letterPage = lettersListPage.openLetter(letter.getSubject());
        WaitingsHelpers.waitForLoadPageByElementToBePresent(letterPage.letter);
        assertTrue(letterPage.isInitialized());


//        Thread.sleep(4000);
    }
}
