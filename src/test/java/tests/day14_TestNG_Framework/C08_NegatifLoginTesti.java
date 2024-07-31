package tests.day14_TestNG_Framework;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C08_NegatifLoginTesti {

    @Test
    public void negativeLoginTesti(){

        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        //2- account linkine basin
        TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
        testOtomasyonuPage.accountLinki
                            .click();

        //3- gecerli email, gecersiz password yazin
        testOtomasyonuPage.loginEmailKutusu
                            .sendKeys(ConfigReader.getProperty("toGecerliEmail"));
        testOtomasyonuPage.loginPasswordKutusu
                            .sendKeys(ConfigReader.getProperty("toGecersizPassword"));

        //4- Login butonuna basarak login olmayi deneyin
        testOtomasyonuPage.loginSignInButonu
                            .click();
        //5- Basarili olarak giris yapilamadigini test edin
        //   giris yapamadigimizi test etmek icin
        //   Email kutusunun hala gorundugunu test edebiliriz
        Assert.assertTrue(testOtomasyonuPage.loginEmailKutusu.isDisplayed());
    }
}
