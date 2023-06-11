package ru.stqa.ptf.addressbook;

import org.testng.annotations.Test;

public class CreateGroupTestBase extends TestBase{


  @Test
  public void testCreateGroup4() throws Exception {

    app.gotoGroupPage();
    app.initGroupCreation();
    app.fillGroupForm(new GroupData("test6", "6", "6"));
    app.submitGroupCreation();
    app.returnToGroupPage();
  }


}
