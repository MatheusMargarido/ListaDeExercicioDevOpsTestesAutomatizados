import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class VerifySearchResult {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "caminho/para/chromedriver");
        WebDriver driver = new ChromeDriver();

        // Acessa a página de resultados de busca do Google para "Selenium WebDriver"
        driver.get("https://www.google.com/search?q=Selenium+WebDriver");

        // Localiza elementos que contenham "selenium.dev" no link
        List<WebElement> elements = driver.findElements(By.partialLinkText("selenium.dev"));

        if (elements.isEmpty()) {
            System.out.println("Elemento não encontrado.");
        } else {
            System.out.println("Elemento encontrado!");
        }

        driver.quit();
    }
}
