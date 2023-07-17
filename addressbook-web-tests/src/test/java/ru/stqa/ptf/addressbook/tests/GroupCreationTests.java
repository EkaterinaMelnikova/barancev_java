package ru.stqa.ptf.addressbook.tests;


import org.testng.annotations.Test;
import ru.stqa.ptf.addressbook.model.GroupData;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {


    @Test
    public void testCreateGroup() throws Exception {

        app.navigation().groups();
        Groups before =app.group().all();
        GroupData group =new GroupData().withName("test123");
        app.group().create(group);
        app.navigation().groups();
        Groups after =app.group().all();

        assertThat(after, equalTo(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt())));
    }

}
