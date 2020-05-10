package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase{

  @Test
  public void testContactModification() throws Exception {
    if (! app.getContactHelper().isThereAContact()){
      app.getNavigationHelper().gotoAddNewPage();
      app.getContactHelper().createContact(new ContactData("Irina", "V.", "Zesli", "Penza, Voroshilova, 1-84", "89613526485", "zesli@mail.ru", "5", "November", "1977","test1"),true);
      app.getNavigationHelper().gotoHomePage();
    }
    app.getContactHelper().clickEdit();
    app.getContactHelper().fillNewContact(new ContactData("Irina", "V.", "Ivanova", "Penza, Voroshilova, 4-84", "89613526490", "iv@mail.ru", "6", "November", "1979",null),false);
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().gotoHomePage();
  }

}
