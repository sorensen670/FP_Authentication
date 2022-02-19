//A class that represents an employee.
//This class is used in the program FP_Sorensen_Mike.
import java.util.*;
public class Employees {
	//Declare instance variables for
	//objects of the Employees class
    private String userName;
    private String password;
    private String userID;
	//Constructor method to initialize instance
	//variables
	Employees()
    {
        userName = "none";
        password = "none";
        userID = "none";
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
	public String getUserName() {
        return userName;
	}
	public void setPassword(String password) {
        this.password = password;
    }
	public String getPassword() {
        return password;
    }
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserID() {
		return userID;
	}
	
}
  