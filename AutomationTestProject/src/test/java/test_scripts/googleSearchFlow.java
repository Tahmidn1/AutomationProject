package test_scripts;
import org.testng.Assert;
import org.testng.annotations.Test;
import UI_page_objects.AssertionsPage;
import UI_page_objects.LandingPage;

public class googleSearchFlow extends DriverWrapper{



    @Test

    public void verifyDuckSearch() throws InterruptedException {



        LandingPage landingPage = new LandingPage();
        AssertionsPage assertionsPage = new AssertionsPage();
        landingPage.searchforDucks("Ducks");
        landingPage.clickSearchBtnGoogle();


        //assertions
        //validate Ducks is appeared


        Assert.assertEquals(assertionsPage.getDucksConfirmationPg(),"Duck is the common name for numerous species of waterfowl in the family Anatidae. Ducks are generally smaller and shorter-necked than swans and geese, which are members of the same family.","error");

        System.out.println("Text from Ducks Picture = " + assertionsPage.getDucksConfirmationPg());

    }









}
