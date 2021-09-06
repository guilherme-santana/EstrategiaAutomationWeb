package steps;

import core.Constants;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.DetalhesCurso;
import pages.Home;
import pages.ListaCursos;
import pages.ListaProfessor;

import java.util.concurrent.TimeUnit;

public class BuscarCurso {
    protected String url;
    protected WebDriver driver;

    protected Home home;
    protected ListaProfessor listaProfessor;
    protected ListaCursos listaCursos;
    protected DetalhesCurso detalhesCurso;

    double valorCursoParcelado;

    @Before
    public void init() {
        url = Constants.URL;
        System.setProperty(Constants.WEB_DRIVER_CHROME, Constants.PATH_CHROME_DRIVER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Constants.TIMEOUT, TimeUnit.MILLISECONDS);
        home = new Home(driver);
        listaProfessor = new ListaProfessor(driver);
        listaCursos = new ListaCursos(driver);
        detalhesCurso = new DetalhesCurso(driver);
    }

    @After
    public void quit() {
        driver.quit();
    }

    @Given("^que acesso o site Estrategia concursos$")
    public void que_acesso_o_site_Estrategia_concursos(){
        driver.get(url);
        home.clicarNaoReceberNotificacao();
    }

    @When("^clico em Por professor$")
    public void clicoEmPorProfessor() {
        home.clicarPorProfessor();
    }

    @Then("^apresenta a tela \"([^\"]*)\"$")
    public void apresenta_a_tela(String tituloPagina) {
        Assert.assertEquals(tituloPagina,listaProfessor.retornaTituloPaginaProfessores());
    }

    @When("^clico no professor \"([^\"]*)\"$")
    public void clicoNoProfessor(String professor) {
        listaProfessor.selecionarProfessor(professor);
    }

    @Then("^apresenta a tela com os cursos de \"([^\"]*)\"$")
    public void apresentaATelaComOsCursosDe(String professor)  {
        Assert.assertEquals(professor, listaCursos.retornaTituloPaginaCursos(professor));
    }

    @When("^clico no detalhamento do curso \"([^\"]*)\"$")
    public void clicoNoDetalhamentoDoCurso(String curso) {
        valorCursoParcelado = listaCursos.obterValorParcelado(curso);
        listaCursos.detalharCurso(curso);
    }

    @Then("^apresenta a tela com os detalhes do curso \"([^\"]*)\"$")
    public void apresentaATelaComOsDetalhesDoCurso(String curso) {
        Assert.assertEquals(curso, detalhesCurso.retornaTituloPaginaDetalhamentoCurso(curso));
    }

    @And("^valida se o valor parcelado corresponde com o valor total do curso$")
    public void validaSeOValorParceladoCorrespondeComOValorTotalDoCurso() {
        Assert.assertEquals(String.valueOf(valorCursoParcelado),String.valueOf(detalhesCurso.obterValorTotalCurso()));
    }
}
