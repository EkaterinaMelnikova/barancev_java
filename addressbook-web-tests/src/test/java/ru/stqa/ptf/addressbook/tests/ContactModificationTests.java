package ru.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.navigation().gotoMainPage();
        if (!app.getContactHelper().isThereAContact()) {
            app.navigation().gotoContactAddPage();
            app.getContactHelper().createContact(new ContactData("Katy", "Vlad", "Melnik",
                    "KatyKaty", "1", "zzz", "zzz", "12345",
                    "54321", "1111", "22222", "katkimo@", "katkimo2@",
                    "katkimo3@", "123", "5", "January", "1900",
                    "5", "January", "1950", "Address", "123", "123"));
        }
        app.navigation().gotoMainPage();}

    @Test (enabled = true)
    public void testContactModification() throws Exception {
        List<ContactData> before =app.getContactHelper().getContactList();
        int index=before.size()-1;
        ContactData contact= new ContactData (before.get(index).getId(),"Mody123", "Vlad", "Mody",
                "KatyKaty", "1", "zzz", "zzz", "12345",
                "54321", "1111", "22222", "katkimo@", "katkimo2@",
                "katkimo3@", "123", "5", "January", "1900",
                "5", "January","1950", "Address", "123", "123");
        app.getContactHelper().modifyContact(index, contact);
        app.navigation().gotoMainPage();
        List<ContactData> after =app.getContactHelper().getContactList();


        before.remove(index);
        before.add(contact);  //добавляем в старый список ту группу которую мы создали в тесте без учета порядка

        Comparator<? super ContactData> byId=(с1, с2) -> Integer.compare(с1.getId(), с2.getId());
        before.sort(byId);
        after.sort(byId);

        Assert.assertEquals(before, after);
    }

}
