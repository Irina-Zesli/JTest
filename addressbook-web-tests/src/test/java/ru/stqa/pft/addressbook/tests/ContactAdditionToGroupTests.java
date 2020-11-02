package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.Iterator;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertTrue;

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
    Contacts before = app.db().contacts();
    Iterator<ContactData> itr= before.iterator();
    ContactData addedToGroupContact = before.iterator().next();
    GroupData addedGroup = null;
    boolean canAddToGroup = false;
    while ((itr.hasNext())&&(!canAddToGroup)){
      Groups groups = app.db().groups();
      ContactData contact = itr.next();
      groups.removeAll(contact.getGroups());
      if (!groups.isEmpty()){
        addedToGroupContact = contact;
        addedGroup = groups.iterator().next();
        canAddToGroup = true;
      }
    }
    if (!canAddToGroup) {
      app.goTo().groupPage();
      addedGroup = new GroupData().withName("test8").withHeader("test8_header").withFooter("test8_footer");
      app.group().create(addedGroup);
      addedGroup.withId(app.db().groups().stream().mapToInt((g)->g.getId()).max().getAsInt());
      app.goTo().homePage();
    }

    app.contact().addToGroup(addedToGroupContact,addedGroup);
    app.goTo().homePage();
    Contacts after = app.db().contacts();
    /*assertThat(after, equalTo(
            before.without(addedToGroupContact).withAdded(addedToGroupContact.inGroup(addedGroup))));*/
    assertTrue(after.contains(addedToGroupContact.inGroup(addedGroup)));

  }

}
