package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

  @Test(enabled = false)
  public void testContactDeletion() throws Exception {
    if (! app.contact().isThereAContact()){
      app.goTo().gotoAddNewPage();
      app.contact().create(new ContactData("Irina", "V.", "Zesli", "Penza, Voroshilova, 1-84", "89613526485", "zesli@mail.ru", "5", "November", "1977","test1"),true);
      app.goTo().gotoHomePage();
    }
    List<ContactData> before = app.contact().getContactList();
    app.contact().selectContact(before.size()-1);
    app.contact().deleteSelectedContact();
    List<ContactData> after = app.contact().getContactList();
    Assert.assertEquals(after.size(),before.size()-1);
    before.remove(before.size()-1);
    Assert.assertEquals(before,after);
  }
}
