package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Commom {

    protected WebDriver driver;

    public Commom(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void scrolDown(WebElement elemento){
        JavascriptExecutor js =(JavascriptExecutor)driver;
        int posicaoY = elemento.getLocation().y-200;
        js.executeScript("window.scrollTo(0,"+posicaoY+")");
    }


}
