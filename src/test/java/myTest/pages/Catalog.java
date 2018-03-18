package myTest.pages;

import org.openqa.selenium.By;

/**
 * Created by Администратор on 17.03.2018.
 */
public class Catalog {
    private static By catalog = By.id("subtab-AdminCatalog");
    private static By addNewProduct = By.id("page-header-desc-configuration-add");
    private static By productName = By.cssSelector("#form_step1_name_1");
    private static By selectQtyTab = By.cssSelector("#tab_step3 > a");
    private static By selectPriceTab = By.cssSelector("#tab_step2 > a");
    private static By inputQty = By.id("form_step3_qty_0");
    private static By inputPrice = By.cssSelector("#form_step2_price");
    private static By productsSubItem = By.xpath(".//*[@id='subtab-AdminProducts']/a");
    private static By switchInputButton = By.cssSelector(".switch-input");
    private static By closeAlert = By.cssSelector(".growl-close");
    private static By saveProductButton = By.cssSelector("#submit");
    private static By alertMessage = By.id("growls");
    private static By inputNameFilter = By.cssSelector("#product_catalog_list > div:nth-child(2) > div > table > thead > tr.column-filters > th:nth-child(3) > input");
    private static By filterButton = By.xpath("//*[@id=\"product_catalog_list\"]/div[2]/div/table/thead/tr[2]/th[9]/button[1]");
    private static By lastAddCategory = By.xpath("//tbody/tr[last()]//td[3]");


    public static By getFilterButton() {
        return filterButton;
    }

    public static By getInputNameFilter() {
        return inputNameFilter;
    }

    public static By getSaveProductButton() {
        return saveProductButton;
    }

    public static By getCloseAlert() {
        return closeAlert;
    }

    public static By getSwitchInputButton() {
        return switchInputButton;
    }

    public static By getProductsSubItem() {
        return productsSubItem;
    }

    public static By getCatalog() {
        return catalog;
    }

    public static By getAddNewProduct() {
        return addNewProduct;
    }

    public static By getProductName() {
        return productName;
    }

    public static By getSelectQtyTab() {
        return selectQtyTab;
    }

    public static By getSelectPriceTab() {
        return selectPriceTab;
    }

    public static By getInputQty() {
        return inputQty;
    }

    public static By getInputPrice() {
        return inputPrice;
    }
}
