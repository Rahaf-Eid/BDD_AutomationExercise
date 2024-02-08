package com.POM;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
@Data
public class webElementPath {
    public static WebElement element;
    public static By loginSignup = By.xpath("//a[normalize-space()='Signup / Login']");
    public static By username = By.xpath("//input[@data-qa='login-email']");
    public static By password = By.xpath("//input[@placeholder='Password']");
    public static By loginButton = By.xpath("//button[normalize-space()='Login']");
    public static By ProductsButton = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a");
    public static By allProductsPage = By.xpath("/html/body/section[2]/div/div/div[2]/div/h2");
    public static By fullList = By.xpath("/html/body/section[2]/div/div/div[2]/div");
    public static By viewFirstProduct = By.xpath("/html/body/section[2]/div/div/div[2]/div");
    public static By productInformation = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div");
    public static By productName = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/h2");
    public static By category = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[1]");
    public static By price = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/span");
    public static By availability = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[2]/b");
    public static By condition = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[3]/b");
    public static By brand = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[4]/b");


}
