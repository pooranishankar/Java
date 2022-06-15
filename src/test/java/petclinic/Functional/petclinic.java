package petclinic.Functional;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import petclinic.Generic.TestBase.*;
import petclinic.PageObjMethods.PetclinicPage;

public class petclinic extends testBase {
	public static boolean classname = false;
	private WebDriver driver = null;

	@BeforeClass
	public void initSetUp1() throws IOException, InterruptedException {
		driver = BrowserConfig.getDriver();
		try {
			if (driver == null)
				System.out.println("---Driver not found---");
	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("chrome driver version is : " + driver);

	}

	@Test(priority = 0)
	public void PetClinicTest() throws InterruptedException, IOException {

		PetclinicPage petclinicPage = PageFactory.initElements(driver, PetclinicPage.class);
		petclinicPage.untitled();
	}
}
