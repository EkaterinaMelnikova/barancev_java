package ru.stqa.ptf.addressbook.tests;

import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;
import ru.stqa.ptf.addressbook.model.Contacts;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.junit.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @Test (enabled = true)
    public void testCreateContact() throws Exception {
        app.navigation().home();
        Contacts before =app.contact().all();
        app.navigation().addNew();
        ContactData contact= new ContactData().withFirstname("Иван").withLastname("Петров");
        app.contact().create(contact);
        app.navigation().home();
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after =app.contact().all();

        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

    }

}

