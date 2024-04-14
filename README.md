# CS180-L22-Team 3

Huy Vu <Submitted Vocareum Work Phase 2>

### Instruction on how to compile and run the program

The server in Server.java needs to be run first so that the client can connect to the server and using the app.

The user clicks the Run button in Client.java. Then the Main Menu will appear and allow the user to create an account, log in, or exit the app.


1. User wants to create an account

Write 1 to the program.

Then the user is prompted to enter username, password.

Once the user create account successfully, they cannot edit their username.

After that, the user is prompted to enter their age, gender, nationality, job, and hobby.

Then the program goes back to the main menu to let the user create account or log in or exit the app.

2. User wants to log in

Write 2 to the program.

Then the user is prompted to enter username and password for log in. 

If user login successfully, the program will show the Option Menu with 9 options:

1. View that user profile
  
2. Edit that user profile

3. Add friend

4. Delete friend

5. Block user

6. Unblock user

7. Send message

8. Search user then view other user profile

9. Log out

If the user writes down 1, 2, 3, the program will prompt the user to enter the information that they want to see or edit, and the program comes back to the Option Menu again.

If the user writes down 4, the program will prompt the user to enter the password to confirm. If the user delete account successfully, the program comes back to the Main Menu where user can create account or log in or exit the app.

If the user writes down 5, 6, 7, 8, 9, the program will prompt the user to search for the specific username and check if they can do that action. After that, the program comes back to the Option Menu.

If the user writes down 10, the program will exit from the Option Menu and goes to the Main Menu where user can create account or log in or exit the app.


3. User wants to exit the app

Write 3 to the program. The program will stop.

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
Creates a new account object with given profile object with a list of friends and blocked users. UserAccount is dependant on Profile.java. Getter and setter methods to modify and return account attributes such as blocked users and friends.
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

#### Methods

### Method.java <br/>
Contains boolean methods crucial to the function of the database system such as block user and add friend. Depends on Profile.java, future classes more integral to the database system will depend on this class.
This class acts as a service, allowing action between users to create relationships within the database.
#### Methods
Add and remove friends using Profile objects
<br/>
Block and unblock users using Profile objects

### Message.java <br/>

Message.java is a versatile messaging framework allowing users to send, delete, and view message histories. It features a blocking mechanism where messages from blocked users are saved but hidden from the recipient, ensuring privacy. The framework supports group messaging, enabling a user to communicate with multiple friends simultaneously, provided they are in the user's friend list. Messages are timestamped and logged into a "Messages.txt" file through a buffered reader, offering a durable record of interactions.

#### Methods
Message Operations: Send individual or group messages, with options to delete and review message history.<br/>
Privacy Controls: Block specific users, hiding their messages from the recipient while still logging them.<br/>
Group Messaging: Communicate with several friends at once, enhancing social interactions within the application.<br/>
Persistent Logging: Use a buffered reader to timestamp and store messages, ensuring a reliable historical record.<br/>

This streamlined framework is built to facilitate effective and private communication among users, balancing functionality with user control.
<br/>

### Login.java <br/>

LogIn.java is a core component for managing user authentication in an application. It interacts with a Database to handle user logins, account creation, and deletion, utilizing user credentials for secure access.

#### Methods
Initial Setup: Constructs with database and user profile for authentication tasks.<br/>
Username Validation: Ensures usernames are unique and meet formatting standards.<br/>
Password Checks: Verifies password length for security and matches passwords for login.<br/>
Account Management: Supports creating and deleting user accounts based on validation of credentials and username uniqueness.<br/>
Login Verification: Authenticates user logins by matching usernames and passwords with database records.
<br/>

### AllUserAccount.txt <br/>
The file that store profile, friendlist, blocklist of each user.
Format: [username] [password] [age] [gender] [nationality] [job] [hobby];FriendList:[list of friends];BlockList:[list of block users]

Username must be at least 4 characters.
Password must be at least 6 characters.
Age must be a positive number.
User only choose gender from the following options : Male, Female, Other.
Every information in the Profile of the user can not contain any spaces or semicolon.

### Message.txt <br/>
The file that store every message between each user.
Format: [conversationID] [ConversationTime] [Sender-Message] [if message blocked]


