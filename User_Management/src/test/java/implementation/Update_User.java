package implementation;

import java.util.Map;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;

@Listeners
public class Update_User extends BaseClass{
@Test
public void update_UserDetails()
{
	SoftAssert sassert= new SoftAssert(); 
	home.setadmin_button();
	home.setuserAccess_button();
	Map<String,String> map=excel.getDataBasedOnKey("TestData","Add User");
	useraccess.setActive();
	useraccess.setSelection_fromActive(web,driver);
	String firstName=map.get("First Name");
	String lastName=map.get("Last Name");
	String userName = firstName + " " + lastName ;
	useraccess.setSearchfield(userName);
	String userStatus="Inactive";
	String current_UserStatus=useraccess.getStaus(userName,driver);
	System.out.println("Current user status :"+current_UserStatus);
	if(current_UserStatus.equals(userStatus))
	{
		useraccess.set_TableRow(driver,userName);
		edituser.setReactivate();
		edituser.setClose(driver);
		useraccess.clickonSearch();
	}
	useraccess.set_TableRow(driver,userName);
	sassert.assertTrue(edituser.getHeader().contains("Edit User"));
	edituser.setEdit();
	Map<String,String> map1=excel.getDataBasedOnKey("TestData","Update User");
	edituser.setMobile(map1.get("Mobile Number"),driver);
	edituser.setSave(driver);
	edituser.setClose(driver);
	sassert.assertAll();
	
	
}


	
}


