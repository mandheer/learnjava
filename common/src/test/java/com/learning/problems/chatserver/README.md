####Problems
Explain how you would design a chat server. In particular, provide details about the various backend components, classes, and methods. What would be the hardest problems to solve?
####SOLUTION

Designing a chat server is a huge project, and it is certainly far beyond the scope of what could be completed in an interview. After all, teams of many people spend months or years creating a chat server. Part of your job, as a candidate, is to focus on an aspect of the problem that is reasonably broad, but focused enough that you could accomplish it during an interview. It need not match real life exactly, but it should be a fair representation of an actual implementation.

For our purposes, we'll focus on the core user management and conversation aspects: adding a user, creating a conversation, updating one's status, and so on. In the interest of time and space, we will not go into the networking aspects of the problem, or how the data actually gets pushed out to the clients.

We will assume that "friending" is mutual; I am only your contact if you are mine. Our chat system will support both group chat and one-on-one (private) chats. We will not worry about voice chat, video chat, or file transfer.

######What specific actions does it need to support?
This is also something to discuss with your interviewer, but here are some ideas:
* Signing online and offline.
* Add requests (sending, accepting, and rejecting).
* Updating a status message.
* Creating private and group chats.
* Adding new messages to private and group chats.

This is just a partial list. If you have more time, you can add more actions.
######What can we learn about these requirements?
We must have a concept of users, add request status, online status, and messages.

######What are the core components of the system?
The system would likely consist of a database, a set of clients, and a set of servers. We won't include these parts in our object-oriented design, but we can discuss the overall view of the system.

The database will be used for more permanent storage, such as the user list or chat archives. A SQL database is a good bet, or, if we need more scalability, we could potentially use BigTable or a similar system.

For communication between the client and servers, using XML will work well. Although it’s not the most compressed format (and you should point this out to your interviewer), it’s nice because it's easy for both computers and humans to read. Using XML will make your debugging efforts easier—and that matters a lot.

The server will consist of a set of machines. Data will be divided up across machines, requiring us to potentially hop from machine to machine. When possible, we will try to replicate some data across machines to minimize the lookups. One major design constraint here is to prevent having a single point of failure. For instance, if one machine controlled all the user sign-ins, then we'd cut off millions of users potentially if a single machine lost network connectivity.

######What are the key objects and methods?
The key objects of the system will be a concept of users, conversations, and status messages. We've implemented a User-Management class. If we were looking more at the networking aspects of the problem, or a different component, we might have instead dived into those objects.

```java
1 /* UserManager serves as a central place for core user actions. */
1 public class UserManager {
2 private static UserManager instance;
3 /* maps from a user id to a user */
4 private HashMap<Integer, User> usersByld;
5
6 /* maps from an account name to a user */
7 private HashMap<String, User> usersByAccountName;
8
9 /* maps from the user id to an online user */
10 private HashMap<Integer, User> onlineUsers;
11
12 public static UserManager getlnstance() {
13 if (instance == null) instance = new UserManager();
14 return instance;
15 }
16
17 public void addUser(User fromUser, String toAccountName) { ... }
18 public void approveAddRequest(AddRequest req) { ... }
19 public void rejectAddRequest(AddRequest req) { ... }
20 public void userSignedOn(String accountName) { ... }
21 public void userSignedOff(String accountName) { ... }
22 }
```

The method receivedAddRequest, in the User class, notifies User B that User A has requested to add him. User B approves or rejects the request (via UserManager. approvedAddRequest or rejectAddRequest), and the UserManager takes care of adding the users to each other's contact lists.

The method sentAddRequest in the User class is called by User-Manager to add an AddRequest to User A's list of requests. So the flow is:
1. User A clicks "add user" on the client, and it gets sent to the server.
2. User A calls requestAddUser(User B).
3. This method calls UserManager. addUser.
4. UserManager calls both User A.sentAddRequest and User B.receivedAddRequest.

Again, this is just one way of designing these interactions. It is not the only way or even the only "good" way.

```java
1 public class User {
2 private int id;
3 private UserStatus status null;
4
5 /* maps from the other participant's user id to the chat */
6 private HashMap<Integer, PrlvateChat> privateChats;
7
8 /* maps from the group chat id to the group chat */
9 private ArrayList<GroupChat> groupChats;
10
11 /* maps from the other person's user id to the add request */
12 private HashMap<Integer, AddRequest> receivedAddRequests;
13
14 /* maps from the other person's user id to the add request */
15 private HashMap<Integer, AddRequest> sentAddRequests;
16
17 /* maps from the user id to the add request */
18 private HashMap<Integer, User> contacts;
19
20 private String accountName;
21 private String fullName;
22
23 public User(int id, String accountName, String fullName) { … }
24 public boolean sendMessageToUser(User to, String content){ … }
25 public boolean sendMessageToGroupChat(int id, String cnt){ … }
26 public void setStatus(UserStatus status) { ... }
27 public UserStatus getStatus() { ... }
28 public boolean addContact(User user) { ... }
29 public void receivedAddRequest(AddRequest req) { … }
30 public void sentAddRequest (AddRequest req) { ... }
31 public void removeAddRequest(AddRequest req) { ... }
32 public void requestAddUser(String accountName) { … }
33 public void addConversation(PrivateChat conversation) { … }
34 public void addConversation(GroupChat conversation) { … }
35 public int getld() { ... }
36 public String getAccountName() { ... }
37 public String getFullName() { ... }
38 }
```

The Conversation class is implemented as an abstract class, since all Conversations must be either a GroupChat or a PrivateChat, and since these two classes each have their own functionality.

```java
1 public abstract class Conversation {
2 protected ArrayList<User> participants;
3 protected int id;
4 protected ArrayList<Message> messages;
5
6 public ArrayList<Message> getMessages() { … }
7 public boolean addMessage(Message m) { … }
8 public int getld() { ... }
9 }
10
```

```java
11 public class GroupChat extends Conversation {
12 public void removeParticipant(User user) { ... }
13 public void addParticipant(User user) { ... }
14 }
15
```

```java
16 public class PrivateChat extends Conversation {
17 public PrivateChat(User user1, User user2) { ...
18 public User getOtherParticipant(User primary) { … }
19 }
20
```

```java
21 public class Message {
22 private String content;
23 private Date date;
24 public Message(String content, Date date) { ... }
25 public String getContent() { ... }
26 public Date getDate() { … }
27 }
```

AddRequest and UserStatus are simple classes with little functionality. Their main purpose is to group data that other classes will act upon.

```java
1 public class AddRequest {
2 private User fromUser;
3 private user toUser;
4 private Date date;
5 Requeststatus status;
6
7 public AddRequest(User from, User to, Date date) { … }
8 public RequestStatus getStatus() { … }
9 public User getFromUser() { ... }
10 public User getToUser() { ... }
11 public Date getDate() { ... }
12 }
13
```

```java
14 public class UserStatus {
15 private String message;
16 private UserStatusType type;
17 public UserStatus(UserStatusType type, String message) f
18 public UserStatusType getStatusTypeQ { ... }
19 public String getMessageQ { ... }
20 }
21
```

```java
22 public enum UserStatusType {
23 Offline, Away, Idle, Available, Busy
24 }
25
```

```java
26 public enum RequestStatus {
27 Unread, Read, Accepted, Rejected
28 }
```
The downloadable code attachment provides a more detailed look at these methods, including implementations for the methods shown above.

#####What problems would be the hardest to solve (or the most interesting)?
The following questions may be interesting to discuss with your interviewer further.

######How do we know if someone is online—/ mean, really, really know?
While we would like users to tell us when they sign off, we can't know for sure. A user's connection might have died, for example. To make sure that we know when a user has signed off, we might try regularly pinging the client to make sure it's still there.
######How do we deal with conflicting information?
We have some information stored in the computer's memory and some in the database. What happens if they get out of sync? Which one is "right"?
######How do we make our server scale?
While we designed out chat server without worrying—too much—about scalability, in real life this would be a concern. We'd need to split our data across many servers, which would increase our concern about out-of-sync data.
######How we do prevent denial of service attacks?
Clients can push data to us—what if they try to DOS (denial of service) us? How do we prevent that?

