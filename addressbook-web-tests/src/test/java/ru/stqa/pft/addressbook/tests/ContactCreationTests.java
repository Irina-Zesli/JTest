package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test(enabled = false)
  public void testContactCreation() throws Exception {
    List<ContactData> before = app.contact().getContactList();
    app.goTo().gotoAddNewPage();
    ContactData contact = new ContactData("Maria", "V.", "Asina", "Penza, Voroshilova, 1-84", "89613526485", "zesli@mail.ru", "5", "November", "1977","test1");
    app.contact().create(contact,true);
    app.goTo().gotoHomePage();
    List<ContactData> after = app.contact().getContactList();
    Assert.assertEquals(after.size(),before.size()+1);

    int max = after.stream().max((o1, o2) -> Integer.compare(o1.getId(),o2.getId())).get().getId();
    contact.setId(max);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) ->Integer.compare(c1.getId(),c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before,after);
  }

}
