package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() throws Exception {
    if (! app.getContactHelper().isThereAContact()){
      app.getNavigationHelper().gotoAddNewPage();
      app.getContactHelper().createContact(new ContactData("Irina", "V.", "Zesli", "Penza, Voroshilova, 1-84", "89613526485", "zesli@mail.ru", "5", "November", "1977","test1"),true);
      app.getNavigationHelper().gotoHomePage();
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContact();
  }
}
