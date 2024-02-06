package implementation;

import java.util.Map;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;
import genericLibraries.iConstantPath;
@Listeners

public class Add_NewUser extends BaseClass {
	@Test
	public void add_NewUser()
	{
		SoftAssert sassert= new SoftAssert(); 
		home.setadmin_button();
		home.setuserAccess_button();
		sassert.assertTrue(useraccess.getHeader().contains("User Details"));
		useraccess.setcreate_newUser_button();
		sassert.assertTrue(adduser.getHeader().contains("Add User"));
		Map<String,String> map=excel.getDataBasedOnKey("TestData","Add User");
		String company=map.get("Company");
		adduser.setCompany_TextField(web, company,driver);
		String user_type=map.get("User Type");
		adduser.setUserType_TextField(web, user_type);
		String role=map.get("Role");
		adduser.setRole_TextField(web, role);
		adduser.setUser_Details(map.get("First Name"),map.get("Last Name"),map.get("Email"),map.get("Mobile"),map.get("User Code"));
		adduser.setSave();
		adduser.setClose();
		String firstName=map.get("First Name");
		String lastName=map.get("Last Name");
		String userName = firstName + " " + lastName ;
		useraccess.setSearchfield(userName);
		if(useraccess.getUserName_fromTable().contains(userName))
		{
			excel.updateSingleCellInExcel("TestData", "Add User", "Pass", iConstantPath.EXCEL_FILE_PATH);
		}
		sassert.assertAll();
		
        
		
	}

}
