package steps;
//automatización

import driver.SeleniumWebDriver;
import org.openqa.selenium.By;
import page.EbayPage;
import util.Excel;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Map;
import java.io.IOException;

public class EbaySteps {

    private static ArrayList<Map<String, String>> lecturaExcel = new ArrayList<Map<String,String>>();

    public void escribirEnTexto(By elemento, String texto) {
        boolean validarElemento = false;
        while (validarElemento == false) {
            try {
                Thread.sleep(2000);
                SeleniumWebDriver.driver.findElement(elemento).sendKeys(texto);
                validarElemento = true;
            }
            catch (Exception e) {

            }
        }
    }
    public void clicEnElemento(By elemento) {
        boolean validarElemento = false;
        while (validarElemento == false) {
            try {
                Thread.sleep(2000);
                SeleniumWebDriver.driver.findElement(elemento).click();
                validarElemento = true;
            } catch (Exception e) {

            }
        }
    }
    public String obtenerTextoDeElemento(By elemento) {
        boolean validarElemento = false;
        String textElemento = "";
        while (validarElemento == false) {
            try {
                Thread.sleep(2000);
                textElemento = SeleniumWebDriver.driver.findElement(elemento).getText();
                validarElemento = true;
            } catch (Exception e) {

            }
        }
        return textElemento;
    }
    public void validarTextoEnPantalla(By elemento, String texto) {
        boolean validarTexto = false;
        if(obtenerTextoDeElemento(elemento).contains(texto)) {
            validarTexto = true;
        }
        assertEquals(true, validarTexto);
    }

    public void buscarProductoEnEbay() {
        try {
            lecturaExcel = Excel.readExcel("C:\\Users\\57321\\Desktop\\productos.xlsx", "Hoja1");
        } catch (IOException e) {

            e.printStackTrace();
        }
        for (int i = 0; i < lecturaExcel.size(); i++) {

            try {
                Thread.sleep(1000);
                escribirEnTexto(EbayPage.getTxtBuscadorArticulos(), lecturaExcel.get(i).get("productos"));
            }catch (Exception e){
                e.printStackTrace();
            }
            try {
                Thread.sleep(3000);
                clicEnElemento(EbayPage.getBtnBuscadorArticulos());
                EbayPage.setBtnProducto(lecturaExcel.get(i).get("productos"));
                Thread.sleep(3000);
                clicEnElemento(EbayPage.getBtnProducto());
                Thread.sleep(3000);
                EbayPage.setLblProducto(lecturaExcel.get(i).get("productos"));
                Thread.sleep(3000);
                validarTextoEnPantalla(EbayPage.getLblProducto(), lecturaExcel.get(i).get("productos"));
                Thread.sleep(3000);
                clicEnElemento(EbayPage.getBtnBuscadorArticulos2());
                Thread.sleep(3000);
            }catch (Exception e){
                e.printStackTrace();
            }



        }
    }
}








