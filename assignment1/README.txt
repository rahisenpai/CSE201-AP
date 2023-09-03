This is the readme file for assignment 1 in AP course during Monsoon semester 2023.
Contributor(s)- Himanshu Raj (2022216)

The main aim was to develop a library system which has two interfaces, librarian and member, based on principles of OOPS.
This program doesn't store data from previous executions and only contains data during run time. Upon running the system is implemented as it is a fresh start and there are no members or books in library so you'll have to add them through librarian interface to access them.

Instructions to compile and run the code with maven (here we have added a plugin in pom.xml because the address to main is not default):
1. Ensure that your system has Java (version 20.0.1) and Maven installed on your system.
2. Open terminal and change directory to this folder.
3. Build the project with 'mvn clean compile package'.
4. Run the jar file with 'java -jar .\target\assignment1-1.0.jar'.

Henceforth I'll be describing functionalities for librarian and member.
Librarian:
1. Add member- This allows librarian to add a member(and only one user can be registered with one phone no) to ensure unique phone no, also members are also assigned a unique memberID from library. Name is a string input and phone no and age are int data types and their value must be greater than 0.
2. Remove member- This allows librarian to remove a member, if a member holds any book they can't be removed and a message will be displayed. Input is memberID and prints error message if ID is wrong.
3. Add book- This allows a librarian to add books to library, also books are assigned unique bookID from library.
4. Remove book- This allows librarian to remove a book, if a book is hold by any member it can't be removed and a message will be displayed.Input is bookID and prints error message if ID is wrong.
5. List members- This displays a list of members along with their and number of borrowed books to librarian, here fine is calculated in real time i.e. even if the book is not returned.
6. List books- This displays a list of all books in the library with availability status.

Member:
Login: This is done by name and phone no and the assumptions are same as stated above.
Fines are only assigned after a book is returned.
1. List available books- This displays a list of available books to member.
2. List my books- This displays a list of issued books by member to member.
3. Issue book- This allows member to issue an available book. If a member has not returned first book and a fine is due, then they can't issue another book.
4. Return book- This allows member to return a book they have issued and tells them if a fine has been imposed or not.
5. Pay fine- This pays all the assigned fine of the member. This pays fine only after you return the book.

If any assumption or exception is not stated, then it most likely follows the assignment document and in most cases, just the terminal output and instructions are enough.