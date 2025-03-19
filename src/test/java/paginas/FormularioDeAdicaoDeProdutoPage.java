package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormularioDeAdicaoDeProdutoPage {
    private WebDriver navegador;

    public FormularioDeAdicaoDeProdutoPage(WebDriver navegador) {
        this.navegador = navegador;
    }

    public FormularioDeAdicaoDeProdutoPage inserirNomeDoProduto(String nomeProduto) {
        navegador.findElement(By.id("produtonome")).sendKeys(nomeProduto);

        return this;
    }

    public FormularioDeAdicaoDeProdutoPage inserirValorDoProduto(String valorProduto) {
        navegador.findElement(By.id("produtovalor")).sendKeys(valorProduto);

        return this;
    }

    public FormularioDeAdicaoDeProdutoPage inserirCorDoProduto(String corProduto) {
        navegador.findElement(By.id("produtocores")).sendKeys(corProduto);

        return this;
    }

    public ListaDeProdutosPage submeterFormularioDeAdicaoComErro() {
        navegador.findElement(By.cssSelector("button[type='submit']")).click();

        return new ListaDeProdutosPage(navegador);
    }
}
