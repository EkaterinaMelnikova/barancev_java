package ru.stqa.ptf.addressbook.tests;

import org.testng.annotations.Test;

public class DeleteGroupTestBase extends TestBase {


  @Test
  public void testDeleteGroup() throws Exception {

    app.gotoGroupPage(); // уже имеющийся метод
    app.selectGroup();
    app.deleteSelectedGroups();
    app.returnToGroupPage(); //уже имеющийся метод
  }


}
