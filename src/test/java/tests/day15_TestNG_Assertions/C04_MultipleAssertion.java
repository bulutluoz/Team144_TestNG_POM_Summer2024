package tests.day15_TestNG_Assertions;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_MultipleAssertion {

    @Test
    public void aramaTesti(){

        // Testotomasyonu anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        // url'in "testotomasyonu" icerdigini test edin
        String expectedUrlIcerik = "testotomasyonuTTT";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));

        // belirlenmis arama kelimesi icin arama yapin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();

        testOtomasyonuPage.aramaKutusu
                            .sendKeys(ConfigReader.getProperty("toAranacakKelime") + Keys.ENTER);

        // bulunan urun sayisinin 3'den fazla oldugunu test edin

        int expectedMinUrunSayisi = 30;
        int actualBulunanUrunSayisi = testOtomasyonuPage.bulunanUrunElementleriList
                                                        .size();

        Assert.assertTrue(actualBulunanUrunSayisi > expectedMinUrunSayisi);

        //ilk urunu tiklayin
        testOtomasyonuPage.bulunanUrunElementleriList
                            .get(0)
                            .click();

        // acilan sayfada urun isminde case sensitive olmadan
        // aranacak kelimenin bulundugunu test edin

        String actualUrunIsmi = testOtomasyonuPage.ilkUrunSayfasiIsimElementi
                                                    .getText()
                                                    .toLowerCase();
        String expectedisimIcerik = ConfigReader.getProperty("toAranacakKelime");

        Assert.assertTrue(actualUrunIsmi.contains("Ali"));

        Driver.quitDriver();
    }
}
