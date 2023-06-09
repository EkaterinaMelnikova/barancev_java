package ru.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.GroupData;
import java.util.Comparator;
import java.util.List;

public class GroupCreationTests extends TestBase {


    @Test
    public void testCreateGroup() throws Exception {

        app.navigation().groups();
        List<GroupData> before =app.group().list();
        GroupData group =new GroupData("New", "6", "6");
        app.group().create(group);
        app.navigation().groups();
        List<GroupData> after =app.group().list();


        before.add(group);
        Comparator<? super GroupData> byId=(g1, g2) -> Integer.compare( g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);

        Assert.assertEquals(before,after);

    }

}
