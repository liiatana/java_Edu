package ru.stqa.pft.mantis.tests;

import org.testng.annotations.*;
import ru.stqa.pft.mantis.model.MailMessage;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

public class RegistrationTests extends  TestBase{
  @BeforeTest
  public void startMailServer(){
    app.mail().start();
  }

  @Test
  public void testRegistration() throws IOException, MessagingException {
    String email = "usermail@qw.fgh";
    String user = "qqq33asdas3";
    String password = "password";

    app.registration().start(user, email);
    List<MailMessage> mailMasseges=app.mail().waitForMail(2,1000);
    String confirmationLink = app.mail().findConfirmationLink(mailMasseges, email);

    app.registration().finish(confirmationLink, password);
    assertTrue( app.newSession().login(user, password));

  }

  @AfterTest(alwaysRun = true)
  public void stopMailServer(){
    app.mail().stop();
  }

}
