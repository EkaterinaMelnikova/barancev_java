package ru.stqa.ptf.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.ptf.addressbook.model.ContactData;
import ru.stqa.ptf.addressbook.model.Contacts;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        type(By.name("email"), contactData.getEmeil());
    }


    public void create(ContactData contact) {
        fillContactForm(contact);
        submitContact();
    }


    public void modify(ContactData contact) {
        selectModifyById(contact.getId());
        fillContactForm(contact);
        submitContactModification();
    }

    public void delete(ContactData contact) {
        selectContactById(contact.getId());
        deleteContact();
    }

    public  void delete(int index) {
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
            int id = Integer.parseInt(element.findElements(By.tagName("td")).get(0)
                    .findElement(By.tagName("input")).getAttribute("value"));
            contacts.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname));
        }
        return contacts; //возвращаем список
    }

    public Contacts all() {
        Contacts contacts = new Contacts(); //создаем set который будем извлекать
        List<WebElement> elements = wd.findElements(By.name("entry"));//извлекаем данные со страницы приложения
        for (WebElement element : elements) { //цикл по получ элементов
            String firstname = element.findElements(By.tagName("td")).get(2).getText();
            String lastname = element.findElements(By.tagName("td")).get(1).getText();
            int id = Integer.parseInt(element.findElements(By.tagName("td")).get(0)
                    .findElement(By.tagName("input")).getAttribute("value"));
            contacts.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname));
        }
        return contacts; //возвращаем список
    }
}




