# CS180-L22-Team 3

### Instruction on how to compile and run the program
1. User wants to create an account

Hit the Run button and write 1 to the program.

Then the user is prompted to enter username, password. 

Once the user create account succeesfully, they can not edit their username.

After that, the user is prompted to enter age, gender, nationality, job, and hobby.

Then the program goes back to the main menu to let the user create account or log in or exit the app.

2. User wants to log in

Hit the Run button and write 2 to the program.

Then the user is prompted to enter username and password for log in. 

If login successfully, the program will show the Option Menu with 9 options:

1. View that user profile
  
2. Edit that user profile

3. Delete their account

4. Add friend

5. Remove friend

6. Block friend

7. Unblock friend

8. Send message

9. Log out

If the user writes down 1 or 2, the program will prompted the user to enter the information that they want to see or edit, and the program comes back to the Option Menu again.

If the user writes down 3, 4, 5, 6, 7 or 8, the program will prompted the user to search for the specific username and check if they can do that action. After that, the program comes back to the Option Menu.

If the user writes down 9, the program will exit from the Option Menu and goes to the Main Menu where user can Create account, Log in or Exit the app.


3. User wants to exit the app

Hit the Run button and write 3 to the program. The program will stop.

For any time that the user enters any wrong input or wrong command, the program will ask them until the user do the valid input or right command.

### Profile.java <br/>
Creates a new profile object with username, password, age, gender, nationality, job and hobby. Includes get/set methods to modify or return given attributes.
The foundation of the database.
<br/>
### UserAccount.java <br/>
Creates a new account object with given profile object with a list of friends and blocked users. UserAccount is dependant on Profile.java. Getter and setter methods to modify and return account attributes such as blocked users and friends.
<br/>
### Method.java <br/>
Contains boolean methods crucial to the function of the database system such as block user and add friend. Depends on Profile.java, future classes more integral to the database system will depend on this class.
<br/>
### Database.java <br/>
<br/>
The framework for the database system. Creates new database objects using all known accounts. Dependant on Profile and UserAccount. Methods include means to modify accounts on a large scale, including wiping all accounts and returning all accounts.
<br/>

### Message.java <br/>
<br/>
Framework for users to send, delete and print history messages . Utilizes buffered reader to write timestamped messages to Messages.txt file. Includes message blocking: if user "A" attempts to send message to user "B", while B has user A blocked the message still send and storage in the message history but can not be seen by user "B". Includes gourp message: if use "A" has a selected group members {"B", "C" , "D"} and all members should in "A's" friend lists, {"B", "C" , "D"} can see the message from "A" at same time.
<br/>

### LogIn.java <br/>
<br/>
Class facilitating account creation, deleting and logging in. 
Dependent on Database>UserAccount>Profile. Checks if passwords are valid before allowing login, modifies server database including master list of usernames and passwords to create and delete accounts upon user request.  
<br/>

### SocialMedia.java <br/>
<br/>
Drives functionality of supported classes before GUI integration in phase 3. Includes text based menu system allowing users to create, login, delete, and modify accounts utilizing earlier documented classes.  
<br/>