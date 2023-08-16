package UI_page_objects;

import org.openqa.selenium.By;

public class LandingPage extends BasePage{

    private By googleSubmitBtn = By.xpath("//body//div//div//div//div//div//div//div//center//input[@value='Google Search']");

    private By googleSearchTextBox = By.xpath("//div//textarea[contains(@id,'')]");


    public void searchforDucks(String value){
        explicitFunction(googleSearchTextBox).click();
        setValue(googleSearchTextBox,value);

    }

    public void clickSearchBtnGoogle(){
        explicitFunction(googleSubmitBtn).click();
    }












}
