package ru.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

import static sun.security.pkcs11.wrapper.Functions.getId;

public class GroupModificationTests extends TestBase{

    @Test
    public void testGroupModification () {

        app.getNavigationHelper().gotoGroupPage();
        if (! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("test6", "test6", "test6"));
        }
        List<GroupData> before =app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroup(before.size()-1);
        app.getGroupHelper().initGroupModification();
        GroupData group =new GroupData(before.get(before.size()-1).getId(),"test6", "6", "6");
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();
        List<GroupData> after =app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(),before.size());


        before.remove(before.size()-1);
        before.add(group);
        Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));

    }
}
