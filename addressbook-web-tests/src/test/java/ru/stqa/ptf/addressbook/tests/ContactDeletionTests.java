package ru.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;

import java.util.List;


public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.navigation().home();
        if (app.contact().list().size()==0) {
            app.navigation().addNew();
            app.contact().create(new ContactData("Katy", "Vlad", "Melnik",
                   "22222", "katkimo@"));
        }}


    @Test (enabled = true)
    public void testDeleteContact2() throws Exception {
        app.navigation().home();
        List<ContactData> before =app.contact().list();
        int index=before.size()-1;
        app.navigation().home();
        app.contact().delete(index);
        app.navigation().home();
        List<ContactData> after =app.contact().list();

        before.remove(index);
        Assert.assertEquals(before,after);
    }


}
