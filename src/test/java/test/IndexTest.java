package test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import page.IndexPage;
@TestMethodOrder(OrderAnnotation.class)
public class IndexTest {

	private static final String URL = "http://localhost:9092/";
	
	private static WebDriver driver;
	
	@BeforeAll
	public static void init() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		
		options.setHeadless(true);
		
		driver = new ChromeDriver(options);
		driver.manage().window().setSize(new Dimension(1368,768));
		
//			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
	}
	
	@Test
	@Order(1)
	public void testURL() {
		driver.get(URL);
		
		assertEquals(URL, driver.getCurrentUrl());
	}
	
	
	@Test
	@Order(2)
	public void testCreate() {
		driver.get(URL);
		IndexPage index = PageFactory.initElements(driver, IndexPage.class);
		
		String title = "Glue";	
		String artist = "Bicep";
		String label = "NinjaTune";
		String year = "2017";
		String genre = "BreakBeat";
		String key = "Dm";
		
		 
		index.create(title, artist, label, year, genre, key);
		 WebDriverWait wait = new WebDriverWait(driver, 10);  
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"songTable\"]/thead/tr[2]/td[2]")));
		assertTrue(driver.getPageSource().contains(title));
		assertTrue(driver.getPageSource().contains(artist));
		assertTrue(driver.getPageSource().contains(label));
		assertTrue(driver.getPageSource().contains(genre));
		assertTrue(driver.getPageSource().contains(year));
		assertTrue(driver.getPageSource().contains(key));
	}
	

	@Test
	@Order(3)
	public void testRead() {
		driver.get(URL);
		
		IndexPage index = PageFactory.initElements(driver, IndexPage.class);
		
	
		WebDriverWait wait = new WebDriverWait(driver, 10);  
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"songTable\"]/thead/tr[2]/td[2]")));
		
		String title = "Glue";	
		String artist = "Bicep";
		String label = "NinjaTune";
		String year = "2017";
		String genre = "BreakBeat";
		String key = "Dm";
		
		assertEquals(title, index.getReadTitle().getText());
		assertEquals(artist, index.getReadArtist().getText());
		assertEquals(label, index.getReadLabel().getText());
		assertEquals(year, index.getReadYear().getText());
		assertEquals(genre, index.getReadGenre().getText());
		assertEquals(key, index.getReadKey().getText());
		
		
			}

	@Test
	@Order(4)
	public void testUpdate() {
		driver.get(URL);
		IndexPage index = PageFactory.initElements(driver, IndexPage.class);
		
		String title = "Blinding Lights";	
		String artist = "The Weekend";
		String label = "Republic Records";
		String year = "2020";
		String genre = "Pop";
		String key = "Em";
		
		index.getEditButton().click();

		driver.switchTo().activeElement();
		WebDriverWait wait = new WebDriverWait(driver, 10);  
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"modalTitle\"]")));
		
		index.getUpdateTitle().clear();
		index.getUpdateGenre().clear();
		index.getUpdateArtist().clear();
		index.getUpdateLabel().clear();
		index.getUpdateYear().clear();
		index.getUpdateKey().clear();
		index.update(title, artist, label, year, genre, key);
		
		index.getUpdateSong().click();
		driver.switchTo().activeElement();
		WebDriverWait wait2 = new WebDriverWait(driver, 10);  
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"songTable\"]/thead/tr[2]/td[2]")));
		assertTrue(driver.getPageSource().contains(title));
		assertTrue(driver.getPageSource().contains(artist));
		assertTrue(driver.getPageSource().contains(label));
		assertTrue(driver.getPageSource().contains(genre));
		assertTrue(driver.getPageSource().contains(year));
		assertTrue(driver.getPageSource().contains(key));
	}
		
	
	
	@Test
	@Order(5)
	public void testDelete() {
		
		driver.get(URL);
		IndexPage index = PageFactory.initElements(driver, IndexPage.class);
		
		index.getDeleteButton().click();
		
		String title = "Blinding Lights";	
		String artist = "The Weekend";
		String label = "Republic Records";
		String year = "2020";
		String genre = "Pop";
		String key = "Em";
		
		assertTrue(!driver.getPageSource().contains(title));
		assertTrue(!driver.getPageSource().contains(artist));
		assertTrue(!driver.getPageSource().contains(label));
		assertTrue(!driver.getPageSource().contains(genre));
		assertTrue(!driver.getPageSource().contains(year));
		assertTrue(!driver.getPageSource().contains(key));
	
	}
	

	@AfterAll
	public static void shutdown() {
		driver.close();
	}
	
	
}
