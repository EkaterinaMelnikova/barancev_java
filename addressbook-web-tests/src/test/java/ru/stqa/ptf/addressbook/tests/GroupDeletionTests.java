package ru.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.GroupData;

public class GroupDeletionTests extends TestBase {


    @Test
    public void testDeleteGroup() throws Exception {

        app.getNavigationHelper().gotoGroupPage();
        int befor= app.getGroupHelper().getGroupCount();
        if (! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("test6", "test6", "test6"));
        }
        app.getGroupHelper().selectGroup(befor-1);
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnToGroupPage();
        int after= app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after,befor-1);
    }


}
