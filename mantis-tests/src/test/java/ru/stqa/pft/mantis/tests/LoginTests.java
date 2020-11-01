package ru.stqa.pft.mantis.tests;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import ru.stqa.pft.mantis.appmanager.HttpSession;

import java.io.IOException;

public class LoginTests extends TestBase {

  @Test
  public void testLogin() throws IOException{
    HttpSession session = app.newSession();
    assertTrue(session.login("administrator","root"));
    assertTrue(session.isLoggedInAs("administrator"));
  }

}
