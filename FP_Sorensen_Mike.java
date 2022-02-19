// File name: [FP_Sorensen_Mike]
// Mike Sorensen
// IS 345 FP
// Description: This program asks the user to enter a
// user name and password. If the user name entered
// matches one on record, the program proceeds to ask
// for the corresponding password. In the case that
// either the user name or password entered does not
// match those on record, the application alerts the
// user of invalid entry and displays all records.
// If a valid user name and correct password are
// entered, the program displays the user's password,
// userID, and all the objects the user can access.
//------------------------------------------------------------
import java.util.*;
public class FP_Sorensen_Mike
{
	public static void main(String[] args)
	{
		//Arrays to hold usernames, passwords, user IDs, object access rules,
		// and names of those accessible objects
		String [][] userPassData = {{"1","Redwan","Redwan12"},
							        {"2","Nancy","Nancy12"},
							        {"3","Mark","Mark12"}};
									
		String [][] userObjects = {{"1","Add"},
							       {"2","Delete"},
							       {"3","Edit"},
							       {"4","Read"},
							       {"5","Write"}};
								   
		String [][] objectAccess = {{"1","1","1"},
							        {"2","1","2"},
							        {"3","1","3"},
							        {"4","1","4"},
							        {"5","1","5"},
									{"6","2","1"},
									{"7","2","4"},
									{"8","3","1"},
									{"9","3","3"},
									{"10","3","4"},
									{"11","3","5"}};
		//Create scanner object to get user input
		Scanner keyboard = new Scanner(System.in);
		//Create a new object of the Employees class
		//to hold user name, password, and user ID
		Employees currentUser = new Employees();
		//Prompt user to enter a user name
		System.out.print("Enter UserName:");
		//Call the method to set the user name for currentUser
		currentUser.setUserName(keyboard.nextLine());
		
		//Create and initialize variables to indicate
		//valid user name and password combinations
		int userNameFound = 1;
		int passwordFound = 1;
		
			//Loop through the first array containing user names,
			//passwords, and userIDs to first confirm or refute
			//the user name entry
			for (int j = 0; j < userPassData.length; ++j)
			{
				//If the username is found change the flag variables
				//to indicate validity
				if(userPassData[j][1].equals(currentUser.getUserName()))
				{
					userNameFound = 2;
				}
				
			}
			
			//If the user name entry does not match any records
			//notify the user and print all records
			if (userNameFound == 1)
			{
				System.out.println("User name entered doesn't match our records; try again");
				System.out.println();
				//Call the print methods to display records to
				//the user
				printArray(userPassData);
				printArray(userObjects);
				printArray(objectAccess);
				//printUserObjects(userObjects);
				//printObjectAccess(objectAccess);
			}
			//If the user name is valid, continue with
			//gathering the user's password
			if (userNameFound == 2)
			{
				System.out.print("Enter Password:");
				//Call the method to set password for currentUser
				currentUser.setPassword(keyboard.nextLine());
				System.out.println();
				
				//Loop through the first array again to determine if
				//the password entered is correct for a valid user name
				for (int j = 0; j < userPassData.length; ++j)
				{
					//If the password matches the user name in that
					//row of the first table, change the passwordFound
					//flag to reflect a correct user authentication
					if(userPassData[j][2].equals(currentUser.getPassword()) && userPassData[j][1].equals(currentUser.getUserName()))
					{
						passwordFound = 2;
					}
				}
				//If the password does not match that on record
				//for the valid user name, notify the user and
				//print all records
				if(passwordFound == 1)
				{
						System.out.println("Password entered doesn't match our records; try again");
						System.out.println();
						//Call the print methods to display records to
						//the user
						printArray(userPassData);
						printArray(userObjects);
						printArray(objectAccess);
				}
				
				//If the password does match that on record for
				//the corresponding user name, set the validated user's
				//userID from the same row of the first table
				if(passwordFound == 2)
				{
					//Loop again through the first table to set the
					//userID for currentUser
					for (int j = 0; j < userPassData.length; ++j)
					{
						if(userPassData[j][2].equals(currentUser.getPassword()) && userPassData[j][1].equals(currentUser.getUserName()))
						{
							//Create a String to hold the userID from row j
							//in column index 0
							String iD = userPassData [j][0];
							//Call the method to set userID for currentUser
							currentUser.setUserID(iD);
							
							//Display the validated user's password and userID
							System.out.println("Password :-)" + "\t" + currentUser.getPassword());
							System.out.println("UserID is :-)" + "\t" + currentUser.getUserID());
							System.out.println();
							// call printAccessibleObjects method to print the user's access objects
							printAccessibleObjects(userObjects, objectAccess, currentUser);
						}
					}
				}
				
			}
			
	
	
	}
	//Method prints any of the three tables taking the
	//name of the array to be printed as a parameter
	public static void printArray(String [][] arrayName)
	{
		for (String[] array : arrayName) {
            for (String element : array) {
                System.out.print(element);
                System.out.print("\t");
            }
            System.out.println();
        }
		System.out.println();
	}

	//Method to get a list of accessible objects from table 3 (objectAccess [][])
	//so we can use this arraylist in the printAccessibleObjects method
	public static ArrayList<String> getAccessibleObjects(String [][] objectAccess, Employees currentUser) {
		//Create a String to hold userID in a form
		//we can use to compare it to elements in
		//the second column index of the second 
		//table (object access [][])
		String user = currentUser.getUserID();
		//Create the arraylist to hold objectIDs of
		//objects available to currentUser
		ArrayList<String> access = new ArrayList<String>();
		
		//Step through the array to get applicable
		//objectIDs added to the arraylist
		for (int i=0; i<objectAccess.length; i++) {
			if(objectAccess[i][1].equals(user))
			{
				access.add(objectAccess[i][2]);
			}
		}
		//Return this new arraylist
		return(access);
			
	}
	
	public static void printAccessibleObjects(String [][] userObjects, String [][] objectAccess, Employees currentUser) {
		// call getAccessibleObjects method and assign it to an arraylist
		ArrayList<String> objects = getAccessibleObjects(objectAccess, currentUser);
		//convert the arraylist to an array so we can compare its contents
		//to table 2 (userObjects [][])
		String [] objectIDs = objects.toArray(new String[objects.size()]);
		
		//Step through the second table (userObjects [][])
		//and the new objectIDs array we just created
		//comparing column index 0 of each row to
		//each element in objectIDs
		for(int i=0; i<userObjects.length; i++) {
			for(int j=0; j<objectIDs.length; j++) {
				if(userObjects [i][0].equals(objectIDs [j])) {
					//Print matching elements to display currentUser's
					//accessible objects
					System.out.println("Object access is " + userObjects [i][1]);
				}
			}
		}
	}
	
	

}