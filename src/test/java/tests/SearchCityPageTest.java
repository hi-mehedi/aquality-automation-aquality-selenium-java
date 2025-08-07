package tests;

import constants.MainPageNavigation;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchCityPage;

public class SearchCityPageTest extends BaseTest{
    SearchCityPage searchCityPage = new SearchCityPage();

    @Test
    public void searchCityTest(){
        mainPage.clickNavigationLink(MainPageNavigation.HOME_PAGE);
        searchCityPage.inputCityText("New York");
        Assert.assertTrue(searchCityPage.isSearchResultDisplayed(), "Search result is not displayed");
        String rawFirstResultText = searchCityPage.getFirstSearchResultText();
        String expectedCityText = rawFirstResultText.replace(" US", "").trim();
        searchCityPage.clickFirstSearchResult();
        Assert.assertTrue(searchCityPage.isNewPageDisplayed(), "Did not navigate to expected city weather page");
        String actualHeaderText = searchCityPage.getHeaderVerifiedText().trim();
        Assert.assertEquals(actualHeaderText, expectedCityText, "Is not equal");
    }
}
