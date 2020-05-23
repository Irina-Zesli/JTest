package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase{

  @Test(enabled = false)
  public void testContactModification() throws Exception {
    if (! app.contact().isThereAContact()){
      app.goTo().gotoAddNewPage();
      app.contact().create(new ContactData("Irina", "V.", "Zesli", "Penza, Voroshilova, 1-84", "89613526485", "zesli@mail.ru", "5", "November", "1977","test1"),true);
      app.goTo().gotoHomePage();
    }
    List<ContactData> before = app.contact().getContactList();
    app.contact().clickEdit(before.size()-1);
    ContactData contact = new ContactData(before.get(before.size()-1).getId(),"Marina", "V.", "Ivanova", "Penza, Voroshilova, 4-84", "89613526490", "iv@mail.ru", "6", "November", "1979",null);
    app.contact().fillNewContact(contact,false);
    app.contact().submitContactModification();
    app.goTo().gotoHomePage();
    List<ContactData> after = app.contact().getContactList();
    Assert.assertEquals(after.size(),before.size());
    before.remove(before.size()-1);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) ->Integer.compare(c1.getId(),c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before,after);
  }

}
