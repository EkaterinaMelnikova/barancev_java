package ru.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;

import java.util.Set;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.navigation().home();
        if (app.contact().list().size() == 0) {
            app.navigation().addNew();
            app.contact().create(new ContactData().withFirstname("Петр").withLastname("Карадашев"));
        }
        app.navigation().home();
    }

    @Test(enabled = true)
    public void testContactModification() throws Exception {
        Set<ContactData> before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstname("Сидор")
                .withMiddlename("Петроввич").withLastname("Иванов")
                .withMobile("21212121").withEmeil("sasa@vcc.jhj");

        app.contact().modify(contact);
        app.navigation().home();
        Set<ContactData> after = app.contact().all();

        before.remove(modifiedContact);
        before.add(contact);  //добавляем в старый список ту группу которую мы создали в тесте без учета порядка

        Assert.assertEquals(before, after);
    }

}
