This is the readme file for assignment 2 in AP course during Monsoon semester 2023.
Contributor(s)- Himanshu Raj (2022216)
The aim was to develop a zoo system based on principles of OOPS.
This program doesn't store data from previous executions and only contains data during run time.

Assumptions:
- I have hardcoded Admin details (username: admin, password: admin123); membership prices(20 & 50); 6 animals(2 of each type); 2 discounts (as specified in assignment doc); and 2 deals (as specified in assignment doc).
- The hardcoded information (except admin details and membership price) can be updated or removed in the admin menu, it is hardcoded to ease evaluation.
- All username, emails and passwords are case-sensitive.
- When the program is started admin must add attractions and schedule them, for attraction to be accessible to visitors.
- Adding attraction doesn't make it available to visitors, it needs to scheduled with status and price, status can be 'open' or 'closed'.
- Attractions have a unique id so anything related to attraction ask for attraction id, which is displayed to visitor at the start of their choice.
- While adding discounts you must provide an age limit by defining max and min age.
- The animal types can be specified as 'm' or 'mammal' or 'mammals' for mammals, and similarly for other types.
- Visitor balance is only taken once while registering, there is no way to increase a visitor's balance later on.
- Visitor email must have '@' and '.com'. Visitor must have enough balance to do a purchase.
- If visitor don't want to avail a discount code, they can either simply press enter at prompt or type 'none'.


The terminal commands are run in the unzipped folder which has src,pom.xml,Readme.txt,etc. All the code is in the 'src/main/java/org/example' folder.

Instructions to compile and run the code with maven (here we have added a plugin in pom.xml because the address to main is not default):
0. Ensure that your system has Java (version 20.0.1) and Apache Maven (version 3.9.4) installed on your system.
1. Download the zip folder from Classroom and unzip.
2. Open terminal and change directory to the unzipped folder.
3. Build the project with 'mvn clean compile package'.
4. Run the jar file with 'java -jar .\target\assignment2-1.0.jar'.


Implementation and Working:
All the specified OOP concepts have been used which are encapsulation, interfaces, abstract class, inheritance, polymorphism and object class.

Admin:
Attractions: Add, remove, update, view attractions. A unique ID is assigned automatically and used in many operations ahead.
Animals: Add, remove, update, view animals. Takes sound, history as input as well.
ScheduleEvents: By default attraction is closed, here it is opened or closed and price is decided.
Discounts: Add, remove, update, view discounts. Takes age-range and discount code as input as well.
Deals: Add, remove, view deals.
Stats: See zoo stats.
Feedback: Read visitor's feedback.

Visitor:
Explore: See the animals and attractions in zoo.
Membership: Buy a membership. Required to visit animals or attractions.
Tickets: Only required for basic members to buy attraction tickets.
Discounts: See the discounts available.
Deals: See the special deals available.
Animals: Visit animals in zoo and either read about them or feed them.
Attractions: Visit open attractions in the zoo. Basic members need a ticket, premium members don't.
Feedback: Give a feedback about your experience.


-- If any assumption or exception is not stated, then it most likely follows the assignment document and in most cases, just the terminal output is enough.