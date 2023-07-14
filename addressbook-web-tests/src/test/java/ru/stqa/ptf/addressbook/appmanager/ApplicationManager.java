package ru.stqa.ptf.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    public WebDriver wd;

    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private ContactHelper contactHelper;
    private Browser browser;

    public ApplicationManager (Browser browser) {
        this.browser = browser;
    }

    public void init() {

        if (browser.equals(Browser.FIREFOX))
        {
            wd = new FirefoxDriver();
        }
        else if (browser.equals(Browser.CHROME))
        {
            wd = new ChromeDriver();
        }


        wd.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/group.php");

        groupHelper = new GroupHelper(wd);
        contactHelper = new ContactHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper = new SessionHelper(wd);
        sessionHelper.login("admin", "secret");

    }

    public void stop() {
        wd.quit();
    }


    public GroupHelper group() {
        return groupHelper;
    }

    public NavigationHelper navigation() {
        return navigationHelper;
    }

    public ContactHelper contact() {
        return contactHelper;
    }
}
