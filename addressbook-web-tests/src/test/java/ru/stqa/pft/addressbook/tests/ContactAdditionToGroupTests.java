package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAdditionToGroupTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().groups().size()==0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test10"));
      app.goTo().homePage();
    }
    if (app.db().contacts().size() == 0){
      app.goTo().addNewPage();
      app.contact().create(new ContactData().withFirstname("Irina").withLastname("Zesli").
              withBday("5").withBmonth("November").withByear("1977").withHomePhone("381302"),true);
      app.goTo().homePage();
    }
  }

  @Test
  public void testContactAdditionToGroup() throws Exception{
    Groups groups = app.db().groups();
    Contacts before = app.db().contacts();
    ContactData addedToGroupContact = before.iterator().next();
    GroupData addedGroup;
    groups.removeAll(addedToGroupContact.getGroups());
    if (groups.isEmpty()) {
      app.goTo().groupPage();
      addedGroup = new GroupData().withName("test16").withHeader("test16_header").withFooter("test16_footer");
      app.group().create(addedGroup);
      addedGroup.withId(app.db().groups().stream().mapToInt((g)->g.getId()).max().getAsInt());
      app.goTo().homePage();
    }
    else
    {
      addedGroup = groups.iterator().next();
    }
    app.contact().addToGroup(addedToGroupContact,addedGroup);
    app.goTo().homePage();
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(
            before.without(addedToGroupContact).withAdded(addedToGroupContact.inGroup(addedGroup))));

  }

}
