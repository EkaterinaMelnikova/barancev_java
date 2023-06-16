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

    public void deleteContact(String idelement) {
        wd.findElement(By.id(idelement)).click();
        wd.findElement(By.xpath("//input[@value='Delete']")).click();
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"),contactData.getFirstname());
        type(By.name("middlename"),contactData.getMiddlename());
        type(By.name("lastname"),contactData.getLastname());
        type(By.name("nickname"),contactData.getNickname());
        type(By.name("title"),contactData.getTitle());
        type(By.name("company"),contactData.getCompany());
        type(By.name("address"),contactData.getAddress());
        type(By.name("home"),contactData.getHome());
        type(By.name("mobile"),contactData.getMobile());
        type(By.name("work"),contactData.getWorkphone());
        type(By.name("fax"),contactData.getFax());
        type(By.name("email"),contactData.getEmeil());
        type(By.name("email2"),contactData.getEmeil2());
        type(By.name("email3"),contactData.getEmeil3());
        type(By.name("homepage"),contactData.getHomepage());


        click(By.name("bday"));

        new Select(wd.findElement(By.name("bday"))).selectByVisibleText(contactData.getBday());

        click(By.name("bmonth"));
        new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(contactData.getBmonth());

        type(By.name("byear"),contactData.getByear());

        click(By.name("aday"));

        new Select(wd.findElement(By.name("aday"))).selectByVisibleText(contactData.getAday());

        click(By.name("amonth"));

        new Select(wd.findElement(By.name("amonth"))).selectByVisibleText(contactData.getAmonth());


        type(By.name("ayear"),contactData.getAyear());
        type(By.name("address2"),contactData.getAddress2());
        type(By.name("phone2"),contactData.getPhone2());
        type(By.name("notes"),contactData.getNotes());

    }


}
