package myTest.tests;

import myTest.BaseTest;
import myTest.GeneralActions;
import org.testng.annotations.Test;

import static myTest.GeneralActions.checkProductAdd;

/**
 * Created by Администратор on 17.03.2018.
 */
public class MyTests extends BaseTest {
    @Test(dataProvider = "login")
    void login(String sUsername, String sPassword) throws InterruptedException {
        GeneralActions.login(sUsername, sPassword);
        GeneralActions.selectProductTab();
        GeneralActions.createProduct();
        GeneralActions.dashBoardPage();
        GeneralActions.selectProductTab();
        checkProductAdd();
        checkProductAdd();

    }
}
