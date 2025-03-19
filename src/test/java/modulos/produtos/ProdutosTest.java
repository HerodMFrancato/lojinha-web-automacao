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
        String mensagemApresentada = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormularioDeLogin()
                .acessarOFormularioDeAdicaoDeNovoProduto()
                .inserirNomeDoProduto("Iphone 16")
                .inserirValorDoProduto("000")
                .inserirCorDoProduto("Branco")
                .submeterFormularioDeAdicaoComErro()
                .capturarMensagemApresentada();
        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentada);
    }

    @AfterEach
    public void tearDown() {
        if (navegador != null) {
            navegador.quit();
        }
    }
}
