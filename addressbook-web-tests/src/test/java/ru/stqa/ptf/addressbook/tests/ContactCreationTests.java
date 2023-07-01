package ru.stqa.ptf.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test
    public void testCreateContact() throws Exception {
        app.getNavigationHelper().gotoContactAddPage();
        app.getContactHelper().fillContactForm(new ContactData("Vasya", "Vlad", "Melnik",
                "KatyKaty", "1", "zzz", "zzz", "12345",
                "54321", "1111", "22222", "katkimo@", "katkimo2@",
                "katkimo3@", "123", "5", "January", "1900",
                "5", "January","1950", "Address", "123", "123"));
        app.getContactHelper().submitContact();
        app.getContactHelper().logout();

    }

}

