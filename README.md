# CS180-Team
### Profile.java <br/>
Creates a new profile object with name, password, age, gender, nationality, job and hobby. Includes get/set methods to modify or return given attributes.
The foundation of the database.
<br/>
### UserAccount.java <br/>
Creates a new account object with given profile object with a list of friends and blocked users. UserAccount is dependant on Profile.java. Getter and setter methods to modify and return account attributes such as blocked users and friends.
<br/>
### Method.java
Contains boolean methods crucial to the function of the database system such as block user and add friend. Depends on profile.java, future classes more integral to the database system will depend on this class.
<br/>
### Database.java
<br/>
The framework for the database system. Creates new database objects using all known accounts. Dependant on Profile and UserAccount. Methods include means to modify accounts on a large scale, including wiping all accounts and returning all accounts.
<br/>
### Messagae.java


