package ru.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

public class GroupDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.getNavigationHelper().gotoGroupPage();
        if (! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("test6", "test6", "test6"));
        }}


    @Test
    public void testDeleteGroup() throws Exception {
        List<GroupData> before =app.getGroupHelper().getGroupList();
        int index=before.size()-1;
        app.getGroupHelper().selectGroup(index);
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnToGroupPage();
        List<GroupData> after =app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(),before.size()-1);


        before.remove(index);
            Assert.assertEquals(before,after);
    }


}
