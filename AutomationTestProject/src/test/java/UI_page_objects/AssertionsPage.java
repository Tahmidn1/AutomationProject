package UI_page_objects;

import org.openqa.selenium.By;

public class AssertionsPage extends BasePage {

    //Locators

    private By DucksPageGoogle = By.xpath("//span[contains(text(),'Duck is the common name for numerous species of')]");


    public String getDucksConfirmationPg(){
        return explicitFunction(DucksPageGoogle).getText();
    }

}
