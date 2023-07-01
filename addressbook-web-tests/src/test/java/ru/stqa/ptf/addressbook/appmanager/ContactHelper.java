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
        click(By.linkText("Logout"));
    }

    public void submitContact() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void deleteContact() {
        click(By.xpath("//img[@alt='Edit']"));
        click(By.xpath("//form[2]/input[2]"));
    }


    public void initContactModification () {

        click(By.xpath("//img[@alt='Edit']"));
    }

    public void submitContactModification() {
        click(By.name("update"));
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
        select(By.name("bday"), contactData.getBday());
        click(By.name("bmonth"));
        select(By.name("bmonth"), contactData.getBmonth());
        type(By.name("byear"),contactData.getByear());
        click(By.name("aday"));
        select(By.name("aday"), contactData.getAday());
        click(By.name("amonth"));
        select(By.name("amonth"), contactData.getAmonth());
        type(By.name("ayear"),contactData.getAyear());
        type(By.name("address2"),contactData.getAddress2());
        type(By.name("phone2"),contactData.getPhone2());
        type(By.name("notes"),contactData.getNotes());
    }


    public void createContact(ContactData contact) {

        fillContactForm(contact);
        submitContact();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.xpath("//img[@alt='Edit']"));
    }
}
