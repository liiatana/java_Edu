package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import gw.internal.ext.com.beust.jcommander.ParameterException;
import ru.stqa.pft.addressbook.model.GroupData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class GroupDataGenerator {

  @Parameter(names = "-c", description="Groups count")
  public int count;

  @Parameter(names = "-f", description="File for export")
  public String file;

  @Parameter(names = "-d", description="Data format file for export")
  public String format;

  public static void main(String[] args) throws IOException {
    GroupDataGenerator generator= new GroupDataGenerator();
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
    List<GroupData> groups=generateGroups(count);
    if(format.equals("csv")) {
      saveAsCSV(groups, new File(file));
    }else if(format.equals("xml")){
      saveAsXML(groups, new File(file));
    }else if(format.equals("json")){
      saveAsJSON(groups, new File(file));
    }else{
      System.out.println("Unrecognized format: "+format);
    };

  }

  private void saveAsJSON(List<GroupData> groups, File file) throws IOException {
    //Gson gson = new Gson();// первый способ объявления объекта . в файле все в одну строку
    Gson gson = new GsonBuilder() // второй спсоб создания объекта.в файле вес разделено по строкам,древовидная структура
            .setPrettyPrinting()
            .excludeFieldsWithoutExposeAnnotation()// означает что надо брать в рассчет @Expose
            .create();
    String json = gson.toJson(groups);
    Writer writer=new FileWriter(file);
    writer.write(json);
    writer.close();

  }

  private void saveAsXML(List<GroupData> groups, File file) throws IOException {
    XStream xstream = new XStream();
    //xstream.alias("group", GroupData.class);//первый способ создания аннотаций в xml
    xstream.processAnnotations(GroupData.class);// второй способ создания аннотации xml: предварительно в классе изкоторого эксперт даных, добавлена аннотация @XStreamAlias("group"
    String xml = xstream.toXML(groups);
    Writer writer=new FileWriter(file);
    writer.write(xml);
    writer.close();

  }

  private void saveAsCSV(List<GroupData> groups, File file) throws IOException {

    Writer writer=new FileWriter(file);
    for(GroupData group:groups){
      writer.write(String.format("%s;%s;%s\n",group.getName(),group.getHeader(),group.getFooter()));
    }
    writer.close();


  }

  private List<GroupData> generateGroups(int count) {

    List<GroupData> groups= new ArrayList<GroupData>();
    for( int i=0; i<count;i++){
      groups.add(new GroupData()
              .withName(String.format("qname %s",i))
              .withHeader(String.format("qheader %s",i))
              .withFooter(String.format("qfooter %s",i)));
    }
    return groups;
  }
  
  
}
