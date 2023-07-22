package ru.stqa.ptf.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void groups() {

        click(By.xpath("//body"));
    }


    public void addNew() {
        wd.get("http://localhost/addressbook/edit.php");
    }

    public void home() {
        wd.get("http://localhost/addressbook/");
    }
    public void clickOkOnAlert() {
        wd.switchTo().alert().accept();
    }

}
