package ru.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase {


    @Test
    public void testCreateGroup() throws Exception {

        app.getNavigationHelper().gotoGroupPage();
        List<GroupData> before =app.getGroupHelper().getGroupList();
        GroupData group =new GroupData("New", "6", "6");
        app.getGroupHelper().createGroup(group);
        List<GroupData> after =app.getGroupHelper().getGroupList();


        before.add(group);
        Comparator<? super GroupData> byId=(g1, g2) -> Integer.compare( g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);

        Assert.assertEquals(before,after);

    }

}