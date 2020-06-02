package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @Test(enabled = true)
  public void testContactCreation() throws Exception {
    Contacts before = app.contact().all();
    app.goTo().addNewPage();
    File photo = new File("src/test/resources/palm.jpg");
    ContactData contact = new ContactData().
            withFirstname("Maria").withMiddlename("V.").withLastname("Asina").withAddress("Penza, Voroshilova, 1-84").
            withMobilePhone("89613526485").withHomePhone("381302").withEmail("zesli@mail.ru").withBday("5").
            withBmonth("November").withByear("1977").withGroup("test1").withPhoto(photo);
    app.contact().create(contact,true);
    app.goTo().homePage();
    assertThat(app.contact().count(), equalTo(before.size()+1));
    Contacts after = app.contact().all();
    //assertThat(after.size(), equalTo(before.size()+1));
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c)->c.getId()).max().getAsInt()))));
  }

  @Test(enabled = false)
  public void testCurrentDir(){
    File currentDir = new File(".");
    System.out.println(currentDir.getAbsolutePath());
    File photo = new File("src/test/resources/palm.jpg");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());
  }


}
