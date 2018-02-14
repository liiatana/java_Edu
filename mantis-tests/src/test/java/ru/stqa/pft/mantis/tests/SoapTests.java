package ru.stqa.pft.mantis.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.mantis.model.Issue;
import ru.stqa.pft.mantis.model.Project;

import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Set;

public class SoapTests extends TestBase{

  @Test
  public void testGetProjects() throws MalformedURLException, ServiceException, RemoteException {

    skipIfNotFixed(3);

    Set<Project> projects = app.sp().getProjects();
    System.out.println(projects.size());
    for (Project project:projects){
      System.out.println(project.getName());
    }
  }

  @Test()
  public void testCreateIssue() throws MalformedURLException, ServiceException, RemoteException {
    skipIfNotFixed(3);

    Set<Project> projects = app.sp().getProjects();
    Project project=projects.iterator().next();
    Issue issue= new Issue()
            .withSummary("some summary")
            .withDescription("some descrition")
            .withProject(project);
    Issue created=app.sp().addIssue(issue);
    Assert.assertEquals(created.getSummary(),issue.getSummary());
  }

}
