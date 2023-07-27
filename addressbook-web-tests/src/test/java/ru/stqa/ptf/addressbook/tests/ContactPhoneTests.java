package ru.stqa.ptf.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase{

    @Test
    public void testContactPhones () {
        app.navigation().home();
        ContactData contact =app.contact().all().iterator().next();
        ContactData infoFromEditForm=app.contact().infoFromEditForm(contact);

        assertThat(contact.getHomePhone(), equalTo(cleaned(infoFromEditForm.getHomePhone())));
        assertThat(contact.getMobile(), equalTo(cleaned(infoFromEditForm.getMobile())));
        assertThat(contact.getWorkPhone(), equalTo(cleaned(infoFromEditForm.getWorkPhone())));
    }

    public String cleaned(String phone)  {
        return phone.replaceAll("\\s","").replaceAll("[-()]","");
    }
}
