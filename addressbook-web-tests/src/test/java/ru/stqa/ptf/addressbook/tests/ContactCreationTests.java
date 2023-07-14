package ru.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test (enabled = true)
    public void testCreateContact() throws Exception {
        app.getNavigationHelper().gotoMainPage();
        List<ContactData> before =app.getContactHelper().getContactList();
        app.getNavigationHelper().gotoContactAddPage();
        ContactData contact= new ContactData ("Mody1237", "Vlad", "Mody",
                "KatyKaty", "1", "zzz", "zzz", "12345",
                "54321", "1111", "22222", "katkimo@", "katkimo2@",
                "katkimo3@", "123", "5", "January", "1900",
                "5", "January","1950", "Address", "123", "123");
        app.getContactHelper().createContact(contact);
        app.getNavigationHelper().gotoMainPage();
        List<ContactData> after =app.getContactHelper().getContactList();

        before.add(contact);

        Comparator<? super ContactData> byId=(с1, с2) -> Integer.compare(с1.getId(), с2.getId());
        before.sort(byId);
        after.sort(byId);

        Assert.assertEquals(before, after);

    }

}

