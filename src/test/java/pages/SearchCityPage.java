package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import constants.MainPageNavigation;
import org.openqa.selenium.By;

public class SearchCityPage extends Form {
    public static final String Name = "I Understand";
    private final By SearchInput = By.xpath("//input[@name='query']");;
    private final By searchResultItem = By.xpath("//div[@class='results-container']");
    private final By firstResult = By.xpath("(//div[@class='search-bar-result search-result source-radar'])[1]");
    private final ITextBox inputSearch = AqualityServices.getElementFactory().getTextBox(SearchInput,"Type city Name");
    private final ITextBox resultItem = AqualityServices.getElementFactory().getTextBox(searchResultItem, "Search result item");
    private final ITextBox firstSearchResult = AqualityServices.getElementFactory().getTextBox(firstResult, "First Search Result");
    private final By verifiedHeader = By.xpath("//h1[@class='header-loc']");
    private final ITextBox headerVerified = AqualityServices.getElementFactory().getTextBox(verifiedHeader,"Header");
    private final By verifiedSearch = By.xpath("(//p[@class='search-bar-result__long-name'])[1]");
    private final ITextBox searchVerified = AqualityServices.getElementFactory().getTextBox(verifiedSearch,"Get Search");


    public SearchCityPage(){
        super(null, "Home Page");
    }

    public void inputCityText(String text){
        inputSearch.clearAndType(text);
    }

    public boolean isSearchResultDisplayed() {
        return resultItem.state().waitForDisplayed();
    }
    public String getFirstSearchResultText() {
        searchVerified.state().waitForDisplayed();
        return searchVerified.getText();
    }
    public void clickFirstSearchResult(){
        firstSearchResult.click();
    }
    public boolean isNewPageDisplayed() {
        return AqualityServices.getConditionalWait().waitFor(() ->
                AqualityServices.getBrowser().getCurrentUrl().contains(MainPageNavigation.NEW_PAGE.getValue())
        );
    }
    public String getHeaderVerifiedText() {
        headerVerified.state().waitForDisplayed();
        return headerVerified.getText();
    }
}
