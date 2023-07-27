package ru.stqa.ptf.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;
import ru.stqa.ptf.addressbook.model.Contacts;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

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
        Contacts before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstname("Сидор")
                .withMiddlename("Петроввич").withLastname("Иванов")
                .withMobile("21212121").withEmail("sasa@vcc.jhj");

        app.contact().modify(contact);
        app.navigation().home();
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    }

}
