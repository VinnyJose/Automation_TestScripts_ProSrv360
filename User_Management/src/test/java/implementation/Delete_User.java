package implementation;

import java.util.Map;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;
import genericLibraries.iConstantPath;
@Listeners

public class Delete_User extends BaseClass {
@Test
    public void delete_User()
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
	String userStatus="Active";
	String current_UserStatus=useraccess.getStaus(userName,driver);
	System.out.println("Current user status :"+current_UserStatus);
	if(current_UserStatus.equals(userStatus))
	{
		useraccess.set_TableRow(driver,userName);
		sassert.assertTrue(edituser.getHeader().contains("Edit User"));
		edituser.setDelete();
		edituser.setYes();
		edituser.setClose(driver);
		excel.updateSingleCellInExcel("TestData", "Delete User", "Pass", iConstantPath.EXCEL_FILE_PATH);
	}
	else
	{
		excel.updateSingleCellInExcel("TestData", "Delete User", "No user found", iConstantPath.EXCEL_FILE_PATH);
	}
	sassert.assertAll();
	}

}
