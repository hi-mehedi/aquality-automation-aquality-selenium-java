package tests;

import constants.MainPageNavigation;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TemperatureMeasurementPage;

public class TemperatureMeasurementTest extends BaseTest{
    TemperatureMeasurementPage temperatureMeasurementPage = new TemperatureMeasurementPage();

    @Test
    public void temperatureTest(){
        mainPage.clickNavigationLink(MainPageNavigation.HOME_PAGE);
        Assert.assertTrue(temperatureMeasurementPage.isCelsiusDisplayed(),"Celsius is Displayed");
        temperatureMeasurementPage.clickBtn();
        Assert.assertTrue(temperatureMeasurementPage.isSettingDisplayed(), "Setting is not displayed");
        temperatureMeasurementPage.clickSetting();
        temperatureMeasurementPage.selectFahrenheit();
        temperatureMeasurementPage.neviBack();
        Assert.assertTrue(temperatureMeasurementPage.isFahrenheitDisplayed(), "Fahrenheit is Displayed");
    }
}
