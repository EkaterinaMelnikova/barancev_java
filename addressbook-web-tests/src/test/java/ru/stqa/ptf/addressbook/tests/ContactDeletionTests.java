package ru.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;

import java.util.Set;


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
        Set<ContactData> before =app.contact().all();
        ContactData deletedContact =before.iterator().next();
        app.navigation().home();
        app.contact().delete(deletedContact);
        app.navigation().clickOkOnAlert();

        Set<ContactData> after =app.contact().all();

        before.remove(deletedContact);
        Assert.assertEquals(before,after);
    }


}
