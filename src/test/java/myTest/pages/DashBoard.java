package myTest.pages;

import org.openqa.selenium.By;

/**
 * Created by Администратор on 17.03.2018.
 */
public class DashBoard {
    private static By dashBoardCatalogItem = By.xpath("/html/body/nav/ul/li[1]/a/span");

    public static By getDashBoardCatalogItem() {
        return dashBoardCatalogItem;
    }


}
