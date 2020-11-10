package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import ru.stqa.pft.mantis.model.UserData;
import ru.stqa.pft.mantis.model.Users;

public class ChangePasswordHelper extends HelperBase{

  public ChangePasswordHelper(ApplicationManager app) {
    super(app);
    wd = app.getDriver();
  }

  public void start() {
    loginUI(app.getProperty("web.adminLogin"),app.getProperty("web.adminPassword"));
    gotoManageUserPage();
  }

  public void forUser(UserData user){
    click(By.cssSelector(String.format("a[href='manage_user_edit_page.php?user_id=%s']",user.getId())));
    click(By.id("manage-user-reset-form"));
  }

  private void loginUI(String login, String password) {
    wd.get(app.getProperty("web.baseUrl")+"/login_page.php");
    type(By.name("username"), login);
    type(By.name("password"), password);
    click(By.cssSelector("input[type='submit']"));
  }

  private void gotoManageUserPage() {
    click(By.cssSelector("a[href='/mantisbt-1.3.20/manage_overview_page.php']"));
    click(By.cssSelector("a[href='/mantisbt-1.3.20/manage_user_page.php']"));
  }

}
