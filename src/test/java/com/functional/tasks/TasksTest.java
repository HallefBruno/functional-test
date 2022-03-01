package com.functional.tasks;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TasksTest {
  
  public WebDriver acessarFront() {
    WebDriver driver = new ChromeDriver();
    driver.navigate().to("http://127.0.0.1:8001/tasks");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    return driver;
  }
  
  @Test
  public void deveSalvarTaskComSucesso() {
    WebDriver driver = acessarFront();
    try {
      driver.findElement(By.id("addTodo")).click();
      driver.findElement(By.id("task")).sendKeys("Teste via selenium");
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
