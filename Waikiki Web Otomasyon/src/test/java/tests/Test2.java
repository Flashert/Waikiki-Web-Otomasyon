package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import Utilities.Log4j;
import Model.WebElements;

import java.util.concurrent.TimeUnit;

public class Test2 {
    public static WebDriver driver;
    public static String url;
    public static String email = "safakyil96@hotmail.com";
    public static String password = "safak9696";
    public static WebElements webElements;
    @Before
    public void setupDriver(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        url = "https://www.lcwaikiki.com/tr-TR/TR";                                       //Chrome driver ayarları yapılır.
        webElements = new WebElements(driver);
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(200,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Log4j.startLog();
    }
    @Test
    public void testProcess(){
        Actions a = new Actions(driver);
        driver.get(url);
        WebElement girisYapButon = webElements.getLogin();
        girisYapButon.click();
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        WebElement eMailBox = webElements.getEMailBox();
        eMailBox.sendKeys(email);
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        WebElement passBox = webElements.getPassBox();
        passBox.sendKeys(password);
        WebElement loginButton = webElements.getLoginButton();
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        loginButton.click();
        Log4j.info("Giriş yapıldı.");
        WebElement searchBox = webElements.getSearchBox();
        searchBox.sendKeys("pantolon");
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        WebElement searchButton = webElements.getSearchButton();
        searchButton.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,10000)", "");
        driver.manage().timeouts().pageLoadTimeout(200,TimeUnit.SECONDS);
        WebElement dahaFazla = webElements.getDahaFazlaButton();
        dahaFazla.click();
        WebElement randomProduct = webElements.getRandomProduct();
        randomProduct.click();
        driver.manage().timeouts().pageLoadTimeout(200,TimeUnit.SECONDS);
        WebElement size = webElements.getSize();
        js.executeScript("arguments[0].click();", size);
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        WebElement addButton = webElements.getAddButton();
        addButton.click();
        Log4j.info("Ürün sepete eklendi.");
        String productPrice = webElements.getProductPrice();
        String basketPrice = webElements.getBasketPrice();
        if(productPrice.equals(basketPrice)){
            Log4j.info("Ürün fiyatı ile sepetteki fiyat aynı");
            addButton.click();
            driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
            WebElement quantity = driver.findElement(By.cssSelector("#spanCart"));
            String productQuantity = quantity.getAttribute("innerHTML");
            System.out.println(productQuantity);
            if(productQuantity.equals("1") || productQuantity.equals("2")){
                Log4j.info("Ürün adedi 2");
                WebElement basketButton = webElements.getBasketButton();
                String basketUrl = basketButton.getAttribute("href");
                driver.get(basketUrl);
                driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
                WebElement deleteButton = webElements.getDeleteButton();
                js.executeScript("arguments[0].click();", deleteButton);
                driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
                WebElement deleteButton2 = webElements.getDeleteButton2();
                js.executeScript("arguments[0].click();", deleteButton2);

                String basketText = webElements.getBasketText();
                if(basketText.equals("Sepetinizde ürün bulunmamaktadır.")){
                    Log4j.info("Sepet boş");
                }
                else{
                    Log4j.error("Sepet dolu");
                }
            }
            else{

                Log4j.error("Ürün adedi 2 değil");
            }
        }
        else{

            Log4j.error("Ürün fiyatı ile sepetteki fiyat farklı");
        }


    }
    @After public void afterTest(){
        driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
        driver.quit();
        Log4j.endLog();
    }
}
