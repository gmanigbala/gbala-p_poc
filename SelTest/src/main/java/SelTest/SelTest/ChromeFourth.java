package SelTest.SelTest;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;  
  
public class ChromeFourth {   
    
    public static void main(String[] args) throws Exception {  
      
           
        
        DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();

        capabilities.setCapability(CapabilityType.BROWSER_NAME, "IE");

        capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);

        capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);

        //System.setProperty("webdriver.ie.driver","C://MavenTest//driver//IEDriverServer.exe");

        // System Property for IEDriver   
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
        
       // driver = new InternetExplorerDriver();
        
           // Instantiate a IEDriver class.        
        WebDriver driver=new ChromeDriver();     
        
           // Launch Website   
        //driver.navigate().to("http://demo.guru99.com/V4/");  
        
        driver.get("http://demo.guru99.com/V4/");
          
           //Maximize the browser  
          //driver.manage().window().maximize();   
            
           // Click on the search text box and send value  
        //driver.findElement(By.id("lst-ib")).sendKeys("javatpoint tutorials");  
              
           // Click on the search button  
        //driver.findElement(By.name("btnK")).click();
          
          takeSnapShot(driver, "d://bala//seli/test.png") ;
          
        //*[@id="site-name"]/a
          ///html/body/div[1]/div[1]/div[1]/div[2]/div/a
            
  
    }  
    
    public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

        //Convert web driver object to TakeScreenshot
    	System.out.println("wait");
    	Thread.sleep(5000);
    	//WebElement logoElement = webdriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/div/a"));
    	
    	WebElement logoElement = webdriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/div/a"));
    	
        /*System.out.println(logoElement);
        boolean abb = false; 
        while(abb == false) {
        	
        	System.out.println(logoElement);
        	if (logoElement != null)
        		abb = true;
        }*/
        
        TakesScreenshot scrShot =((TakesScreenshot)webdriver);
        
        //Call getScreenshotAs method to create image file

                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

            //Move image file to new destination

                File DestFile=new File(fileWithPath);

                //Copy file at destination

                FileUtils.copyFile(SrcFile, DestFile);

    }

    
  
}  