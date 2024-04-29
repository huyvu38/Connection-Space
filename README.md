# CS180-L22-Team 3

Huy Vu <Submitted Vocareum Work Phase 3>

Yanxin Yu <Submitted Presentation Phase 3>

Huy Vu <Submitted Report Phase 3>

### Instruction on how to compile and run the program

The server in Server.java needs to be run first so that the client can connect to the server and use the app.

First, the user clicks the Run button in Client.java.

After the user connects with the server, the "Main Menu Frame" will appear with two options:

1. Create account

2. Log in


Main Menu Option 1: The user clicks on the "Create account" button.

The "Create Account Frame" will appear, and the user is prompted to enter username, password, age, gender, nationality, job, and hobby.

The server will then check that every information about the user is in the right format and the username is unique. After that, the client will receive a message if they created an account successfully or not. Then the program goes back to the "Main Menu Frame".

If the user creates an account successfully, they cannot edit their username later.


Main Menu Option 2: The user clicks on the "Log in" button.

The "Log in Frame" will appear, and the user will be prompted to enter username and password to log in. The server will check if the username and password match the database, and the client will receive the message if they log in successfully or not.

If the user logs in fail, the program will go back to the "Main Menu Frame".

If the user logs in successfully, the program will display the "User Frame" with the title "Connection Space".

The user will see some of the following buttons

1. Save

   The client writes to the text field about the new information, then clicks on the "Save" button and the server will check if the new information is in the correct format.

   If the client enters the wrong format of information, their profile details will be set back to the previous information.


2. Get friend list

   After clicking that button, the client can see all of their friends in the drop-down list.


3. Get block list

   After clicking that button, the client can see all the users that have been blocked in the drop-down list.

4. Search

  The client writes the text and the server will find all of the username that contain the text. The result will appear in the drop-down list.

5. Action

   After clicking to the "Action" button, the Action Frame will appear with some following buttons :

   1. Add friend/Delete friend/Block user/Unblock user
   
    The client first needs to type the username of other people and click to the any button that they want. The server will then check if that client can do that action and update any important changes to the database.

   2. View other user profile
   
   The client first needs to type the username, and another Frame will appear if no users block each other. Then the client can view another user's information, like age, gender, nationality, job, or hobby.
   
   3. Send Message
   
   In the messaging system, a user types their message into the message bar and clicks the "send" button. The sent message, along with any previous messages, is displayed in the message display area. Each message has an associated conversation ID, which is also displayed. If a user enters a specific conversation ID, they will no longer be able to see the messages from that conversation.

If a user attempts to send a message to another user who is on their block list, the message will not be sent. Instead, the message display area will show "No message yet." Users can exit the messaging dialog by clicking the "exit" button, which will return them to the main user frame.
   

   4. Log out

   The client will go back to the "Main Menu Frame" where they can log in or create account.


### Test case <br/>

Test 1 : Create account

 1. Click to the "Create Account" button

 2. For username, write "george34" 

 3. For password, write "abcdef"

 4. For age, write "20" 

 5. For gender, choose "Male"

 6. For nationality, write "China"

 7. For job, write "student" 

 8. For hobby, Write "food"

 9. Click "Enter" button

   Expected result : Message "Create account successfully" and return back to the "Main Menu Frame"


Test 2 : Log in failure

1. Click to the "Log in" button

2. For username, write "vu33"

3. For password, write "111111"

4. Write the following information and click "Enter"

   Expected result: Message "Log in failure" and return back to the "Main Menu Frame"


Test 3:  Log in successful

1. Click to the "Log in" button

2. For username, write "vu28"

3. For password, write "123456"

4. Click "Enter" button

  Expected result : The "User Frame" will appear

Test 4 to 11 is after the user "vu28" log in successfully and the user "george34" create account successfully.

Test 4: Edit profile failure

   1. Write "abc" in the text field next to "Age"

   2. Click "Save" button

    Expected result: Message "Edit profile failure"


Test 5: Add friend 

   1. Click to "Action" button

   2. Write "Yanxin171" to the text field

   3. Click to "Add friend" button

   Expected result: Message "Add friend successfully" and return to "User Frame"

   4. Click "Get friend list" button

   Expected result: The new friend list should include "Yanxin171".

Test 6: Unfriend

   1. Click to "Action" button

   2. Write "josh12" to the text field

   3. Click to "Delete friend" button

   Expected result: "You can not unfriend that user" and return back to "User Frame" (Can not add "josh12" because that user does not appear in the database.)

Test 7: Block friend

   1. Click to "Action" button

   2. Write "george34" to the text field

   3. Click to "Block user" button

   Expected result: Message "Block successfully" and return to "User Frame"

   4. Click "Get block list" button

   The new block list should include "george34".


Test 8: Unblock friend

   1. Click to "Action" button

   2. Write "george34" to the text field

   3. Click to "Unblock user" button

   Expected result: Message "Unblock successfully" and return to "User Frame"

   4. Click "Get block list" button

   Expected result: The new block list should not include "george34".

Test 9: Search user

   1. Write "e" to the text field

   2. Click to the "Search" button

   Expected result : Find the following usernames : "george23", "Archie", "george34"

Test 10: View other user profile

   1. Click to the "Action" button

   2. Write "Archie" to the text field

   3. Click to the "View other user prorfile"

   4. Click to the "Hobby" button

   Expected result: Message "The hobby of that user is Polo"
   
Test 11: Send message and delete message.

   1. Click to the "Action" button

   2. Write "Yanxin171" in the text field

   3. Click to the "Send message" button

   4. Write "How are you?" to the text filed next to "Exit message" button

   5. Click to the "Send" button

   Expected result for send message: Display the conversationID 27 and 28

   6. Write "28" to the text field next to the "Delete selected message" button

   7.Click to the "Delete selected message" button

   Expected result for delete message : Only display the conversationID 27 

   8. Click "Exit message" button and return to "User Frame"

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
