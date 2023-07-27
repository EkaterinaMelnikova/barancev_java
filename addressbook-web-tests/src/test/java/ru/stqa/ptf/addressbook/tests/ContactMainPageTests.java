package ru.stqa.ptf.addressbook.tests;


import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactMainPageTests extends TestBase{

    @Test
    public void testContactPhones () {
        app.navigation().home();
        ContactData contact =app.contact().all().iterator().next();
        ContactData infoFromEditForm=app.contact().infoFromEditForm(contact);

        assertThat(contact.getAllPhones(), equalTo(mergePhones(infoFromEditForm)));
        assertThat(contact.getAddress(), equalTo((infoFromEditForm.getAddress())));
        assertThat(contact.getAllEmails(), equalTo(mergeEmails(infoFromEditForm)));
    }

    private String mergePhones(ContactData contact) {
        return Arrays.asList(contact.getHomePhone(), contact.getMobile(), contact.getWorkPhone())
                .stream().filter((s) -> ! s.equals(""))
                .map(ContactMainPageTests::cleaned)
                .collect(Collectors.joining("\n"));
    }

    private String mergeEmails(ContactData contact) {
        return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
                .stream().filter((s) -> ! s.equals(""))
                .collect(Collectors.joining("\n"));
    }

    public static String cleaned(String phone)  {
        return phone.replaceAll("\\s","").replaceAll("[-()]","");
    }
}
