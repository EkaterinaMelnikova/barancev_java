package ru.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.GroupData;
import java.util.Set;

public class GroupCreationTests extends TestBase {


    @Test
    public void testCreateGroup() throws Exception {

        app.navigation().groups();
        Set<GroupData> before =app.group().all();
        GroupData group =new GroupData().withName("test123");
        app.group().create(group);
        app.navigation().groups();
        Set<GroupData> after =app.group().all();

        group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
        before.add(group);
        Assert.assertEquals(before,after);
    }

}
