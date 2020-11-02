package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.Iterator;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertTrue;

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
        Iterator<ContactData> itr= before.iterator();

        boolean canDelFromGroup = false;
        while ((itr.hasNext())&&(!canDelFromGroup)){
            ContactData contact = itr.next();
            if (!contact.getGroups().isEmpty()){
                deletedFromGroupContact = contact;
                canDelFromGroup = true;
            }
        }
        if (!canDelFromGroup) {
            GroupData group = app.db().groups().iterator().next();
            app.contact().addToGroup(deletedFromGroupContact,group);
            app.goTo().homePage();
            deletedFromGroupContact.inGroup(group);
        }

        GroupData deletedGroup=deletedFromGroupContact.getGroups().iterator().next();
        app.contact().delFromGroup(deletedFromGroupContact,deletedGroup);
        app.goTo().homePage();
        Contacts after = app.db().contacts();
        /*assertThat(after, equalTo(
                before.without(deletedFromGroupContact).withAdded(deletedFromGroupContact.removeGroup(deletedGroup))));*/
        assertTrue(after.contains(deletedFromGroupContact.removeGroup(deletedGroup)));
    }

}
