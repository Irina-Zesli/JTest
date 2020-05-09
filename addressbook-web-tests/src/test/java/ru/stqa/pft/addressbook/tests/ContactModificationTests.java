package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase{

  @Test
  public void testContactModification() throws Exception {
    app.getContactHelper().clickEdit();
    app.getContactHelper().fillNewContact(new ContactData("Irina", "V.", "Ivanova", "Penza, Voroshilova, 4-84", "89613526490", "iv@mail.ru", "6", "November", "1979",null),false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
  }

}
