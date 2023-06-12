package ru.stqa.ptf.addressbook.tests;

import org.testng.annotations.Test;


public class DeleteContactTestBase extends TestBase {


    @Test
    public void testDeleteContact2() throws Exception {
        app.getNavigationHelper().gotoMainPage();
        app.getContactHelper().deleteContact();
    }


}
