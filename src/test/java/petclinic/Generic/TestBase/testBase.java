
/* testing with 
 * has POM without page factory
 * has Test NG parameters
 * has Test listeners, Reporting, logs,  screenshots
 * has Excel config, parameterisation with apache POI
 * has different browser set up statements
 * 
 * no Maven,  GIT, log4j, PageObjFactory
 */

package petclinic.Generic.TestBase;
//test
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.Assertion;
import org.testng.asserts.IAssert;
import org.testng.collections.Maps;

//import Clove.Tests.Functional.PostProvisionSanityBlockChain;
/*import Clove.Tests.Functional.;
import Clove.Tests.Functional.PostProvisionSanitySelectedTools;*/
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import petclinic.Functional.petclinic;


//adding crossbrowser change with webhook
public class testBase implements ISuiteListener  {
	
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static String[] toolsToTest=null;
	public static String[] ipstoTest=null;
	public static String[] cartridgesToTest=null;
	public String selectedTools;
	public static String categoryType;
	public static String[] subCategory=null;
	public static String username;
	public static String testusername;
	public static String password;
	public static String testpassword;
	public static String appURL;
	public static String testappURL;
	public static String ldappassword;
	public static String ldapnewusername;
	public static String jobName;
	public static String osystem;
	public String rptfile;
	public static String Mywizardinfra;
	public static String infrastructuretype;
	public static String emailusername;
	public static String emailpassword;
	public static String gitrepourl;
	public static String applicationame;
	public static String branch;
		
	
//Initial Prerequisites for any test - Browser config and LoadExcel	by receiving the parameters from cmd line
	@Override
    public void onStart(ISuite suite)
	{
       /* Map<String, String> parameters = suite.getXmlSuite().getParameters();
        for (Map.Entry<String, String> parameter : parameters.entrySet()) 
        {
            String appURL = System.getenv(parameter.getKey());
            
            
            if (appURL != null && !appURL.trim().isEmpty()) 
            	parameter.setValue(appURL);
                          	
        }*/
    }

    @Override
    public void onFinish(ISuite suite) {

    }

    @BeforeClass
  	@Parameters({"jobName","username","password","testusername","testpassword","LdapAdminpassword","Mywizardinfra","infrastructuretype","categoryType","LdapNewusername","gitrepourl","applicationname","branch"})
  	public void setPlatformType(@Optional("NA") String jobName,@Optional("NA") String username,@Optional("NA") String password,@Optional("NA") String testusername,@Optional("NA") String testpassword,@Optional("NA") String LdapAdminpassword,@Optional("NA") String Mywizardinfra,@Optional("NA") String infrastructuretype,@Optional("NA") String categoryType,@Optional("NA") String LdapNewusername,@Optional("NA") String gitrepourl,@Optional("NA") String applicationname,@Optional("NA") String branch)
  	{
  		 testBase.categoryType=categoryType ;
  		 testBase.jobName=jobName;
  		 testBase.username=username;  		 
  		 testBase.Mywizardinfra=Mywizardinfra;
  		 testBase.infrastructuretype=infrastructuretype;
  		 testBase.ldapnewusername=LdapNewusername;
  		 testBase.gitrepourl=gitrepourl;
  		 testBase.applicationame=applicationname;
  		 testBase.branch=branch;
  		 
  		
  	}
  	
  	public static String getCategoryType()
  	{
  		return categoryType;
  	}
  	public static String getJobName()
  	{
  		return jobName;
  	}
  	public static String getUsername()
  	{
  		return username;
  	}
	public static String getTestUsername()
  	{
  		return testusername;
  	}
  	public static String getLdapUsername()
  	{
  		return ldapnewusername;
  	}
  	public static String getPassword()
  	{
  		return password;
  	}
	public static String getTestPassword()
  	{
  		return testpassword;
  	}
  	
  	public static String getLdapPassword()
  	{
  		return ldappassword;
  	}
  	
  	public static String getCategory()
  	{
  		return Mywizardinfra;
  	}
  	
  	public static String getInfrastructuretype()
  	{
  		return infrastructuretype;
  	}
  	public static String getgitrepourl()
  	{
  		return gitrepourl;
  	}
  	public static String getApplicationname()
  	{
  		return applicationame;
  	}
  	public static String getbranch()
  	{
  		return branch;
  	}
  	
  	
	
	@DataProvider(name="getTestData")
	public Object[][] getTestData(Method m) throws Exception
	{
		if (m.getName().equalsIgnoreCase("enterUser"))
		{
		Object[][] testObjArray=ExcelOp.getTableArray("Ldap");
		return testObjArray;
		}
		if (m.getName().equalsIgnoreCase("VerifyRocketchatInvalidLogin"))
			{
			Object[][] testObjArray=ExcelOp.getTableArray("RCGenInvalidLogin");
			return testObjArray;
			}		
		
		if (m.getName().equalsIgnoreCase("VerifyRocketchatValidLogin"))
			{
			Object[][] testObjArray=ExcelOp.getTableArray("RCGenValidLogin");
			return testObjArray;
			}
		
		if (m.getName().equalsIgnoreCase("RCGenBotIntents")|| m.getName().equalsIgnoreCase("RCBotIntents"))
			{
			Object[][] testObjArray=ExcelOp.getTableArray("RCBotValidIntents");
			return testObjArray;
			}
		
		if (m.getName().equalsIgnoreCase("RCGenvalidJiraIntents"))
		{
		Object[][] testObjArray=ExcelOp.getTableArray("RCBotValidJiraIntents");
		return testObjArray;
		}
		if (m.getName().equalsIgnoreCase("RCGenvalidGitIntents"))
		{
		Object[][] testObjArray=ExcelOp.getTableArray("RCBotValidGitIntents");
		return testObjArray;
		}
		if (m.getName().equalsIgnoreCase("RCGenvalidJenkinsIntents"))
		{
		Object[][] testObjArray=ExcelOp.getTableArray("RCBotValidJenkinsIntents");
		return testObjArray;
		}
		if (m.getName().equalsIgnoreCase("RCGenvalidKubernetesIntents"))
		{
		Object[][] testObjArray=ExcelOp.getTableArray("RCBotValidKubernetsIntents");
		return testObjArray;
		}
		if (m.getName().equalsIgnoreCase("RCGenValidMongoDbSearchIntents"))
		{
		Object[][] testObjArray=ExcelOp.getTableArray("RCBotValidMongoDbSearchIntents");
		return testObjArray;
		}
		
		if (m.getName().equalsIgnoreCase("RCGenValidClusterInfoIntents"))
		{
		Object[][] testObjArray=ExcelOp.getTableArray("RCBotValidClusterInfoIntents");
		return testObjArray;
		}
		if (m.getName().equalsIgnoreCase("RCGenBotInvalidIntents"))
		{
		Object[][] testObjArray=ExcelOp.getTableArray("RCBotInvalidIntents");
		return testObjArray;
		}
		
		if(m.getName().equalsIgnoreCase("RCBotValidLogin")|| m.getName().equalsIgnoreCase("RCBotLogin"))
			{
			Object[][] testObjArray=ExcelOp.getTableArray("RCBotValidLogin");
			return testObjArray;
			}
		
		else if(m.getName().equalsIgnoreCase("testMethodRCBotValidIntents"))
			{
			Object[][] testObjArray=ExcelOp.getTableArray("RCBotValidIntents");
			return testObjArray;
			}
		
	   if(m.getName().equalsIgnoreCase("eclipseCheValidLogin")|| m.getName().equalsIgnoreCase("eclipseChebranchcommit"))
		{
		Object[][] testObjArray=ExcelOp.getTableArray("EclipseCheValidLogin");
		return testObjArray;
		}
		if (m.getName().equalsIgnoreCase("jiraLogsCheck")|| m.getName().equalsIgnoreCase("jiraLogsCheckThroughSearchOption")||m.getName().equalsIgnoreCase("eclipseCheUrlthroughLinkFromGenChan"))
		{
		Object[][] testObjArray=ExcelOp.getTableArray("JiraCreation");
		return testObjArray;
		}
		if (m.getName().equalsIgnoreCase("LDAPUserCreation"))
		{
		Object[][] testObjArray=ExcelOp.getTableArray("LDAPLogin");
		return testObjArray;
		}
		if (m.getName().equalsIgnoreCase("invoketransaction"))
		{
		Object[][] testObjArray=ExcelOp.getTableArray("BlockChainNodeLogin");
		return testObjArray;
		}
		else
			return null;
	}
	
	@DataProvider(name="getLdapData")
	public Object[][] getLdapTestData(Method m) throws Exception
	{
	if (m.getName().equalsIgnoreCase("enterUser"))
	{
	Object[][] testObjArray=ExcelOp.getTableArray("LdapTestData");
	return testObjArray;
	}	
	else
		return null;
	}	
	

	@Parameters({"browserType", "appURL", "testappURL", "selectedTools","nodeURLs","selectedCartridges","subCategoryType","emailusername","emailpassword"})	
    @BeforeClass
		
			public void initialize(@Optional("NA") String browserType, @Optional("NA") String appURL, @Optional("NA") String testappURL, @Optional("NA") String selectedTools,@Optional("NA") String nodeURLs,@Optional("NA") String selectedCartridges,@Optional("NA") String subCategoryType,@Optional("NA") String emailusername,@Optional("NA") String emailpassword) throws IOException, InterruptedException

				{
		
		testBase.emailusername=emailusername ;
		
		testBase.testappURL=testappURL;
				
			//	if(BrowserConfig.getDriver()==null){
					
					//Split the tools string obtained from commandline or Jenkins param
					/*StringTokenizer tokenizer = new StringTokenizer(selectedTools, "\\s*,\\s*"); 
					while (tokenizer.hasMoreTokens()) 
						{ 
						System.out.println("Splitted Tool is  	"+tokenizer.nextToken());
						}*/
		             

					if(!selectedTools.equals("NA"))
					{
						System.out.println("selectedTools value received in initialize function is "+selectedTools);
					//Split the tools string obtained from commandline or Jenkins param
					toolsToTest=selectedTools.split("\\s*,\\s*");
					for(int i=0; i<toolsToTest.length; i++)  
					{
								System.out.println("\nSplitted tool to test is "+toolsToTest[i]);
								
					}
		
					}
					
					if(!nodeURLs.equals("NA"))
					{
						System.out.println("nodeURLs received in initialize function is "+nodeURLs);
						ipstoTest=nodeURLs.split("\\s*,\\s*");
						for(int i=0; i<ipstoTest.length; i++)  
						{
					    System.out.println("\n Node"+(i+1)+" URL is\n "+ipstoTest[i]);
						}
						//ExcelOp.loadExcel();
						BrowserConfig.setDriver(browserType, ipstoTest[0]);
					}
					
					if(!subCategoryType.equals("NA"))
					{
					//System.out.println("subcategory value received in initialize function is "+subCategoryType);
					subCategory=subCategoryType.split("\\s*,\\s*");
					//for(int i=0; i<subCategory.length; i++)  
				    //System.out.println("\n subCategories to test is "+subCategory[i]);
					}
					
					if(!selectedCartridges.equals("NA"))
					{
					System.out.println("selectedcartridges value received in initialize function is "+selectedCartridges);
					cartridgesToTest=selectedCartridges.split("\\s*,\\s*");
					for(int i=0; i<cartridgesToTest.length; i++)  
				    System.out.println("\nSplitted Cartridge to test is "+cartridgesToTest[i]);
					}
					
					if(!appURL.equals("NA"))
					{
						System.out.println("AppURL value received in initialize function is "+appURL);	
						testBase.appURL=appURL;
						//ExcelOp.loadExcel();
						Thread.sleep(3000);
						BrowserConfig.setDriver(browserType, appURL);
						
					}
			
				//	}
				
					
				}
    	public static String[] gettoolsToTest()
    	{
    		return toolsToTest;
    	}
    	
    	public static String[] getSubCategory()
    	{
    		return subCategory;
    	}
    	public static String[] getipsToTest()
    	{
    		return ipstoTest;
    	}
    	public static String[] getSelectedCartridgesToTest()
    	{
    		return cartridgesToTest;
    	}
    	
    	public static String getappURL()
    	{
    		return appURL;
    	}
		public static String getTestappURL()
    	{
    		return testappURL;
    	}
    	
    	public static String getEmailUsername()
    	{
    		return emailusername;
    	}
    	public static String getEmailPassword()
    	{
    		return emailpassword;
    	}
    	  	
    	
    	
    	  	
    
			
  //Initial Prerequisites for any test - Start report, capture report and flush report			
    	@Parameters({"browserType"})
    	@BeforeTest
			public void startReport(@Optional("NA") String browserType){
				//ExtentReports(String filePath,Boolean replaceExisting) 
				//filepath - path of the file, in .htm or .html format - path where your report needs to generate. 
				//replaceExisting - Setting to overwrite (TRUE) the existing file or append to it
				//True (default): the file will be replaced with brand new markup, and all existing data will be lost. Use this option to create a brand new report
				//False: existing data will remain, new tests will be appended to the existing report. If the the supplied path does not exist, a new file will be created.
				try {
					//String rptfile=System.getProperty("./test-output/ExtentReport.html");	
					//String rptfile=System.getProperty("user.dir") +"\\test-output\\ExtentReport.html";
					
					String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
					System.out.println("Current timestamp: "+timeStamp);
					
					//String rptfile="";
					//System.out.println("Current directory is"+System.getProperty("user.dir"));
					//String jenvworkspace="${env.WORKSPACE}";
					//System.out.println("Current directory is"+jenvworkspace);
					//String current = System.getProperty("user.dir");
					Thread.sleep(5000);//added by poojitha
					osystem=System.getProperty("os.name");
					System.out.println("Op System: "+osystem);
			        if(osystem.equals("Windows 10"))
			        {
			        	//local run
						String current = System.getProperty("user.dir");
						System.out.println("User directory is: "+current);
				        rptfile=current+"/test-output/"+"LocalRun"+timeStamp+browserType+"report"+".html";
			        }
					
			        else
			        {
			        	//Jenkins run test final
						String current = System.getenv("WORKSPACE");
				        System.out.println("Current working directory in Java : " + current);
				        rptfile=current+"/test-output/"+"LatestTestReport"+browserType+"report"+".html";

			        }

							
					//checking final changes			
					System.out.println("Reportfile is "+rptfile);
					extent = new ExtentReports (rptfile,true );
					
					extent
		            .addSystemInfo("Host Name", "Clove Platform")
		            .addSystemInfo("Environment", "SITs")
		            .addSystemInfo("User Name", "ClovePlatformUser")
					.addSystemInfo("Browser under test", browserType);
		            //loading the external xml file (i.e., extent-config.xml) which was placed under the base directory
		            //You could find the xml file below. Create xml file in your project and copy past the code mentioned below
		            //extent.loadConfig(new File(System.getProperty("user.dir"+"\\config\\extent-config241.xml")));
					extent.loadConfig(new File(System.getProperty("./lib/extent-config.xml")));
					
				}
				catch(Exception ex)
				{
				//	System.out.println("Error "+ex.getMessage());
				}
				
				//extent.addSystemInfo("Environment","Environment Name")
				
			}
			
			@BeforeMethod
			public void register(Method method)
			{
				String testName=method.getName();
				
				//System.out.println("classname flag in before method is"+Clove.Tests.Functional.PostProvisionSanityCartridges.classname);
				if(petclinic.classname)
				{
				for(int i=0; i<cartridgesToTest.length; i++) {
				if(testName.equals(cartridgesToTest[i]))
				logger=extent.startTest(testName);
				}
				
				if(testName.equals("JENKINS")||testName.equals("LDAP")||testName.equals("NEXUS")||testName.equals("SONAR")||testName.equals("ELKCLUSTER")||testName.equals("SELENIUM")||testName.equals("GITLAB")||testName.equals("LoadPlatformFromGitlabAndBuildPipeline"))
				logger=extent.startTest(testName);
				}
				//in other classed
				else
				logger=extent.startTest(testName);
				
			}
			
			
			@AfterMethod
			public void getResult(ITestResult result)
			{
				if(result.getStatus() == ITestResult.FAILURE){
					logger.log(LogStatus.FAIL, "Test Case Failed: "+result.getName());
					logger.log(LogStatus.FAIL, "Test Case Failed: "+result.getThrowable());
				}
				//else if(result.getStatus() == ITestResult.SKIP){
					//logger.log(LogStatus.SKIP, "Test Case Skipped: "+result.getName());
				//}
			else if(result.getStatus()==ITestResult.SUCCESS) {
					logger.log(LogStatus.PASS, "Test Case Passed: "+result.getName());
				}
				// ending test
				//endTest(logger) : It ends the current test and prepares to create HTML report
				extent.endTest(logger);
			}
			@AfterTest
			public void endReport(){
				// writing everything to document
				//flush() - to write or update test information to your report. 
		                extent.flush();
		                //Call close() at the very end of your session to clear all resources. 
		                //If any of your test ended abruptly causing any side-affects (not all logs sent to ExtentReports, information missing), this method will ensure that the test is still appended to the report with a warning message.
		                //You should call close() only once, at the very end (in @AfterSuite for example) as it closes the underlying stream. 
		                //Once this method is called, calling any Extent method will throw an error.
		                //close() - To close all the operation
		                extent.close();   
		               
		    }
			
			@AfterClass
			public void endDriver()
			{
				//WebDriver driver = SockShopMaven.Generic.TestBase.BrowserConfig.getDriver();
				//driver.quit();
			}
			
			/*@Test
			@Parameters({"platformType"})
			public void PostProvisionSanityTest(String platformType) throws InterruptedException
			//to be included and is applicable only for Post provision sanity test
			{
				System.out.println("Entered sanity root");
				System.out.println("Test to be run is for "+platformType+" platform");
				
				switch(platformType)
				{
				case "Microservice": 
					
					System.out.println("Testing "+platformType+" platform");
					PostProvisionSanityCartridgeMicroservice testMicroservice = new  PostProvisionSanityCartridgeMicroservice();
					testMicroservice.MicroserviceTest_Jenkins();
					testMicroservice.MicroserviceTest_Kibana();
					testMicroservice.MicroserviceTest_LDAP();
					testMicroservice.MicroserviceTest_Nexus();
					testMicroservice.MicroserviceTest_Rocketchat();
					testMicroservice.MicroserviceTest_Selenium();
					testMicroservice.MicroserviceTest_Sonar();
					testMicroservice.MicroserviceTest_Stackstorm();
					
					break;
					
				case "Selectedtools": 
					System.out.println("Testing "+platformType+" platform");
					PostProvisionSanitySelectedTools testSelectedtools = new  PostProvisionSanitySelectedTools();
					testSelectedtools.selectedToolsTest();
					break;
					
				case "Defaulttools": 
					System.out.println("Testing "+platformType+" platform");
					PostProvisionSanityDefault testDefaulttools = new  PostProvisionSanityDefault();
					testDefaulttools.DefaultToolsTest_Jenkins();
					testDefaulttools.DefaultToolsTest_LDAP();
					
					break;
					
				case "Blockchain": 
					System.out.println("Testing "+platformType+" platform");
					PostProvisionSanityBlockChain testBlockchain = new  PostProvisionSanityBlockChain();
					testBlockchain.invoketransaction();
					break;
					
				}
				
			}*/
			
			 public static class Verifier extends Assertion {
		//verify and report all assertions 
				 StringBuilder sb;
		           private final Map<AssertionError, IAssert<?>> m_errors = Maps.newLinkedHashMap();
		   @Override
		           protected void doAssert(IAssert<?> a) {
		               onBeforeAssert(a);
		               try {
		                   a.doAssert();
		                   onAssertSuccess(a);
		               } catch (AssertionError ex) {
		                   onAssertFailure(a, ex);
		                   m_errors.put(ex, a);
		               } finally {
		                   onAfterAssert(a);
		               }
		           } //doAssert closes
		   
		   public void assertAll() {
               if (! m_errors.isEmpty()) 
               {
                     sb = new StringBuilder("The following asserts failed:");
                     boolean first = true;
                     for (Map.Entry<AssertionError, IAssert<?>> ae : m_errors.entrySet()) {
                            if (first) {
                                  first = false;
                            } else {
                                  //sb.append(System.getProperty("line.separator"));//separator
                                  sb.append("##");
                                  //sb.append(System.lineSeparator());
                            }
                            //sb.append(System.getProperty("line.separator"));
                            //sb.append("\n");
                            //sb.append(System.lineSeparator());
                            System.out.println();
                            sb.append(ae.getKey().getMessage());
                     }// for closes
                     
                               
                 System.out.println("key :"+sb.toString());
                 String errorMsg=sb.toString();
	             int count=0;
	             int errlength = errorMsg.length();
	             int exp1,butFnd1,exp2;
	             String output1,output2;
		         count = (errlength - errorMsg.replace("expected","").length())/8;
		         logger.log(LogStatus.INFO, "No: of errors = "+count);
		         //System.out.println("count :"+count);   
		         exp1=0;
		         butFnd1=0;    
		          
		         for(int i=0;i<count;i++)
		                  {
		                         
		                         exp1 =errorMsg.indexOf("expected",exp1)+1;
		                         butFnd1=errorMsg.indexOf("but found",butFnd1)+1;
		                         exp2 =errorMsg.indexOf("expected",exp1+1);
		                         
		                        /* System.out.println("exp1 :"+exp1); 
		                         System.out.println("butFnd1 :"+butFnd1); 
		                         System.out.println("exp2 :"+exp2); */
		
		                         output1 =errorMsg.substring(exp1+8, butFnd1-1);
		                        // System.out.println("output1 :"+output1); 
		                         
		                         if(exp2>0)
		                         	  {
		                               output2 =errorMsg.substring(butFnd1+9,exp2-1);
		                        //       System.out.println("output2 :"+output2); 
		                              }
		                         else {  
		                         output2 =errorMsg.substring(butFnd1+9);
		                         //System.out.println("output2 :"+output2); 
		                              }
		                         logger.log(LogStatus.FAIL, "Found"+ output2 + "instead of "+output1);
		                        // System.out.println("Error Reported:"+ "Found "+ output2 +"instead of "+ output1);
		                  }//for closes
		           // }//if closes 
		          throw new AssertionError(sb.toString());
           }//outer if () closes
   		}//assertAll() closes
	}//subclass closes
}//testBase class closes
                                  
