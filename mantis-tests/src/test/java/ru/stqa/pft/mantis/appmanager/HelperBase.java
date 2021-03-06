package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

import static org.testng.Assert.assertTrue;

public class HelperBase {
  protected ApplicationManager app;
  protected WebDriver wd;

  public HelperBase(ApplicationManager app) {

    this.app = app;
    this.wd = app.getDriver();
  }

  protected void click(By locator) {
    wd.findElement(locator).click();
  }

  protected void type(By locator, String text) {
    click(locator);
    if (text!=null) {
      String existingText = wd.findElement(locator).getAttribute("value");
      if (! text.equals(existingText)) {
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
      }
    }
  }

  protected void attach(By locator, File file) {
    if (file!=null) {
      wd.findElement(locator).sendKeys(file.getAbsolutePath());
    }
  }

  private boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  protected void select(By locator, String text) {
    click(locator);
    new Select(wd.findElement(locator)).selectByVisibleText(text);
    click(By.xpath("//option[@value='"+ text +"']"));
  }

  protected void selectGr(By locator, String text) {
    click(locator);
    new Select(wd.findElement(locator)).selectByValue(text);
    //click(By.xpath("//option[@value='"+ text +"']"));
    //click(locator);
  }

  /*protected String closeAlertAndGetItsText() {
    try {
      Alert alert = wd.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }*/

  /*protected void confirmDel(String regex) {
    assertTrue(closeAlertAndGetItsText().matches(regex));
  }*/

  protected boolean isElementPresent(By locator) {
    try {
      wd.findElement(locator);
      return true;
    } catch (NoSuchElementException ex) {
      return false;
    }
  }
}

