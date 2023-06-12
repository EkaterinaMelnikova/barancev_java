package ru.stqa.ptf.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper {
    private WebDriver wd;

    public NavigationHelper(WebDriver wd) {
        this.wd = wd;
    }

    public void gotoGroupPage() {
        wd.findElement(By.xpath("//body")).click();
    }


    public void gotoContactAddPage() {
        wd.get("http://localhost/addressbook/edit.php");
    }

    public void gotoMainPage() {
        wd.get("http://localhost/addressbook/");
    }
}
