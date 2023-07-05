package ru.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;

import java.util.List;


public class ContactDeletionTests extends TestBase {


    @Test
    public void testDeleteContact2() throws Exception {
        app.getNavigationHelper().gotoMainPage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getNavigationHelper().gotoContactAddPage();
            app.getContactHelper().createContact(new ContactData("Katy", "Vlad", "Melnik",
                    "KatyKaty", "1", "zzz", "zzz", "12345",
                    "54321", "1111", "22222", "katkimo@", "katkimo2@",
                    "katkimo3@", "123", "5", "January", "1900",
                    "5", "January", "1950", "Address", "123", "123"));
        }
        List<ContactData> before =app.getContactHelper().getContactList();
        app.getNavigationHelper().gotoMainPage();
        app.getContactHelper().selectContact(before.size()-1);
        app.getContactHelper().deleteContact();
        app.getNavigationHelper().gotoMainPage();
        List<ContactData> after =app.getContactHelper().getContactList();

        before.remove(before.size()-1);
        Assert.assertEquals(before,after);
    }


}
