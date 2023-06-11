package ru.stqa.ptf.addressbook;

import org.testng.annotations.Test;

public class DeleteGroupTestBase extends TestBase {


  @Test
  public void testDeleteGroup() throws Exception {

    gotoGroupPage(); // уже имеющийся метод
    selectGroup();
    deleteSelectedGroups();
    returnToGroupPage(); //уже имеющийся метод
  }


}
