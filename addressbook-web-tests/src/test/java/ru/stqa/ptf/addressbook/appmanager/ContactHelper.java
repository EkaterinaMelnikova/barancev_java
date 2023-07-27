package ru.stqa.ptf.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.ptf.addressbook.model.ContactData;
import ru.stqa.ptf.addressbook.model.Contacts;

import java.util.ArrayList;
import java.util.List;

import static ru.stqa.ptf.addressbook.tests.TestBase.app;

public class ContactHelper extends HelperBase {


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
        //click(By.xpath("//form[2]/input[2]"));
        click(By.cssSelector("input[value='Delete']"));
    }

    public void selectContact(int index) {
        wd.findElements(By.xpath("//img[@alt='Edit']")).get(index).click();
    }

    public void selectContactById(int id) {
        wd.findElement(By.cssSelector("input[id='" + id + "']")).click();
    }

    public void selectModifyById(int id) {
        click(By.xpath(String.format("//input[@id='%s']/../../td[8]/a", id)));
    }

    public void submitContactModification() {
        click(By.name("update"));
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("middlename"), contactData.getMiddlename());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("mobile"), contactData.getMobile());
        type(By.name("email"), contactData.getEmail());
    }


    public void create(ContactData contact) {
        fillContactForm(contact);
        submitContact();
        contactCache = null;
    }


    public void modify(ContactData contact) {
        selectModifyById(contact.getId());
        fillContactForm(contact);
        submitContactModification();
        contactCache = null;
    }

    public void delete(ContactData contact) {
        selectContactById(contact.getId());
        deleteContact();
        contactCache = null;
    }

    public void delete(int index) {
        selectContact(index);
        deleteContact();
    }


    public boolean isThereAContact() {
        return isElementPresent(By.xpath("//img[@alt='Edit']"));
    }

    public List<ContactData> list() {
        List<ContactData> contacts = new ArrayList<ContactData>(); //создаем список который будем извлекать
        List<WebElement> elements = wd.findElements(By.name("entry"));//извлекаем данные со страницы приложения
        for (WebElement element : elements) { //цикл по получ элементов

            String firstname = element.findElements(By.tagName("td")).get(2).getText();
            String lastname = element.findElements(By.tagName("td")).get(1).getText();
            int id = Integer.parseInt(element.findElements(By.tagName("td")).get(0).findElement(By.tagName("input")).getAttribute("value"));
            contacts.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname));
        }
        return contacts; //возвращаем список
    }


    private Contacts contactCache = null;

    public Contacts all() {
        {
            if (contactCache != null) {
                return new Contacts(contactCache);
            }

            contactCache = new Contacts();
            List<WebElement> elements = wd.findElements(By.name("entry"));//извлекаем данные со страницы приложения
            for (WebElement element : elements) { //цикл по получ элементов
                String firstname = element.findElements(By.tagName("td")).get(2).getText();
                String lastname = element.findElements(By.tagName("td")).get(1).getText();
                String address= element.findElements(By.tagName("td")).get(3).getText();
                String allEmails= element.findElements(By.tagName("td")).get(4).getText();
                String allPhones= element.findElements(By.tagName("td")).get(5).getText();

                int id = Integer.parseInt(element
                        .findElements(By.tagName("td")).get(0).findElement(By.tagName("input"))
                        .getAttribute("value"));
                contactCache.add(new ContactData().withId(id).withFirstname(firstname)
                        .withLastname(lastname).withAddress(address).withAllEmails(allEmails).withAllPhones(allPhones));
            }
            return contactCache;
        }
    }

    public int count() {
        {
            return wd.findElements(By.name("selected[]")).size();
        }
    }

    public ContactData infoFromEditForm(ContactData contact) {
        selectModifyById(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String workPhone = wd.findElement(By.name("work")).getAttribute("value");
        String email = wd.findElement(By.name("email")).getAttribute("value");
        String email2 = wd.findElement(By.name("email2")).getAttribute("value");
        String email3 = wd.findElement(By.name("email3")).getAttribute("value");
        app.navigation().home();
        return new ContactData().withId(contact
                .getId()).withFirstname(firstname).withLastname(lastname).withAddress(address)
                .withHomePhone(home).withMobile(mobile).withWorkPhone(workPhone).withEmail(email)
                .withEmail2(email2).withEmail3(email3);
    }

}



