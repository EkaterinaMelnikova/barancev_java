package ru.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupModificationTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        app.navigation().groups();
        if ( app.group().list().size()==0) {
            app.group().create(new GroupData("test6", "test6", "test6"));
        }}

    @Test
    public void testGroupModification () {
        List<GroupData> before =app.group().list();
        int index=before.size()-1;
        GroupData group =new GroupData(before.get(index).getId(),"test777", "6", "6");
        app.group().modify(index, group);
        List<GroupData> after =app.group().list();
        Assert.assertEquals(after.size(),before.size());


        before.remove(index);
        before.add(group);


        Comparator<? super GroupData> byId=(g1, g2) -> Integer.compare( g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        
        Assert.assertEquals(before, after);

    }
}
