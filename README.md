# Book library project
Library CRUD web application. You can register new readers, change their data, give them books. You can also create and edit books, and assign a book to a reader.

## Technology stack

- Java Core,
- Spring Core,
- Spring MVC,
- JDBC API, JdbcTemplate,
- Thymeleaf,
- PostgreSQL,
- CSS,
- GIT,
- IDEA.

## Web interface

### Start page

![image](https://user-images.githubusercontent.com/119116584/220569092-b29835b0-9cd1-415d-9bf7-c918c3da4f0b.png)

The "start page" tab is the default tab. You can go to the "Books" or "People tab.

### Books

![image](https://user-images.githubusercontent.com/119116584/220571071-45240c41-1474-41d8-b98a-31bf14af248d.png)

Books page (/books). A list of all books is displayed here. You can go through the book and see its data. You can also add a new book.

### Book

![image](https://user-images.githubusercontent.com/119116584/220571382-45e9e107-4ec3-401d-bb80-0b51205b50f4.png)

Book page (books/{id}). The data of the book is displayed here. You can unassign, assign, edit, delete the book. You can see the reader's name.

### People

![image](https://user-images.githubusercontent.com/119116584/220572690-b75da143-aa4b-496a-91ff-42643bc829b0.png)

People page (/people). Here is a list of all readers. You can go to the reader. You can edit the reader.

### Reader

![image](https://user-images.githubusercontent.com/119116584/220573199-27a21e0c-d4a1-454d-9232-96536e89b24d.png)

Reader page (people/{id}). Reader data is displayed here. You can see the books that the reader has chosen. You can also edit, delete the reader.

## PostgreSQL
Before running the application, create two tables.

create table person(
                       id int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
                       name varchar NOT NULL,
                       year int NOT NULL
);
CREATE TABLE book(
                     id int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
                     name varchar NOT NULL,
                     author varchar NOT NULL,
                     year int NOT NULL,
                     person_id int REFERENCES person(id) ON DELETE SET NULL
);

## Config

You should change the fields (driver,url,username,password) in the "SpringConfig.java" class. 
