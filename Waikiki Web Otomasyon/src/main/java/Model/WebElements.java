package Model;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;


public class WebElements {
    public static WebDriver driver;
    public WebElements(WebDriver driver){
        this.driver = driver;
    }
    public WebElement getLogin(){
        return driver.findElement(By.cssSelector("#header-user-section > i"));
    }
    public WebElement getEMailBox(){
        return driver.findElement(By.cssSelector("#LoginEmail"));
    }
    public WebElement getPassBox(){
        return driver.findElement(By.cssSelector("#Password"));
    }
    public WebElement getLoginButton(){
        return driver.findElement(By.cssSelector("#loginLink"));
    }
    public WebElement getSearchBox(){
        return driver.findElement(By.cssSelector("#search"));
    }
    public WebElement getSearchButton(){
        return driver.findElement(By.cssSelector("#fwds-container > div > div > div > div.search-area > a > span"));
    }
    public WebElement getDahaFazlaButton(){
        return driver.findElement(By.cssSelector("#divModels > div:nth-child(10) > div > div.paging-process > a > p"));
    }
    public WebElement getRandomProduct(){
        return driver.findElement(By.cssSelector("#divModels > div:nth-child(10) > div > div.row.c-items > div:nth-child(98)"));
    }
    public  WebElement getSize(){
        return driver.findElement(By.cssSelector("#option-size > a:nth-child(6)"));
    }
    public WebElement getAddButton(){
        return driver.findElement(By.cssSelector("#rightInfoBar > div:nth-child(1) > div > div.mobile-size-and-cart-container > div.row.buttons-area > div > div"));
    }
    public String getProductPrice(){
        return driver.findElement(By.cssSelector("#rightInfoBar > div:nth-child(1) > div > div:nth-child(3) > div > div > div > span.price")).getText();
    }
    public String getBasketPrice(){
        return driver.findElement(By.cssSelector("#cart-items > div.added-items > div > div.o-info > p.amount")).getAttribute("innerHTML");
    }
    public WebElement getBasketButton(){
        return driver.findElement(By.cssSelector("#divCartSlider > div > div:nth-child(3) > a"));
    }
    public WebElement getDeleteButton(){
        return driver.findElement(By.cssSelector("#ShoppingCartContent > div.row.mt-20.main-content-row > div.col-md-8 > div.products-area > div.rd-cart-item.shoppingcart-item > div.row.mb-5 > div.col-md-4.col-xs-3.text-right.sc-option-detail.pl-0 > div > a"));
    }
    public WebElement getDeleteButton2(){
        return driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[2]/div[1]/div[1]/div[2]/div[2]/div/div/div[3]/div/div/a[1]"));
    }
    public String getBasketText(){
        return driver.findElement(By.cssSelector("#ShoppingCartContent > div.row.mt-20.main-content-row > div > div > p.cart-empty-title")).getText();
    }


}
