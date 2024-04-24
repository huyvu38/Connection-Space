# CS180-L22-Team 3

Huy Vu <Submitted Vocareum Work Phase 3>

<Submitted Presentation Phase 3>

<Submitted Report Phase 3>
### Instruction on how to compile and run the program

The server in Server.java needs to be run first so that the client can connect to the server and using the app.

First, the user clicks the Run button in Client.java.

After the user connects with the server, the Main Menu will appear with 2 options:

1. Create an account
2. Log in

Main Menu Option 1: user wants to create an account

Write 1 to the program.

Then the user is prompted to enter username, password, age, gender, nationality, job, and hobby.

The server will then check every information of the user is in the right format and the username is valid. After that, the client will receive the message if they create account successfully.

If the user create account successfully, they cannot edit their username later.

Then the program goes back to the main menu to let the user create account or log in.

Main Menu Option 2: User wants to log in

Write 2 to the program.

Then the user is prompted to enter username and password for log in.

If the user login fail, the program will go back to the Main Menu.

If the user login successfully, the program will show the Option Menu with 9 options:

1. View that user profile (probably already display in the frame??)

2. Edit that user profile

3. Action

4. Send message

5. Search user

6. Log out

If the user writes down 1 the program will prompt the user to enter the information that they want to view from their profile. (probably delete)

If the user writes down 2 the program will prompt the user to enter the information that the user is allowed to edit and let the user enter the new information. The server will check if the new information is in the right format and send the edit result to the client.

If the user writes down 4, the program will prompt the user to enter the word for searching and the server will send back a list of username that contains the word to the user.


If the user writes down 3, 4, 5, 6, 9 the program will prompt the user to enter the username of other account and send the result of the specifc action to the client.

If the user writes down 4, the program will allow user to choose 1 of these 3 options :

1. Send Message to specific user
2. Send message only to friends
3. Print history message
   Then the user can delete any messages that they want.

If the user writes down 6, the program will exit from the Option Menu and goes to the Main Menu where user can create account or log in or exit the app.

### UserAccount.java <br/>
Creates a new account object with given profile object with a list of friends and blocked users. UserAccount is dependent on Profile.java.
Getter and setter methods to modify and return account attributes such as blocked users and friends.
Extends the functionality of 'Profile' objects incorporating social networks.
<br/>
#### Methods
Create new UserAccount with Profile and list of friends/blocked users.
<br/>
Methods to add or remove users to lists, as well as retrieve the lists for purposes such as messaging.
<br/>
### Profile.java <br/>
Creates a new profile object with username, password, age, gender, nationality, job and hobby. Includes get/set methods to modify or return given attributes.
The foundation of the database.
The foundation of the database. This class is crucial for the managing of users within the database, serving as the smallest unit of database information.
#### Methods
Constructors to initialize new profiles
<br/>
Get/Set methods to modify and return attributes inherent to
each profile object
<br/>

### Database.java <br/>
The framework for the database system. Creates new database objects using all known accounts. Dependent on Profile and UserAccount.
Methods include means to modify accounts on a large scale, including wiping all accounts and returning all accounts. Provides comprehensive ability for accessing and modifying profiles.
#### Methods
Create and delete accounts using Profile objects
<br/>
The framework for the database system. Creates new database objects using all known accounts. Dependant on Profile and UserAccount. Methods include means to modify accounts on a large scale, including wiping all accounts and returning all accounts.
<br/>
Query data on large scale by returning all accounts

### Server.java <br/>

A class representing the server that allows client to connect, processing of data and update the data after the specific actions of the client. 
Utilizes java socket to create socket-client connections. All data is stored locally within server. 

#### Methods

Username Validation: Ensures usernames are unique and meet formatting standards.<br/>
Password Checks: Verifies password length for security and matches passwords for login.<br/>
Create account: Check if user enter unique username and every information in the profile meet formatting standards.<br/>
Login Verification: Authenticates user logins by matching usernames and passwords with database records.<br/>
Add/Delete/Block/Unblock User: Boolean method to check if the client can do that action. If the method returns true, store the update data to AllUserAccount.txt
Assure message is valid: Checks that messages are being sent to valid users who exist in the database.
Message Operations: Send individual or group messages, with options to delete and review message history.<br/>
Privacy Controls: Block specific users, hiding their messages from the recipient while still logging them.<br/>
Persistent Logging: Use a buffered reader to timestamp and store messages, ensuring a reliable historical record.<br/>

### Client.java <br> //Fix that
Acts as the user interface for the social media platform. Utilizes java socket for client-server connections. See above section on how to run program
for instructions on using client.

### RunLocalTest.java <br>
Tests each file's methods utilizing junit 4. Tests include: Decleration test, Profile test, User account test, Database test and functions in server.

### AllUserAccount.txt <br/>
The file that store profile, friendlist, blocklist of each user.

Format: [username] [password] [age] [gender] [nationality] [job] [hobby];FriendList:[list of friends];BlockList:[list of block users]

Username must be at least 4 characters.

Password must be at least 6 characters.

Age must be a positive number.

User only choose gender from the following options : Male, Female, Other.

Every information in the Profile of the user can not contain any spaces or semicolons.

### Message.txt <br/>
The file that store every message between each user.

Format: [conversationID],[DeletedMessage],[ConversationTime],[Sender username],[Receiver username],[if message blocked],[message content]

### Test case <br/>


