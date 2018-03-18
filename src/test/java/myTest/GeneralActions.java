package myTest;

import myTest.pages.Catalog;
import myTest.pages.DashBoard;
import myTest.pages.LogOut;
import myTest.pages.Login;
import myTest.utils.Properties;
import myTest.utils.Utils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;


import static myTest.utils.Utils.getName;
import static myTest.utils.Utils.getPrice;
import static myTest.utils.Utils.getQuantity;


/**
 * Created by Администратор on 17.03.2018.
 */
public class GeneralActions extends BaseTest {
    private static WebDriver driver = getConfiguredDriver();
    private static WebDriverWait wait = new WebDriverWait(driver, 5);

//    public GeneralActions(WebDriver driver) {
//        this.driver = driver;
//        wait = new WebDriverWait(driver, 30);
//    }

    public static void login(String login, String password) {
        driver.get(Properties.getBaseAdminUrl());
        driver.findElement(Login.getLogin()).isDisplayed();
        driver.findElement(Login.getLogin()).sendKeys(login);
        driver.findElement(Login.getPassword()).sendKeys(password);
        driver.findElement(Login.getSignIn()).click();

    }

    public static void logout() {
        wait.until(ExpectedConditions.elementToBeClickable(LogOut.getPictogramma()));
        driver.findElement(LogOut.getPictogramma()).click();
        wait.until(ExpectedConditions.elementToBeClickable(LogOut.getLogOut()));
        driver.findElement(LogOut.getLogOut()).click();
    }

    public static void dashBoardPage() {
        driver.findElement(DashBoard.getDashBoardCatalogItem()).click();
        wait.until(ExpectedConditions.elementToBeClickable(Catalog.getCatalog()));
    }

    public static void selectProductTab() {
        wait.until(ExpectedConditions.elementToBeClickable(Catalog.getCatalog()));

        WebElement webElement = driver.findElement(Catalog.getCatalog());
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(Catalog.getProductsSubItem()));
        webElement.findElement(Catalog.getProductsSubItem()).click();
        wait.until(ExpectedConditions.elementToBeClickable(Catalog.getAddNewProduct()));
    }

    public static void createProduct() {
        driver.findElement(Catalog.getAddNewProduct()).click();
        driver.findElement(Catalog.getProductName()).sendKeys(Utils.randomStringName());
        driver.findElement(Catalog.getSelectQtyTab()).click();
        driver.findElement(Catalog.getInputQty()).clear();
        driver.findElement(Catalog.getInputQty()).sendKeys(Utils.randomIntData(1, 100));
        driver.findElement(Catalog.getSelectPriceTab()).click();
        driver.findElement(Catalog.getInputPrice()).clear();
        driver.findElement(Catalog.getInputPrice()).sendKeys(Utils.randomFloatData(1, 100));
        driver.findElement(Catalog.getSwitchInputButton()).click();
        driver.findElement(Catalog.getCloseAlert()).click();
        driver.findElement(Catalog.getSaveProductButton()).click();
        driver.findElement(Catalog.getCloseAlert()).click();
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }

    public static void waitForContentLoad(By element) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public static void alertAccepted() {
        try {
            Alert alert = driver.switchTo().alert();
            alert.getText();
            System.out.println("Alert detected: {}" + alert.getText());
            alert.accept();
        } catch (Exception e) {
        }
    }

    public static void checkProductAdd() throws InterruptedException {
        Assert.assertTrue(isLastProductAdd(), "The last product is not found");
        driver.findElement(By.linkText(Utils.getName())).click();
        wait.until(ExpectedConditions.elementToBeClickable(Catalog.getProductName()));
        Assert.assertEquals(driver.findElement(Catalog.getProductName()).getAttribute("value"), getName(), "Assert name failed");
        Reporter.log("Assert name passed");
        Assert.assertEquals(driver.findElement(Catalog.getInputQty()).getAttribute("value"), getQuantity());
        Reporter.log("Assert name passed");
        Assert.assertEquals(driver.findElement(Catalog.getInputPrice()).getAttribute("value"), getPrice());
        Reporter.log("Assert name passed");
    }

    public static boolean isLastProductAdd() throws InterruptedException {
        boolean isLastProductAdd = false;
        driver.findElement(Catalog.getInputNameFilter()).clear();
        driver.findElement(Catalog.getInputNameFilter()).sendKeys(getName());
        Thread.sleep(2000);
        driver.findElement(Catalog.getFilterButton()).click();
        String text = driver.findElement(By.linkText(Utils.getName())).getText();
        System.out.println("Actual product name: " + getName() + "\n" + "Expected product name: " + text);
        if (text.equals(getName())) {
            isLastProductAdd = true;
        }
        return isLastProductAdd;
    }
}
