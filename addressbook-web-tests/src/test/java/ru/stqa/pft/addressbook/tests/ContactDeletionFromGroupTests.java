package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionFromGroupTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().groups().size()==0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test10"));
            app.goTo().homePage();
        }
        if (app.db().contacts().size() == 0){
            app.goTo().addNewPage();
            app.contact().create(new ContactData().withFirstname("Irina").withLastname("Zesli").
                    withBday("5").withBmonth("November").withByear("1977").withHomePhone("381302"),true);
            app.goTo().homePage();
        }
    }

    @Test
    public void testContactDeletionFromGroup() throws Exception{
        Contacts before = app.db().contacts();
        ContactData deletedFromGroupContact = before.iterator().next();
        if (deletedFromGroupContact.getGroups().isEmpty()){
            GroupData group = app.db().groups().iterator().next();
            app.contact().addToGroup(deletedFromGroupContact,group);
            app.goTo().homePage();
            deletedFromGroupContact.inGroup(group);
            before = app.db().contacts();
        }
        GroupData deletedGroup=deletedFromGroupContact.getGroups().iterator().next();
        app.contact().delFromGroup(deletedFromGroupContact,deletedGroup);
        app.goTo().homePage();
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(
                before.without(deletedFromGroupContact).withAdded(deletedFromGroupContact.removeGroup(deletedGroup))));
    }

}
