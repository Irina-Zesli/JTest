package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationHelper extends HelperBase{
  
  //private final ApplicationManager app;
  //private WebDriver wd;

  public RegistrationHelper(ApplicationManager app) {
    //this.app = app;
    super(app);
    wd = app.getDriver();
  }

  public void start(String username, String email) {

    wd.get(app.getProperty("web.baseUrl")+"/signup_page.php");
    type(By.name("username"),username);
    type(By.name("email"),email);
    click(By.cssSelector("input[type='submit']"));
  }

  public void finish(String confirmationLink, String password) {
    wd.get(confirmationLink);
    type(By.name("password"),password);
    type(By.name("password_confirm"),password);
    click(By.cssSelector("input[type='submit']"));//???
  }
}
