import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenshotOnFailureExample {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "caminho/para/chromedriver");
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.google.com");
            // Tenta localizar um elemento que não existe para simular uma falha
            driver.findElement(By.id("elementoInexistente"));
        } catch (Exception e) {
            System.out.println("Exceção capturada: " + e.getMessage());
            // Captura a screenshot usando a interface TakesScreenshot
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                // Certifique-se de que o diretório "./screenshots" exista
                FileUtils.copyFile(screenshot, new File("./screenshots/falha.png"));
                System.out.println("Screenshot salva em './screenshots/falha.png'");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        } finally {
            driver.quit();
        }
    }
}
