package myTest.pages;

import org.openqa.selenium.By;

/**
 * Created by Администратор on 17.03.2018.
 */
public class LogOut {
    private static By pictogramma = By.className("employee_avatar_small");
    private static By logOut = By.id("header_logout");

    public static By getPictogramma() {
        return pictogramma;
    }

    public static By getLogOut() {
        return logOut;
    }
}
