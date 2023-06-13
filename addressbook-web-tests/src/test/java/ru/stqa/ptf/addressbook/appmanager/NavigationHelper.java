package ru.stqa.ptf.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void gotoGroupPage() {

        click(By.xpath("//body"));
    }


    public void gotoContactAddPage() {
        wd.get("http://localhost/addressbook/edit.php");
    }

    public void gotoMainPage() {
        wd.get("http://localhost/addressbook/");
    }
}
