package modulos.produtos;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
    }

    @Test
    @DisplayName("Não é permitido registrar produto igual a zero")
    public void testNaoEPermitidoRegistrarProdutoComValorIgualAZero() {
        navegador.get("http://165.227.93.41/lojinha-web/v2/");
    }

    @AfterEach
    public void tearDown() {
        if (navegador != null) {
            navegador.quit();
        }
    }
}
