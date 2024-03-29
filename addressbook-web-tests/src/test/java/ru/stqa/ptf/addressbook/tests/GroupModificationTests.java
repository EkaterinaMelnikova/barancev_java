package ru.stqa.ptf.addressbook.tests;

import org.hamcrest.junit.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.GroupData;
import ru.stqa.ptf.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupModificationTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        app.navigation().groups();
        if ( app.group().all().size()==0) {
            app.group().create(new GroupData().withName("test678"));
        }}

    @Test
    public void testGroupModification () {
        Groups before =app.group().all();
        GroupData modifiedGroup =before.iterator().next();
        GroupData group =new GroupData()
                .withId(modifiedGroup.getId()).withName("test1").withHeader("test2").withFooter("test3");
        app.group().modify(group);
        MatcherAssert.assertThat(app.group().count(), equalTo(before.size()));
        Groups after =app.group().all();
        assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));

    }
}
