package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DetalhesCurso extends Commom{

    @FindBy(xpath = "//*/section/div[2]/div[1]/div[1]/div")
    private WebElement VALOR_TOTAL_CURSO;

    public DetalhesCurso(WebDriver driver){
        super(driver);
    }

    public String retornaTituloPaginaDetalhamentoCurso(String curso){
        return driver.findElement(By.xpath("//h1[contains(.,'"+curso+"')]")).getText();
    }

    public double obterValorTotalCurso(){
        return Double.parseDouble(VALOR_TOTAL_CURSO.getText().replace("R$ ","").replace(",","."));
    }

}
