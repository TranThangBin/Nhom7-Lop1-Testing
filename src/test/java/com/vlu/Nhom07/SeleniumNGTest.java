package com.vlu.Nhom07;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import static org.testng.Assert.*;

public class SeleniumNGTest {
  private static WebDriver driver;

  @BeforeClass
  public void setup() {
    driver = new FirefoxDriver();
  }

  @BeforeMethod
  public void beforeTestcase() {
    String url = "https://demoqa.com/automation-practice-form";
    driver.get(url);
  }

  @AfterClass
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void testFirstName() {
    WebElement txtFirstName = driver.findElement(By.id("firstName"));

    boolean expResult = true;
    boolean result = txtFirstName.isEnabled();

    assertEquals(result, expResult);
  }

  @Test
  public void testLastName() {
    WebElement txtLastName = driver.findElement(By.id("lastName"));

    boolean expResult = true;
    boolean result = txtLastName.isEnabled();

    assertEquals(result, expResult);
  }

  @Test
  public void testUserName() {
    WebElement txtUserName = driver.findElement(By.id("userName"));

    boolean expResult = true;
    boolean result = txtUserName.isEnabled();

    assertEquals(result, expResult);
  }

  @Test
  public void testGenderWrapper() {
    WebElement checkGenderRadio1 = driver.findElement(By.id("gender-radio-1"));

    String expResult = "true";
    String result = checkGenderRadio1.getAttribute("checked");

    assertEquals(result, expResult);
  }

  @Test
  public void testUserNumber() {
    WebElement txtUserNumber = driver.findElement(By.id("userNumber"));

    boolean expResult = true;
    boolean result = txtUserNumber.isEnabled();

    assertEquals(result, expResult);
  }

  @Test
  public void testDateOfBirthInput() {
    WebElement txtDateOfBirth = driver.findElement(By.id("dateOfBirthInput"));

    String expResult = "false";
    String result = txtDateOfBirth.getAttribute("readonly");

    assertEquals(result, expResult);
  }

  @Test
  public void testSubject() {
    WebElement txtSubject = driver.findElement(By.id("subjectsInput"));

    boolean expResult = true;
    boolean result = txtSubject.isEnabled();

    assertEquals(result, expResult);
  }

  @Test
  public void testCheckbox() {}

  @Test
  public void testChooseFile() {
    WebElement fileUploadPic = driver.findElement(By.id("uploadPicture"));

    boolean expResult = true;
    boolean result = fileUploadPic.isEnabled();

    assertEquals(result, expResult);
  }

  @Test
  public void testCurentAddress() {
    WebElement txtCurentAddress = driver.findElement(By.id("curentAddress"));

    boolean expResult = true;
    boolean result = txtCurentAddress.isEnabled();

    assertEquals(result, expResult);
  }

  @Test
  public void testSelectState01() {
    WebElement cmbState = driver.findElement(By.id("state"));

    boolean expResult = true;
    boolean result = cmbState.isEnabled();

    assertEquals(result, expResult);
  }

  @Test
  public void testSelectState02() {
    WebElement cmbState = driver.findElement(By.id("state"));

    String expResult = "false";
    String result = cmbState.getAttribute("readonly");

    assertEquals(result, expResult);
  }

  @Test
  public void testSelectCity01() {
    WebElement cmbCity = driver.findElement(By.id("city"));

    boolean expResult = true;
    boolean result = cmbCity.isEnabled();

    assertEquals(result, expResult);
  }

  @Test
  public void testSelectCity02() {
    WebElement cmbCity = driver.findElement(By.id("city"));

    String expResult = "false";
    String result = cmbCity.getAttribute("readonly");

    assertEquals(result, expResult);
  }

  @Test
  public void testRequiredField() throws Exception {
    JavascriptExecutor executor = (JavascriptExecutor) driver;

    String firstname = "Nguyễn";
    String lastname = "Văn A";
    String phoneNumber = "0123456789";

    driver.findElement(By.id("firstName")).sendKeys(firstname);
    driver.findElement(By.id("lastName")).sendKeys(lastname);
    driver.findElement(By.id("userNumber")).sendKeys(phoneNumber);

    WebElement maleRadioBtn = driver.findElement(By.cssSelector("input[value='Male']"));
    executor.executeScript("arguments[0].click()", maleRadioBtn);

    WebElement submitBtn = driver.findElement(By.id("submit"));
    executor.executeScript("arguments[0].click()", submitBtn);

    WebElement unexpResult = null;
    WebElement result = driver.findElement(By.className("modal-content"));

    assertNotEquals(result, unexpResult);
  }
}
