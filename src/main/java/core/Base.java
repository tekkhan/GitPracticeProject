package core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

public static WebDriver driver;
public static Properties properties;
public static Logger logger;
private String configPath = ".\\src\\test\\resources\\input\\config.properties";
private String log4jPath = ".\\src\\test\\resources\\input\\log4j.properties";

public Base() {

try {
	BufferedReader reader = new BufferedReader(new FileReader(configPath));
	properties = new Properties();
	properties.load(reader);
	reader.close(); 
} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (IOException e) { 
	// TODO Auto-generated catch block
	e.printStackTrace();
}
logger = logger.getLogger(log4jPath);
PropertyConfigurator.configure(log4jPath);
}

public static String getURL(){
String url = properties.getProperty("url");
return url;
}
public static String getBrowser() {
String browser = properties.getProperty("browser");
return browser;
}

public void openBrowser() {
driver.get(getURL());
}

public static void selectBrowser() {
switch (getBrowser()) {
case "chrome":
WebDriverManager.chromedriver().setup();
driver = new ChromeDriver();
break;

case "firefox":
WebDriverManager.firefoxdriver().setup();
break;

case "edge":
WebDriverManager.firefoxdriver().setup();
driver = new EdgeDriver();
break;
default:
WebDriverManager.chromedriver().setup();
driver = new ChromeDriver();
}
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);









}
}
	








