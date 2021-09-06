package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ListaProfessor extends Commom {

    @FindBy(css = "h1.page-header-title")
    private WebElement TITULO_PAGINA;

    public ListaProfessor(WebDriver driver){
        super(driver);
    }

    public String retornaTituloPaginaProfessores(){
        return TITULO_PAGINA.getText();
    }

    public void selecionarProfessor(String professor){
        WebElement NOME_PROFESSOR = driver.findElement(By.xpath("//a[contains(.,'"+ professor +"')]"));
        scrolDown(NOME_PROFESSOR);
        NOME_PROFESSOR.click();
    }

}
