package page;
import org.openqa.selenium.By;
public class EbayPage {

    //1.barra busqueda
    private static By txtBuscadorArticulos = By.xpath("//input[contains(@class,'gh-tb ui-autocomplete-input')]");
    ////input[@class='gh-tb ui-autocomplete-input']

    //2.----btn busca
    private static By btnBuscadorArticulos = By.xpath("//input[contains(@class,'btn btn-prim gh-spr')]");

    private static By btnBuscadorArticulos2 = By.xpath("//input[contains(@class,'btn btn-ter gh-spr')]");

    //3.
    private static By btnProducto;

    //4.
    private static By lblProducto;
    public static By getBtnProducto() {
        return btnProducto ;
    }

    //xpath generico
    public static void setBtnProducto(String producto) {
        EbayPage.btnProducto = By.xpath("//h3[contains(text(),'"+producto+"')]//ancestor::a");
    }

    public static By getLblProducto() {
        return lblProducto;
    }

    public static void setLblProducto(String producto) {
        EbayPage.lblProducto = By.xpath("//h1[contains(text(),'"+producto+"')]");
    }

    public static By getTxtBuscadorArticulos() {
        return txtBuscadorArticulos;
    }

    public static By getBtnBuscadorArticulos() {
        return btnBuscadorArticulos;
    }

    public static By getBtnBuscadorArticulos2() {
        return btnBuscadorArticulos2;
    }
}
