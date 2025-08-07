package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import constants.MainPageNavigation;
import org.openqa.selenium.By;
import utils.EnvDataReader;

public class MainPage extends Form {

    public MainPage() {
        super(null, "Main Page");
    }

    public void clickNavigationLink(MainPageNavigation navigation) {
        switch (navigation.getType()) {
            case PATH:
                // Use EnvDataReader to get host and append path
                String url = EnvDataReader.getEnvData().getHost() + navigation.getValue();
                AqualityServices.getBrowser().goTo(url);
                break;

            case HREF:
                // Find link by href and click
                ILink linkByHref = AqualityServices.getElementFactory().getLink(
                        By.xpath("//a[@href='" + navigation.getValue() + "']"),
                        "Click link with href: " + navigation.getValue()
                );
                linkByHref.click();
                break;

            case TEXT:
                // Find element by text and click
                ILink linkByText = AqualityServices.getElementFactory().getLink(
                        By.xpath("//*[text()='" + navigation.getValue() + "']"),
                        "Click element with text: " + navigation.getValue()
                );
                linkByText.click();
                break;
        }
    }

}
