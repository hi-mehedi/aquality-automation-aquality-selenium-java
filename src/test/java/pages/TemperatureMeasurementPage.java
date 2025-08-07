package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.IComboBox;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class TemperatureMeasurementPage extends Form {
    private final By degree = By.xpath("(//span[@class='recent-location-temp-unit'])[1]");
    private final ITextBox viewDegree = AqualityServices.getElementFactory().getTextBox(degree, "Check Degree");
    private final By menu = By.xpath("//*[@data-qa='navigationMenu']");
    private final IButton menuBtn = AqualityServices.getElementFactory().getButton(menu, "Click Button");
    private final By settingLink = By.xpath("//div[@class='settings-link']/a");
    private final IButton settingLinkBtn = AqualityServices.getElementFactory().getButton(settingLink, "Click Setting");
    private final By selectMenu = By.id("unit");
    private final IComboBox selectDrop = AqualityServices.getElementFactory().getComboBox(selectMenu, "Select Menu");

    public TemperatureMeasurementPage(){
        super(null,"");
    }
    public boolean isCelsiusDisplayed(){
         viewDegree.state().waitForDisplayed();
        return viewDegree.getText().contains("C");
    }

    public void clickBtn(){
        menuBtn.click();
    }

    public boolean isSettingDisplayed(){
        return settingLinkBtn.state().waitForDisplayed();
    }

    public void clickSetting(){
        settingLinkBtn.click();
    }

    public void selectFahrenheit() {
        selectDrop.selectByValue("F");
    }

    public void neviBack(){
        AqualityServices.getBrowser().goBack();
    }

    public boolean isFahrenheitDisplayed(){
        viewDegree.state().waitForDisplayed();
        return viewDegree.getText().contains("F");
    }
}
