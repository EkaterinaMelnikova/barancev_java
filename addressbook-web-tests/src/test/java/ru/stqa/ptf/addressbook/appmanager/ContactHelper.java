package ru.stqa.ptf.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.ptf.addressbook.model.ContactData;

public class ContactHelper extends HelperBase{


    public ContactHelper(WebDriver wd) {

        super(wd);
    }

    public void logout() {
        wd.findElement(By.linkText("Logout")).click();
    }

    public void submitContact() {
        wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    public void deleteContact() {
        wd.findElement(By.id("5")).click();
        wd.findElement(By.xpath("//input[@value='Delete']")).click();
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"),contactData.getFirstname());
        type(By.name("middlename"),contactData.getMiddlename());
        type(By.name("lastname"),contactData.getLastname());
        type(By.name("nickname"),contactData.getNickname());
        type(By.name("title"),contactData.getTitle());

        wd.findElement(By.name("theform")).click();
        type(By.name("company"),contactData.getCompany());
        type(By.name("address"),contactData.getAddress());
        type(By.name("home"),contactData.getHome());
        type(By.name("mobile"),contactData.getMobile());
        type(By.name("work"),contactData.getWork());
        type(By.name("fax"),contactData.getFax());
        type(By.name("email"),contactData.getEmeil());
        type(By.name("email2"),contactData.getEmeil2());
        type(By.name("email3"),contactData.getEmeil3());
        type(By.name("homepage"),contactData.getHomepage());

        wd.findElement(By.name("bday")).click();
        new Select(wd.findElement(By.name("bday"))).selectByVisibleText(contactData.getBday());
        wd.findElement(By.xpath("//option[@value='5']")).click();

        wd.findElement(By.name("bmonth")).click();
        new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(contactData.getBmonth());
        wd.findElement(By.xpath("//option[@value='January']")).click();

        type(By.name("byear"),contactData.getByear());

        wd.findElement(By.name("aday")).click();
        new Select(wd.findElement(By.name("aday"))).selectByVisibleText(contactData.getAday());
        wd.findElement(By.xpath("//div[@id='content']/form/select[3]/option[7]")).click();

        wd.findElement(By.name("amonth")).click();
        new Select(wd.findElement(By.name("amonth"))).selectByVisibleText("January");
        wd.findElement(By.xpath("//div[@id='content']/form/select[4]/option[2]")).click();

        type(By.name("ayear"),contactData.getAyear());

        wd.findElement(By.name("address2")).click();
        wd.findElement(By.xpath("//div[@id='content']/form/label[23]")).click();

        wd.findElement(By.name("address2")).click();
        wd.findElement(By.name("address2")).clear();
        wd.findElement(By.name("address2")).sendKeys(contactData.getAddress2());

        type(By.name("phone2"),contactData.getPhone2());
        type(By.name("notes"),contactData.getNotes());

    }


}
