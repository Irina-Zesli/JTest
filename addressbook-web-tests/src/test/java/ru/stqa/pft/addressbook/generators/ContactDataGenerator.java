package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import ru.stqa.pft.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {
  @Parameter(names = "-c", description = "Contact count")
  public int count;

  @Parameter(names = "-f", description = "Target file")
  public String file;

  @Parameter(names = "-d", description = "Data format")
  public String format;

  public static void main(String[] args) throws IOException {
    ContactDataGenerator generator = new ContactDataGenerator();
    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse(args);
    } catch (ParameterException ex){
      jCommander.usage();
      return;
    }
    generator.run();
  }

  private void run() throws IOException {
    List<ContactData> contacts = generateContacts(count);
    if (format.equals("csv")) {
      saveAsCsv(contacts, new File(file));
    /*} else if (format.equals("xml")){
      saveAsXml(contacts, new File(file));
    } else if (format.equals("json")){
      saveAsJson(contacts, new File(file));*/
    } else {
      System.out.println("Unrecognized format" + format);
    }
  }

  private List<ContactData> generateContacts(int count) {
    List<ContactData> contacts = new ArrayList<ContactData>();
    String[] firstnames = {"John","Alice","Mike","Jane","Tom","Elizabeth","Bill","Naomi","Simon","Norma"};
    String[] lastnames = {"Jackson","Brand","Bush","Carrot","Atkins","Smith","Brown"};
    String[] months = {"January","February","March","April","May","June","July","August","September",
            "October","November","December"};
    for (int i=0; i<count; i++){
      ContactData contact = new ContactData().withFirstname(firstnames[(int) (Math.random()*10)])
              .withLastname(lastnames[(int) (Math.random()*7)]).withBday(String.format("%s",(int) (Math.random()*29)))
              .withAddress(String.format("%s Backer Street %s London",10*i+1,i+2))
              .withBmonth(months[(int) (Math.random()*12)]).withByear(String.format("%s",1970+i))
              .withHomePhone(String.format("%s",556496+2*i)).withGroup("test 1");
      contact = contact.withEmail(String.format("%s_%s@gmai.com",contact.getLastname(),contact.getFirstname()));
      contacts.add(contact);
    }
    return contacts;
  }

  private void saveAsCsv(List<ContactData> contacts, File file) throws IOException {
    Writer writer = new FileWriter(file);
    for (ContactData contact: contacts){
      writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s;%s\n",contact.getFirstname(),contact.getLastname(),contact.getAddress(),
              contact.getBday(),contact.getBmonth(),contact.getByear(),contact.getEmail(),contact.getHomePhone(),contact.getGroup()));
    }
    writer.close();
  }

}
