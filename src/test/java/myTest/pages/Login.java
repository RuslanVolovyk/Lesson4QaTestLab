package myTest.pages;

import org.openqa.selenium.By;

/**
 * Created by Администратор on 17.03.2018.
 */
public class Login {
    private static By login = By.id("email");
    private static  By password = By.id("passwd");
    private static By signIn = By.name("submitLogin");

    public static By getLogin() {
        return login;
    }

    public static By getPassword() {
        return password;
    }

    public static By getSignIn() {
        return signIn;
    }

 }
