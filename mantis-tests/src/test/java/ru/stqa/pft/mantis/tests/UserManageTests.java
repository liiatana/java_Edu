package ru.stqa.pft.mantis.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.mantis.appmanager.HttpSession;
import ru.stqa.pft.mantis.model.MailMessage;
import ru.stqa.pft.mantis.model.UserData;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

public class UserManageTests extends TestBase{

  @BeforeTest
  public void ensurePrecondition() {
    app.mail().start();

  }

  @Test
  public void resetUserPassByAdmin() throws IOException, MessagingException {

    String newPassword="1qaz";
    UserData changedUser=app. db().findAnyUser(1);
    Assert.assertTrue(changedUser!=null);
    String userEmail=changedUser.getEmail();
    app.registration().loginAs("administrator","root");
    app.um().resetUserPassword(changedUser.getId());
    List<MailMessage> mailMasseges=app.mail().waitForMail(1,10000);
    String confirmationLink = app.mail().findConfirmationLink(mailMasseges, userEmail);

    app.um().confirmChangePassword(confirmationLink,newPassword);

    HttpSession session = app.newSession() ;
    Assert.assertTrue( session.login(changedUser.getUsername(),newPassword));
    Assert.assertTrue( session.isLoggedInAs(changedUser.getUsername()));

  }

  @AfterTest(alwaysRun = true)
  public void ensurePostcondition() {
    app.mail().stop();
  }


}
