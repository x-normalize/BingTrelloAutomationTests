package test.cases.trello;

import com.telerikacademy.testframework.UserActions;
import org.junit.After;
import org.junit.Before;
import pages.trello.LoginPage;

public class BaseTest {

    UserActions actions = new UserActions();

    @Before
    public void setUp() {

        UserActions.loadBrowser("trello.homePage");

    }

    @After
    public void tearDown() {

        UserActions.quitDriver();

    }

    public void login() {

        LoginPage loginPage = new LoginPage(actions.getDriver());
        loginPage.loginUser("user");
    }

}
