package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ContactAddressTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.contact().all().size() == 0){
      app.goTo().addNewPage();
      app.contact().create(new ContactData().withFirstname("Irina").withLastname("Zesli").
              withBday("5").withBmonth("November").withByear("1977").withHomePhone("381302").
              withMobilePhone("89613526485").withAddress("г. Пенза, ул. Ворошилова 1-84"),true);
      app.goTo().homePage();
    }
  }

  @Test
  public void testContactAddress(){
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat(cleaned(contact.getAddress()),equalTo(cleaned(contactInfoFromEditForm.getAddress())));
  }

  public static String cleaned(String address){
    return address.replaceAll("\\s+"," ");
  }

}
