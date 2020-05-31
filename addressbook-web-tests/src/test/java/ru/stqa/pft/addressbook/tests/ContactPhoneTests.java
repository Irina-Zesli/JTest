package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ContactPhoneTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.contact().all().size() == 0){
      app.goTo().addNewPage();
      app.contact().create(new ContactData().withFirstname("Irina").withLastname("Zesli").
              withBday("5").withBmonth("November").withByear("1977").withHomePhone("381302").
              withMobilePhone("89613526485").withWorkPhone("666779").withGroup("test1"),true);
      app.goTo().homePage();
    }
  }

  @Test
  public void testContactPhones(){
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat(contact.getHomePhone(),equalTo(cleaned(contactInfoFromEditForm.getHomePhone())));
    assertThat(contact.getMobilePhone(),equalTo(cleaned(contactInfoFromEditForm.getMobilePhone())));
    assertThat(contact.getWorkPhone(),equalTo(cleaned(contactInfoFromEditForm.getWorkPhone())));

  }

  public String cleaned(String phone){
    return phone.replaceAll("\\s","").replaceAll("[-()]","");
  }
}
