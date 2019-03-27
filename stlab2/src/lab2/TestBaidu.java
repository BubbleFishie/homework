package lab2;

import java.util.regex.Pattern;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestBaidu {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  static List<List<String>> allData=new ArrayList<List<String>>();

  public static List<List<String>> dealData(List<List<String>> allData) throws IOException {  
	     try {   
	            File excelFile = new File("D:\\大三下\\软件测试\\软件测试名单.xlsx"); // 创建文件对象  
	            FileInputStream is = new FileInputStream(excelFile); // 文件流  
	            Workbook workbook = new XSSFWorkbook(is);   
	            Sheet sheet = workbook.getSheetAt(0);   

	            // 为跳过第一行目录设置count  
	            int count = 0;  
	            for (Row row : sheet) {  
	                // 跳过第一行的目录  
	                if(count == 0){  
	                    count++;  
	                    continue;  
	                }  
	                // 如果当前行没有数据，跳出循环  
	                if(row.getCell(0).toString().equals("")){  
	                    break ;  
	                }  
	                List<String> oneData = new ArrayList<String>(); 
	                for (Cell cell : row) {  
	                    if(cell.toString() == null){  
	                        continue;  
	                    }  
	                    int cellType = cell.getCellType();  
	                    String cellValue = "";  
	                    switch (cellType) {  
                        case Cell.CELL_TYPE_STRING:     // 文本  
                            cellValue = cell.getRichStringCellValue().getString(); 
                            break;  
                        case Cell.CELL_TYPE_NUMERIC:    // 数字
                                cell.setCellType(Cell.CELL_TYPE_STRING);  
                                cellValue = String.valueOf(cell.getRichStringCellValue().getString());  
                            
                            break;  
	                    }
	                    oneData.add(cellValue);
	            }   
	                allData.add(oneData);
	        }   
	     }catch (Exception e) {  
	            e.printStackTrace();  
	        } finally{    
	        }
		return allData;  
	    } 
  
  @Before
  public void setUp() throws Exception {
	  String driverPath = System.getProperty("user.dir") + "/src/resources/geckodriver.exe";
	  System.setProperty("webdriver.gecko.driver", driverPath);
	  driver = new FirefoxDriver();
	  baseUrl = "http://121.193.130.195:8800";
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testBaidu() throws Exception {
	  dealData(allData);
	  driver.get(baseUrl + "/login");
    WebElement we = driver.findElement(By.name("id"));
    we.click();
	driver.findElement(By.name("id")).clear();
    for(int i=0;i<allData.size();i++) {
    	List<String> node=allData.get(i);
    	String id=node.get(1);
    	String password=id.substring(4, 10);
    	String name=node.get(2);
    	String git=node.get(3);
    		
    	    driver.findElement(By.name("id")).sendKeys(id);
    	    driver.findElement(By.name("password")).sendKeys(password);
    	    driver.findElement(By.id("btn_login")).click();
    	    assertEquals(id, driver.findElement(By.id("student-id")).getText());
    	    assertEquals(name, driver.findElement(By.id("student-name")).getText());
    	    assertEquals(git, driver.findElement(By.id("student-git")).getText());
    	    driver.findElement(By.id("btn_logout")).click();
    	    driver.findElement(By.id("btn_return")).click();
    	    driver.findElement(By.name("id")).clear();
    	
    	}
    	
  }

  @After
  public void tearDown() throws Exception {
//    driver.quit();
//    String verificationErrorString = verificationErrors.toString();
//    if (!"".equals(verificationErrorString)) {
//      fail(verificationErrorString);
//    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
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
  }
}

