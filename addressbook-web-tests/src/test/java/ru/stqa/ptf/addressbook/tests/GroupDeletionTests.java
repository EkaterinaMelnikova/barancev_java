package ru.stqa.ptf.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.GroupData;
import ru.stqa.ptf.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.junit.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.navigation().groups();
        if ( app.group().all().size()==0)  {
            app.group().create(new GroupData().withName("test456"));
        }}


    @Test
    public void testDeleteGroup() throws Exception {
        Groups before =app.group().all();
        GroupData deletedGroup =before.iterator().next();
        app.group().delete(deletedGroup);
        Groups after =app.group().all();
        assertEquals(after.size(),before.size()-1);

        assertThat(after, equalTo(before.without(deletedGroup)));
    }
}
