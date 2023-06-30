package ru.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.GroupData;

import java.util.Comparator;
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


        Comparator<? super GroupData> byId=(g1, g2) -> Integer.compare( g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        
        Assert.assertEquals(before, after);

    }
}
