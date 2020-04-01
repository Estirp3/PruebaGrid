import PO.BasePage;
import PO.PaginaInicio;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.PropertyConfigurator;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static Test.testMethods.takeSnapShot;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Test_01 {

    String log4jConfPath = "./src/test/resources/log4j.properties";
    WebDriver driver;

    PaginaInicio pagini;
    BasePage base;

    @BeforeAll
    public void SetUp() throws MalformedURLException {

        //Define desired capabilities
        DesiredCapabilities cap=new DesiredCapabilities();
        cap.setBrowserName("chrome");
        cap.setPlatform(Platform.LINUX);

        //Chrome option
        ChromeOptions options = new ChromeOptions();
        options.merge(cap);
        //options.setHeadless(true);

        //FireFox
        FirefoxOptions opFix = new FirefoxOptions();
        opFix.merge(cap);
        //Hub URL
        String huburl ="http://35.238.76.96:4444/wd/hub";

        // Create driver with hub address and capability
        driver=new RemoteWebDriver(new URL(huburl), options);
        options.addArguments("--start-maximized");

        this.pagini = new PaginaInicio(driver);
        this.base = new BasePage(driver);
    }
    @AfterAll
    public void tear(){
        driver.close();
    }

    @AfterEach
    public void afterEach(TestInfo testinfo) throws Exception {
        base.Log("Se toma Imagen");
        takeSnapShot(this.driver, this.getClass().getName()+"-"+testinfo.getDisplayName());
    }

    @Test
    @Order(1)
    public void Paso1() {
        base.Log("Se inicia prueba");
        pagini.IngresoPagina();
    }


}
