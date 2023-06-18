package ru.stqa.ptf.addressbook.tests;

import org.openqa.selenium.remote.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.ptf.addressbook.appmanager.ApplicationManager;
import sun.plugin2.util.BrowserType;

public class TestBase {

    public final ApplicationManager app = new ApplicationManager(Browser.FIREFOX);

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        app.init();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        app.stop();

    }

}
