package com.vlu.Nhom07;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.*;
import org.testng.annotations.*;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;

import static org.testng.Assert.*;

@Listeners(SeleniumNGTest.SeleniumTestListener.class)
public class SeleniumNGTest {
  private static WebDriver driver;
  private static FileWriter writer;
  private static String url;

  public static class SeleniumTestListener implements ITestListener {
    @Override
    public void onTestSuccess(ITestResult result) {
      try {
        writer.append(result.getMethod().getMethodName()).append(',').append("Pass\n");
      } catch (IOException e) {
        System.err.println(e.getMessage());
      }
    }

    @Override
    public void onTestFailure(ITestResult result) {
      try {
        writer.append(result.getMethod().getMethodName()).append(',').append("Fail\n");
      } catch (IOException e) {
        System.err.println(e.getMessage());
      }
    }
  }

  @BeforeTest
  public static void setUp() throws Exception {
    String path = "SeleniumTestResult.csv";
    url = "https://saucedemo.com";
    writer = new FileWriter(path);
    driver = new FirefoxDriver();
    driver.get(url);
    driver.findElement(By.id("user-name")).sendKeys("standard_user");
    driver.findElement(By.id("password")).sendKeys("secret_sauce");
    driver.findElement(By.id("login-button")).click();
  }

  @AfterTest
  public static void tearDown() throws Exception {
    driver.quit();
    writer.close();
  }

  @BeforeMethod
  public void beforeTestcase() {
    driver.get(url);
  }

  @Test
  public void testSauce_Color_01() {
    WebElement userInput = driver.findElement(By.id("user-name"));

    String expectedBg = "#ffffff";
    String actualBg = Color.fromString(userInput.getCssValue("background-color")).asHex();

    assertEquals(actualBg, expectedBg);
  }

  @Test
  public void testSauce_Color_02() {
    WebElement svgImage = driver.findElement(By.tagName("svg"));

    String expectedBg = "#e2231a";
    String actualBg = Color.fromString(svgImage.getCssValue("background-color")).asHex();

    assertEquals(actualBg, expectedBg);
  }

  @Test
  public void testSauce_Color_03() {
    WebElement passwordInput = driver.findElement(By.id("password"));

    String expectedBg = "#ffffff";
    String actualBg = Color.fromString(passwordInput.getCssValue("background-color")).asHex();

    assertEquals(actualBg, expectedBg);
  }

  @Test
  public void testSauce_Color_04() {
    WebElement loginBtn = driver.findElement(By.id("login-button"));

    String expectedBg = "#3ddc91";
    String actualBg = Color.fromString(loginBtn.getCssValue("background-color")).asHex();

    assertEquals(actualBg, expectedBg);
  }

  @Test
  public void testSauce_Color_05() {
    WebElement svgImage = driver.findElement(By.tagName("svg"));

    String expectedBg = "#e2231a";
    String actualBg = Color.fromString(svgImage.getCssValue("background-color")).asHex();

    assertEquals(actualBg, expectedBg);
  }

  @Test
  public void testSauce_Color_06() {
    WebElement loginCred = driver.findElement(By.className("login_credentials_wrap-inner"));

    String expectedBg = "#132322";
    String actualBg = Color.fromString(loginCred.getCssValue("background-color")).asHex();

    assertEquals(actualBg, expectedBg);
  }

  @Test
  public void testSauce_Color_07() {
    driver.get(url + "/inventory.html");

    WebElement burgerBtn = driver.findElement(By.id("react-burger-menu-btn"));

    String expectedBg = "#ffffff";
    String actualBg = Color.fromString(burgerBtn.getCssValue("background-color")).asHex();

    assertEquals(actualBg, expectedBg);
  }

  @Test
  public void testSauce_Color_08() {
    driver.get(url + "/inventory.html");

    WebElement cart = driver.findElement(By.id("shopping_cart_container"));

    String expectedBg = "#ffffff";
    String actualBg = Color.fromString(cart.getCssValue("background-color")).asHex();

    assertEquals(actualBg, expectedBg);
  }

  @Test
  public void testSauce_Color_09() {
    driver.get(url + "/inventory.html");

    WebElement selectCont = driver.findElement(By.className("select_container"));

    String expectedBg = "#ffffff";
    String actualBg = Color.fromString(selectCont.getCssValue("background-color")).asHex();

    assertEquals(actualBg, expectedBg);
  }

  @Test
  public void testSauce_Color_10() {
    driver.get(url + "/inventory.html");

    WebElement div = driver.findElement(By.id("inventory-item"));

    String expectedBg = "#ffffff";
    String actualBg = Color.fromString(div.getCssValue("background-color")).asHex();

    assertEquals(actualBg, expectedBg);
  }

  @Test
  public void testSauce_Color_11() {
    driver.get(url + "/inventory.html");

    WebElement footer = driver.findElement(By.tagName("footer"));

    String expectedBg = "#132322";
    String actualBg = Color.fromString(footer.getCssValue("background-color")).asHex();

    assertEquals(actualBg, expectedBg);
  }

  @Test
  public void testSauce_Color_13() {
    driver.get(url + "/inventory.html");

    WebElement addToCart = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));

    String expectedBg = "#ffffff";
    String actualBg = Color.fromString(addToCart.getCssValue("background-color")).asHex();

    assertEquals(actualBg, expectedBg);
  }

  @Test
  public void testSauce_Color_14() {
    driver.get(url + "/inventory.html");

    driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    WebElement removeBtn = driver.findElement(By.id("remove-sauce-labs-backpack"));

    String expectedBg = "#ffffff";
    String expectedFg = "#e2231a";
    String actualBg = Color.fromString(removeBtn.getCssValue("background-color")).asHex();
    String actualFg = Color.fromString(removeBtn.getCssValue("color")).asHex();

    assertEquals(actualBg, expectedBg);
    assertEquals(actualFg, expectedFg);
  }

  @Test
  public void testSauce_Color_15() {
    driver.get(url + "/inventory.html");

    WebElement body = driver.findElement(By.tagName("body"));

    String expectedBg = "#ffffff";
    String actualBg = Color.fromString(body.getCssValue("background-color")).asHex();

    assertEquals(actualBg, expectedBg);
  }

  @Test
  public void testSauce_Content_01() {
    driver.get(url + "/inventory.html");

    WebElement html = driver.findElement(By.tagName("html"));

    String expectedFont = "DM Sans, Arial, Helvetica, sans-serif";
    String actualFont = html.getCssValue("font-family");

    assertEquals(actualFont, expectedFont);
  }

  @Test(priority = -1)
  public void test_Product04() {
    driver.get(url + "/inventory.html");

    driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    WebElement cartItemCount = driver.findElement(By.className("shopping_cart_badge"));

    String expectedValue = "1";
    String actualValue = cartItemCount.getText();

    assertEquals(actualValue, expectedValue);
  }

  @Test(priority = -2)
  public void test_Product05() {
    driver.get(url + "/inventory.html");

    driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    driver.findElement(By.className("shopping_cart_link")).click();
    driver.findElement(By.id("remove-sauce-labs-backpack")).click();

    expectThrows(
        NotFoundException.class,
        () -> {
          WebElement _ = driver.findElement(By.className("shopping_cart_badge"));
        });
  }

  @Test(priority = -3)
  public void test_Product06() {
    driver.get(url + "/inventory.html");

    driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    driver.findElement(By.id("remove-sauce-labs-backpack")).click();

    expectThrows(
        NotFoundException.class,
        () -> {
          WebElement _ = driver.findElement(By.className("shopping_cart_badge"));
        });
  }

  @Test
  public void test_Product02() {
    driver.get(url + "/inventory.html");

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement productLink =
        wait.until(ExpectedConditions.elementToBeClickable(By.id("item_4_title_link")));

    productLink.click();

    wait.until(ExpectedConditions.urlContains("inventory-item.html?id=4"));

    // Get the product description
    WebElement productDescription = driver.findElement(By.id("inventory_item_description"));
    String descriptionText = productDescription.getText();

    // Ensure the product description is not empty
    Assert.assertFalse(descriptionText.isEmpty(), "Product description is missing!");

    String expectedDescription = "Mô tả chi tiết sản phẩm này";
    Assert.assertEquals(
        descriptionText, expectedDescription, "Product description does not match expected value.");
  }

  @Test
  public void test_product03() {
    driver.get(url + "/inventory.html");

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
    WebElement menuButton = driver.findElement(By.id("react-burger-menu-btn"));
    wait.until(ExpectedConditions.elementToBeClickable(menuButton));
    menuButton.click(); // Open the sidebar menu

    WebElement logoutButton =
        wait.until(ExpectedConditions.elementToBeClickable(By.id("idventory_sidebar_link")));
    logoutButton.click();

    String currentUrl = driver.getCurrentUrl();
    String expectedUrl = "https://www.saucedemo.com/inventory.html";
    Assert.assertEquals("The URL is incorrect all item.", expectedUrl, currentUrl);
  }

  @Test
  public void test_User() {
    driver.get(url + "/inventory.html");

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
    WebElement menuButton = driver.findElement(By.id("react-burger-menu-btn"));
    wait.until(ExpectedConditions.elementToBeClickable(menuButton));
    menuButton.click();

    WebElement logoutButton =
        wait.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link")));
    logoutButton.click();

    String currentUrl = driver.getCurrentUrl();
    String expectedUrl = "https://www.saucedemo.com/";
    Assert.assertEquals("The URL is incorrect after logout.", expectedUrl, currentUrl);
  }
}
