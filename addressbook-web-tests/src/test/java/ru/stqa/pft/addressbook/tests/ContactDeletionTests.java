package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.contact().all().size() == 0){
      app.goTo().addNewPage();
      app.contact().create(new ContactData().withFirstname("Irina").withLastname("Zesli").withBday("5").withByear("November").withByear("1977"),true);
      app.goTo().homePage();
    }
  }

  @Test(enabled = true)
  public void testContactDeletion() throws Exception {
    Contacts before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size()-1));
    assertThat(after, equalTo(before.without(deletedContact)));
  }

}
