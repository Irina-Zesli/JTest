package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

public class ContactAdditionToGroupTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().groups().size()==0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test10"));
    }
  }

  @Test
  public void testContactAdditionToGroup() throws Exception{
    Groups groups = app.db().groups();
    Contacts before = app.db().contacts();

    ContactData addedContact = before.iterator().next();
    Groups groups1 = groups;
    GroupData addedGroup;
    groups1.removeAll(addedContact.getGroups());
    if (groups1.isEmpty()) {

    }
    else
    {
      addedGroup = groups1.iterator().next();
      System.out.println(addedGroup);
    }

  }

}
