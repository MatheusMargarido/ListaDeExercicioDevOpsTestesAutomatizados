import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Assertions;

public class NavigationHistoryTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "caminho/para/chromedriver");
        WebDriver driver = new ChromeDriver();

        // Navega para a página inicial do Google
        driver.get("https://www.google.com");
        String titleHome = driver.getTitle();
        System.out.println("Título inicial: " + titleHome);

        // Navega para outra página (por exemplo, "Sobre o Google")
        driver.get("https://about.google/");
        String titleAbout = driver.getTitle();
        System.out.println("Título da página About: " + titleAbout);

        // Voltar para a página anterior
        driver.navigate().back();
        Assertions.assertEquals(titleHome, driver.getTitle());
        System.out.println("Voltou para o início: " + driver.getTitle());

        // Avança para a página About novamente
        driver.navigate().forward();
        Assertions.assertEquals(titleAbout, driver.getTitle());
        System.out.println("Avançou para About: " + driver.getTitle());

        // Recarrega a página atual
        driver.navigate().refresh();
        Assertions.assertEquals(titleAbout, driver.getTitle());
        System.out.println("Após refresh: " + driver.getTitle());

        driver.quit();
    }
}
