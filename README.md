# CS180-L22-Team 3

Huy Vu <Submitted Vocareum Work Phase 3>

<Submitted Presentation Phase 3>

<Submitted Report Phase 3>

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

### Instruction on how to compile and run the program

The server in Server.java needs to be run first so that the client can connect to the server and use the app.

First, the user clicks the Run button in Client.java.

After the user connects with the server, the "Main Menu Frame" will appear with two options:

1. Create account

2. Log in

<img width="438" alt="Screenshot 2024-04-25 225322" src="https://github.com/huyvu38/CS180-Team/assets/144382505/b50cb020-0917-4b63-beb3-2605eb8310c4">


Main Menu Option 1: The user clicks on the "Create account" button.

<img width="438" alt="Screenshot 2024-04-25 225322" src="https://github.com/huyvu38/CS180-Team/assets/144382505/b2ebe12c-e5f1-4b83-921c-a55c4fc58fde">


The "Create Account Frame" will appear, and the user is prompted to enter username, password, age, gender, nationality, job, and hobby.

The server will then check that every information about the user is in the right format and the username is unique. After that, the client will receive a message if they created an account successfully or not. Then the program goes back to the "Main Menu Frame".

If the user creates an account successfully, they cannot edit their username later.


Main Menu Option 2: The user clicks on the "Log in" button.

<img width="362" alt="image" src="https://github.com/huyvu38/CS180-Team/assets/144382505/50994271-352d-439b-aa56-9f91e3380a45">

The "Log in Frame" will appear, and the user will be prompted to enter username and password to log in. The server will check if the username and password match the database, and the client will receive the message if they log in successfully or not.

If the user logs in fail, the program will go back to the "Main Menu Frame".

If the user logs in successfully, the program will display the "User Frame" with the title "Connection Space".

<img width="504" alt="Screenshot 2024-04-25 233412" src="https://github.com/huyvu38/CS180-Team/assets/144382505/b08a8f39-0a7c-4543-905f-e2a741a95e23">

The user will see some of the following buttons

1. Save

   <img width="141" alt="Screenshot 2024-04-25 233612" src="https://github.com/huyvu38/CS180-Team/assets/144382505/eb2ccc2b-a436-4e7a-8d69-87bdedcd640e">

   The client writes to the text field about the new information, then clicks on the "Save" button and the server will check if the new information is in the correct format.

   If the client enters the wrong format of information, their profile details will be set back to the previous information.


2. Get friend list

   <img width="113" alt="Screenshot 2024-04-25 234151" src="https://github.com/huyvu38/CS180-Team/assets/144382505/caa893d4-f587-44b2-8f00-76150c81d963">

   After clicking that button, the client can see all of their friends in the drop-down list.


3. Get block list

   <img width="112" alt="Screenshot 2024-04-25 234200" src="https://github.com/huyvu38/CS180-Team/assets/144382505/98adbeb8-285b-4901-b5f0-41a0a041a75c">

   After clicking that button, the client can see all the users that have been blocked in the drop-down list.

4. Search

  <img width="112" alt="Screenshot 2024-04-26 000129" src="https://github.com/huyvu38/CS180-Team/assets/144382505/e5089ddc-644a-449c-98ed-42140b2459b2">

  The client writes the text and the server will find all of the username that contain the text. 

  <img width="110" alt="Screenshot 2024-04-26 000148" src="https://github.com/huyvu38/CS180-Team/assets/144382505/7a3bd78c-4b89-41e9-b15a-ffd9d5f62a87">

  The result will appear in the drop-down list.



5. Action

   After clicking to the "Action" button, the Action Frame will appear with some following buttons :

   1. Add friend/Delete friend/Block user/Unblock user
   

    The client first needs to type the username of other people and click to the any button that they want. The server will then check if that client can do that action and update any important changes to the database.

   
    
   2. View other user profile
   
  
   If the client writes the username in the database and not in the block list, another Frame will appear and let them view another user's information like age, gender, nationality, job, or hobby.
   

   3. Send Message

   

   4. Log out

   The client will go back to the "Main Menu Frame" where they can log in or create account.


### Test case <br/>

Test 1 : Create account

 1. Click to the "Create Account" button

   <img width="435" alt="Screenshot 2024-04-26 014752" src="https://github.com/huyvu38/CS180-Team/assets/144382505/21d29efc-1798-4548-ab6d-5409decee84f">

 2.  Write the following information and click "Enter"

   Expected result :
   
   <img width="196" alt="Screenshot 2024-04-26 014800" src="https://github.com/huyvu38/CS180-Team/assets/144382505/37f19095-a113-4930-b4e0-73060335525f">


Test 2 : Log in failure

1. Click to the "Log in" button

   <img width="365" alt="Screenshot 2024-04-26 015124" src="https://github.com/huyvu38/CS180-Team/assets/144382505/22bf6bdf-2bd4-4bf5-aff7-e36f1a0ccb7d">

2. Write the following information and click "Enter"

   Expected result:

   <img width="194" alt="Screenshot 2024-04-26 015132" src="https://github.com/huyvu38/CS180-Team/assets/144382505/a3c5d608-7b0d-4eff-ba11-24537fffcdc8">


Test 3:  Log in successful

1. Click to the "Log in" button

   <img width="364" alt="Screenshot 2024-04-26 020215" src="https://github.com/huyvu38/CS180-Team/assets/144382505/8e066b44-2b1c-485a-8f01-dd0c551afb74">


2. Write the following information and click "Enter"

   Expected result: The User Frame will appear.

   <img width="504" alt="Screenshot 2024-04-26 020230" src="https://github.com/huyvu38/CS180-Team/assets/144382505/3e02d9de-6261-40c5-9c80-eddc1d014574">

Test 4 to 11 is after the clien "vu28" log in successfully

Test 4: Edit profile failure

   1. Write "abc" in the text field next to "Age"

   2. Click "Save" button

   3. Expected result:

   <img width="197" alt="Screenshot 2024-04-27 011622" src="https://github.com/huyvu38/CS180-Team/assets/144382505/c52406f1-c5d1-4da2-8e31-3bec9a12e4eb">

   Can not edit age because age must be a positive number.


Test 5: Add friend 

   1. Click to "Action" button

   2. Write "Yanxin171" to the text field

   3. Click to "Add friend" button

   Expected result:
   
   <img width="196" alt="Screenshot 2024-04-27 011807" src="https://github.com/huyvu38/CS180-Team/assets/144382505/916136a4-5bed-4491-b9cc-3e4d2fd7b98d">

   4. Click "Get friend list" button

   <img width="111" alt="Screenshot 2024-04-27 011923" src="https://github.com/huyvu38/CS180-Team/assets/144382505/eb671238-cd68-4bf3-afff-5791c43e348c">

   The new friend list should include "Yanxin171".

Test 6: Unfriend

   1. Click to "Action" button

   2. Write "josh12" to the text field

   3. Click to "Delete friend" button

   Expected result:
   
   <img width="198" alt="Screenshot 2024-04-27 012032" src="https://github.com/huyvu38/CS180-Team/assets/144382505/4553a458-be35-4ccd-a6bd-f8a7a1f84120">

   Can not add "josh12" because that user does not appear in the database.


Test 7: Block friend

   1. Click to "Action" button

   2. Write "george34" to the text field

   3. Click to "Block user" button

   Expected result:

   <img width="196" alt="Screenshot 2024-04-27 012233" src="https://github.com/huyvu38/CS180-Team/assets/144382505/d8aef68b-9d80-4448-a196-440b5badf498">

   4. Click "Get block list" button

   <img width="110" alt="Screenshot 2024-04-27 012247" src="https://github.com/huyvu38/CS180-Team/assets/144382505/6ce85e83-2c7b-4f77-974c-7103ac65f992">

   The new block list should include "george34".


Test 8: Unblock friend

Test 9: Search user

Test 10: View other user profile

Test 11: Send message and delete message.


