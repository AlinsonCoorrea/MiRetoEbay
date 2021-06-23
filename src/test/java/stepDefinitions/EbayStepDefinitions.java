package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.SeleniumWebDriver;
import net.thucydides.core.annotations.Steps;
import page.EbayPage;
import steps.EbaySteps;

public class EbayStepDefinitions {
    @Steps
    EbaySteps ebaySteps = new EbaySteps();

    @Given("^que me encuentro en la pagina de OLX con la url https://co\\.ebay\\.com/$")
    public void que_me_encuentro_en_la_pagina_de_OLX_con_la_url_https_co_ebay_com() {
        SeleniumWebDriver.ChromeWebDriver("https://co.ebay.com/");
    }

    @When("^busco el proudcto en el buscador$")
    public void busco_el_proudcto_en_el_buscador() {

        try {
            Thread.sleep(3000);
            ebaySteps.buscarProductoEnEbay();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Then("^podre ver el producto en pantalla$")
    public void podre_ver_el_producto_en_pantalla() {
        SeleniumWebDriver.driver.quit();

    }

}
