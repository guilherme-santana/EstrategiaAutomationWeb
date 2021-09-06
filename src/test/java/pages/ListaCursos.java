package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ListaCursos extends Commom{


    public ListaCursos(WebDriver driver) {
        super(driver);
    }

    public String retornaTituloPaginaCursos(String professor){
        return driver.findElement(By.xpath("//h1[contains(.,'"+professor+"')]")).getText();
    }

    public double obterValorParcelado(String curso){
        String valorParcelado = driver.findElement(By.xpath("//h1[contains(.,'"+curso+"')]/../div")).getText();
        return calcularValorTotalCurso(valorParcelado);
    }

    public void detalharCurso(String curso){
        WebElement DETALHAR = driver.findElement(By.xpath("//h1[contains(.,'" + curso + "')]/../div/../a"));
        scrolDown(DETALHAR);
        DETALHAR.click();
    }

    private double calcularValorTotalCurso(String texto){
        int  parcelas = 0;
        double valor = 0;
        
        Pattern patternParcela = Pattern.compile("([0-9])+\\w\\w");
        Pattern patternValor = Pattern.compile("([0-9])+,+([0-9])+");

        Matcher matcherParcela = patternParcela.matcher(texto);
        Matcher matchervalor = patternValor.matcher(texto);
        if (matcherParcela.find(0))
        {
            parcelas = Integer.parseInt(matcherParcela.group().replace("x",""));

        }
        if (matchervalor.find(0))
        {
            valor = Double.parseDouble(matchervalor.group().replace(",","."));
        }

        return parcelas*valor;

    }


}
