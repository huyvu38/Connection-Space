# CS180-L22-Team 3

Huy Vu <Submitted Vocareum Work Phase 3>

<Submitted Presentation Phase 3>

<Submitted Report Phase 3>
### Instruction on how to compile and run the program

The server in Server.java needs to be run first so that the client can connect to the server and using the app.

First, the user clicks the Run button in Client.java.

After the user connects with the server, the "Main Menu Frame" will appear with 2 options:

1. Create an account

2. Log in

<img width="438" alt="Screenshot 2024-04-25 225322" src="https://github.com/huyvu38/CS180-Team/assets/144382505/b50cb020-0917-4b63-beb3-2605eb8310c4">


Main Menu Option 1: User clicks to the "Create account" button

<img width="438" alt="Screenshot 2024-04-25 225322" src="https://github.com/huyvu38/CS180-Team/assets/144382505/b2ebe12c-e5f1-4b83-921c-a55c4fc58fde">


The "Create Account Frame" will appear and the user is prompted to enter username, password, age, gender, nationality, job, and hobby.

The server will then check every information of the user is in the right format and the username is unique. After that, the client will receive the message if they create account successfully or not. Then the program goes back to the "Main Menu Frame".

If the user creates account successfully, they cannot edit their username later.


Main Menu Option 2: User clicks to the "Log in" button



Then the user is prompted to enter username and password for log in.

If the user login fail, the program will go back to the Main Menu Frame.

If the user login successfully, the program will show the User Frame.

The top left corner will display the friend list and the top right corner will display the block list.

The user can have some following option:

1. Edit profile

   After click to the edit profile button, the editProfile Frame will appear and the user is not allowed to change their username.

2. Action

   After click the "Action" button, the Action Frame will appear with 5 buttons : Add friend, Delete friend, Block user, Unblock user, view other user profile.

   The client first need to type the username of other people and click to the any button that they want. The server then will check if that client can do that action and update to the database.

   For the view other user profile, if the client enter the username that in the database and not in the block list, another Frame will appear and let them view another user's information like age, gender, nationality, job, hobby.

3. Search user

4. Send message

5. Log out

   The client will go back to the Main Menu Frame where they can log in or create account.

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

### Client.java <br> 
Acts as the user interface for the social media platform. Utilizes java socket for client-server connections and invokes the Main Menu Frame when the client connects to the server.

### RunLocalTest.java <br>
Tests each file's methods utilizing junit 4. Tests include: Decleration test, Profile test, User account test, Database test and functions in Server.

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

Test 1 : Create account

Test 2 : Log in failure

Test 3:  Log in successful

Test 4: Edit profile failure

Test 5: Edit profile successful

Test 6: Add friend 

Test 7: Unfriend

Test 8: Block friend

Test 9: Unblock friend

Test 10: Search user

Test 11: View other user profile

Test 12: Send message


