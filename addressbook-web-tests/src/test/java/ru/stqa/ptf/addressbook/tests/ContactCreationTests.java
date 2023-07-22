package ru.stqa.ptf.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.junit.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.junit.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @Test (enabled = true)
    public void testCreateContact() throws Exception {
        app.navigation().home();
        Set<ContactData> before =app.contact().all();
        app.navigation().addNew();
        ContactData contact= new ContactData().withFirstname("Иван").withLastname("Петров");
        app.contact().create(contact);
        app.navigation().home();
        Set<ContactData> after =app.contact().all();

        contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());

        before.add(contact);

        assertThat(after, equalTo(before));

    }

}

