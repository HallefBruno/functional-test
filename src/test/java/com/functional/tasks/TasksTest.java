package com.functional.tasks;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TasksTest {
  
  public WebDriver acessarFront() throws MalformedURLException {
    ChromeOptions chromeOptions = new ChromeOptions();
    WebDriver driver = new RemoteWebDriver(new URL("http://192.168.3.104:4444"), chromeOptions);
    //WebDriver driver = new ChromeDriver();
    driver.navigate().to("http://172.25.128.1:8001/tasks");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    return driver;
  }
  
  @Test
  public void deveSalvarTaskComSucesso() throws MalformedURLException {
    WebDriver driver = acessarFront();
    try {
      driver.findElement(By.id("addTodo")).click();
      driver.findElement(By.id("task")).sendKeys("Teste via selenium 0");
      driver.findElement(By.id("dueDate")).sendKeys(dueDate());
      driver.findElement(By.id("saveButton")).click();
      String message = driver.findElement(By.id("message")).getText();
      Assert.assertEquals("Sucess!", message);
    } finally {
      driver.quit();
    }
  }
  
  @Test
  public void deveSalvarTaskComSucesso1() throws MalformedURLException {
    WebDriver driver = acessarFront();
    try {
      driver.findElement(By.id("addTodo")).click();
      driver.findElement(By.id("task")).sendKeys("Teste via selenium 1");
      driver.findElement(By.id("dueDate")).sendKeys(dueDate());
      driver.findElement(By.id("saveButton")).click();
      String message = driver.findElement(By.id("message")).getText();
      Assert.assertEquals("Sucess!", message);
    } finally {
      driver.quit();
    }
  }
  
  @Test
  public void deveSalvarTaskComSucesso2() throws MalformedURLException {
    WebDriver driver = acessarFront();
    try {
      driver.findElement(By.id("addTodo")).click();
      driver.findElement(By.id("task")).sendKeys("Teste via selenium 2");
      driver.findElement(By.id("dueDate")).sendKeys(dueDate());
      driver.findElement(By.id("saveButton")).click();
      String message = driver.findElement(By.id("message")).getText();
      Assert.assertEquals("Sucess!", message);
    } finally {
      driver.quit();
    }
  }
  
  @Test
  public void deveSalvarTaskComSucesso3() throws MalformedURLException {
    WebDriver driver = acessarFront();
    try {
      driver.findElement(By.id("addTodo")).click();
      driver.findElement(By.id("task")).sendKeys("Teste via selenium 3");
      driver.findElement(By.id("dueDate")).sendKeys(dueDate());
      driver.findElement(By.id("saveButton")).click();
      String message = driver.findElement(By.id("message")).getText();
      Assert.assertEquals("Sucess!", message);
    } finally {
      driver.quit();
    }
  }
  
  private String dueDate() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    return LocalDate.now().format(formatter);
  }

}
