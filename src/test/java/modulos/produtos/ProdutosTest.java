package modulos.produtos;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import paginas.LoginPage;

import java.util.concurrent.TimeUnit;

@DisplayName("Testes Web do Módulo de Produtos")

public class ProdutosTest {
    private WebDriver navegador;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/herodfrancato/drivers/chromedriver");
        navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        navegador.manage().window().maximize();
        navegador.get("http://165.227.93.41/lojinha-web/v2/");
    }
    @Test
    @DisplayName("Não é permitido registrar produto igual a zero")
    public void testNaoEPermitidoRegistrarProdutoComValorIgualAZero() {
        new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                .acessarOFormularioDeAdicaoDeNovoProduto();


        navegador.findElement(By.id("produtonome")).sendKeys("Iphone 16");
        navegador.findElement(By.id("produtovalor")).sendKeys("000");
        navegador.findElement(By.id("produtocores")).sendKeys("Branco");
        navegador.findElement(By.cssSelector("button[type='submit']")).click();
        String mensagemToats = navegador.findElement(By.cssSelector(".toast.rounded")).getText();
        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemToats);
    }

    @AfterEach
    public void tearDown() {
        if (navegador != null) {
            navegador.quit();
        }
    }
}
