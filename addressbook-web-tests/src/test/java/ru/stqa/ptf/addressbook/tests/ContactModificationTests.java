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
        app.navigation().home();
        if (app.contact().list().size() == 0) {
            app.navigation().addNew();
            app.contact().create(new ContactData().withFirstname("rere"));
        }
        app.navigation().home();
    }

    @Test(enabled = true)
    public void testContactModification() throws Exception {
        List<ContactData> before = app.contact().list();
        int index = before.size() - 1;
        ContactData contact = new ContactData().withId(before.get(index).getId()).withFirstname("qwqwq")
                .withMiddlename("sasas").withLastname("rerer")
                .withMobile("21212121").withEmeil("sasa@vcc.jhj");

        app.contact().modify(index, contact);
        app.navigation().home();
        List<ContactData> after = app.contact().list();


        before.remove(index);
        before.add(contact);  //добавляем в старый список ту группу которую мы создали в тесте без учета порядка

        Comparator<? super ContactData> byId = (с1, с2) -> Integer.compare(с1.getId(), с2.getId());
        before.sort(byId);
        after.sort(byId);

        Assert.assertEquals(before, after);
    }

}
