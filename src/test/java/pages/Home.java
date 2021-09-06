package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home extends Commom {

    @FindBy(xpath = "//a[contains(.,'Por professor')]")
    private WebElement POR_PROFESSOR;

    @FindBy(id = "onesignal-slidedown-cancel-button")
    private WebElement BT_NAO;


    public Home(WebDriver driver){
        super(driver);
    }

    public void clicarPorProfessor(){
        POR_PROFESSOR.click();
    }

    public void clicarNaoReceberNotificacao(){
        BT_NAO.click();
    }
}
