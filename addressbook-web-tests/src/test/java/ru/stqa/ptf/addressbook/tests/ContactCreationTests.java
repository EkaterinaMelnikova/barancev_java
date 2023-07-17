package ru.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test (enabled = true)
    public void testCreateContact() throws Exception {
        app.navigation().home();
        List<ContactData> before =app.contact().list();
        app.navigation().addNew();
        ContactData contact= new ContactData().withFirstname("rere");
        app.contact().create(contact);
        app.navigation().home();
        List<ContactData> after =app.contact().list();

        before.add(contact);

        Comparator<? super ContactData> byId=(с1, с2) -> Integer.compare(с1.getId(), с2.getId());
        before.sort(byId);
        after.sort(byId);

        Assert.assertEquals(before, after);

    }

}

