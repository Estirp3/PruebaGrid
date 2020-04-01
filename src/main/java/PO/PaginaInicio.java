package PO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaginaInicio extends BasePage{

    public PaginaInicio (WebDriver driver){
        super(driver);
    }
    String url ="https://www.google.com/";

    @FindBy (xpath = "//input[contains(@name,'q')]")
    WebElement Buscador;
    @FindBy (xpath = "(//input[contains(@class,'gNO89b')])[2]")
    WebElement BtnBUscar;

    public void IngresoPagina(){
        driver.get(url);
    }
    public void buscar(){
       Buscador.sendKeys("Cloud");
    }
}
