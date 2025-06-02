import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenCloseBrowser {
    public static void main(String[] args) {
        // Defina o caminho para o executável do ChromeDriver
        System.setProperty("webdriver.chrome.driver", "caminho/para/chromedriver");

        // Inicializa o navegador
        WebDriver driver = new ChromeDriver();
        System.out.println("Navegador aberto.");

        // Aguarda 5 segundos para visualização
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Fecha o navegador
            driver.quit();
            System.out.println("Navegador fechado.");
        }
    }
}
