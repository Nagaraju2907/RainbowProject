package stepdefination;

import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import resuable.BaseCode;

import java.io.IOException;
import java.time.Duration;

public class AmazonCodeSteps extends BaseCode {

    @Given("user selects the category in the homepage")
    public void selectCategory() throws IOException {

        WebElement selectCategroryElement = driver.findElement(By.id("searchDropdownBox"));
        Select catergory = new Select(selectCategroryElement);
       // catergory.selectByIndex(3);
       // catergory.selectByVisibleText("Beauty");
        catergory.selectByValue("search-alias=appliances");

       int dropdownCount = selectCategroryElement.findElements(By.tagName("option")).size();
       System.out.println(dropdownCount);

        for (int i=0 ; i < dropdownCount ;i++){

           String val= selectCategroryElement.findElements(By.tagName("option")).get(i).getText();

            System.out.println(val);
        }

    }

    @Given("user handles the dynamic dropdown")
    public void userHandlesTheDynamicDropdown() {

        driver.findElement(By.id("ControlGroupSearchView_AvailabilitySearchInputSearchVieworiginStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='BLR']")).click();

//        WebElement toElement = driver.findElement(By.id("ControlGroupSearchView_AvailabilitySearchInputSearchViewdestinationStation1_CTNR"));
//        toElement.findElement(By.xpath("//a[@value='MAA']")).click();

        driver.findElement(By.xpath("//div[@id='ControlGroupSearchView_AvailabilitySearchInputSearchViewdestinationStation1_CTNR']//a[@value='MAA']")).click();

    }

    @Given("user extracts the column one value")
    public void userExtractsTheColumnOneValue() {

        WebElement infosysTable = driver.findElement(By.xpath("//table[@class='infobox vcard']"));

       int colunOneCount = infosysTable.findElements(By.tagName("th")).size();

        for(int n =0 ;n < colunOneCount ;n++ ){

            String valu =infosysTable.findElements(By.tagName("th")).get(n).getText();
            System.out.println(valu);
        }

        int colunTwoCount = infosysTable.findElements(By.tagName("td")).size();
        for(int n =2 ;n < colunTwoCount ;n++ ){

            String valu =infosysTable.findElements(By.tagName("td")).get(n).getText();
            System.out.println(valu);
        }

        WebElement acqElement = driver.findElement(By.xpath("//table[@class='wikitable']"));

       int colunTwo = acqElement.findElements(By.xpath("/tbody/tr/td[5]")).size();

       for (int h =0 ; h < colunTwo; h++){
           String valu =acqElement.findElements(By.xpath("/tbody/tr/td[5]")).get(h).getText();
           System.out.println(valu);
       }


    }

    @Given("user navigates to baby wish list page")
    public void userNavigatesToBabyWishListPage() {

        WebElement accountListElement = driver.findElement(By.id("nav-link-accountList"));
        Actions action = new Actions(driver);
        action.clickAndHold(accountListElement).build().perform();

       // driver.findElement(By.xpath("//span[text()='Baby Wishlist']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.pollingEvery(Duration.ofSeconds(2));
        wait.ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Baby Wishlist")));

        driver.findElement(By.linkText("Baby Wishlist")).click();

    }

    @Given("user handles the drag and drop")
    public void userHandlesTheDragAndDrop() {

        WebElement frameElement = driver.findElement(By.className("demo-frame"));
        driver.switchTo().frame(frameElement);

        WebElement drag = driver.findElement(By.id("draggable"));
        WebElement drop = driver.findElement(By.id("droppable"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(drag,drop).build().perform();

        driver.switchTo().defaultContent();


    }
}
