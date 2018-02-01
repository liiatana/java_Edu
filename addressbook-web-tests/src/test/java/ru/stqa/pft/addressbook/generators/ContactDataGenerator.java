package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gw.internal.ext.com.beust.jcommander.ParameterException;
import ru.stqa.pft.addressbook.model.NewContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {
  @Parameter(names = "-c", description="Groups count")
  public int count;

  @Parameter(names = "-f", description="File for export")
  public String file;

  @Parameter(names = "-d", description="Data format file for export")
  public String format;

  public static void main(String[] args) throws IOException {
    ContactDataGenerator generator= new ContactDataGenerator();
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
    List<NewContactData> contacts=generateContacts(count);
     if(format.equals("json")){
      saveAsJSON(contacts, new File(file));
    }else{
      System.out.println("Unrecognized format: "+format);
    };

  }

  private void saveAsJSON(List<NewContactData> contacts, File file) throws IOException {
    //Gson gson = new Gson();// первый способ объявления объекта . в файле все в одну строку
    Gson gson = new GsonBuilder() // второй спсоб создания объекта.в файле вес разделено по строкам,древовидная структура
            .setPrettyPrinting()
            .excludeFieldsWithoutExposeAnnotation()// означает что надо брать в рассчет @Expose
            .create();
    String json = gson.toJson(contacts);
    try(Writer writer=new FileWriter(file)){
      writer.write(json);
    }
    ;

    //writer.close();
  }

  private List<NewContactData> generateContacts(int count) {
    List<NewContactData> contacts= new ArrayList<NewContactData>();
    for( int i=0; i<count;i++){
      contacts.add(new NewContactData()
              .withFirstName(String.format("F_%s_name",i))
              .withLastName(String.format("L_%s_name",i))
              .withMobile(String.format("8 927 %s%s",i,i))
              .withHomePhone(String.format("8-%s%s-000-00",i,i))
              .withWorkPhone(String.format("8 (999) 0%s0 %s%s",i,i,i))
              .withAddress(String.format("ул. Edu д. %s",i))
              //.withPhoto(new File("src/test/resources/PNG74.png" ))
              .withEmail(String.format("email%s@d%s.com",i,i))
              .withEmail2(String.format("SecondEmail%s@d%s.com",i,i))
              .withEmail3(String.format("ThirdEmail%s@d%s.com",i,i)));

              }
    return contacts;
  }

  }


