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


public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.navigation().home();
        if (app.contact().list().size()==0) {
            app.navigation().addNew();
            app.contact().create(new ContactData().withFirstname("Игнат").withLastname("Пузиков"));
        }}


    @Test (enabled = true)
    public void testDeleteContact2() throws Exception {
        app.navigation().home();
        Contacts before =app.contact().all();
        ContactData deletedContact =before.iterator().next();
        app.navigation().home();
        app.contact().delete(deletedContact);
        app.navigation().clickOkOnAlert();

        Contacts after =app.contact().all();

        assertThat(after, equalTo(before.without(deletedContact)));
    }


}
