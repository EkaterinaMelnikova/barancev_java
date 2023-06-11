package ru.stqa.ptf.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.GroupData;

public class CreateGroupTestBase extends TestBase {


  @Test
  public void testCreateGroup4() throws Exception {

    app.gotoGroupPage();
    app.initGroupCreation();
    app.fillGroupForm(new GroupData("test6", "6", "6"));
    app.submitGroupCreation();
    app.returnToGroupPage();
  }


}
