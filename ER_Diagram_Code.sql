// To create a new Database
create database ExaminationSystem;

// to use created database
use ExaminationSystem;

//Create a Table with name "User"
CREATE TABLE User (
    UserID INT PRIMARY KEY,
    UserName VARCHAR(255),
    Password VARCHAR(255),
    Role VARCHAR(50),
    Email VARCHAR(255)
);

//Create a Table with name "Admin"
CREATE TABLE Admin (
    AdminID INT PRIMARY KEY,
    FirstName VARCHAR(255),
    LastName VARCHAR(255),
    EmailID VARCHAR(255),
    Age INT,
    FOREIGN KEY (AdminID) REFERENCES User(UserID)
);

//Create a Table with name "Student"
CREATE TABLE Student (
    StuID INT PRIMARY KEY,
    StuFirstName VARCHAR(255),
    StuLastName VARCHAR(255),
    Email VARCHAR(255),
    DateOfEnroll DATE
);

//Create a Table with name "Course"
CREATE TABLE Course (
    CourseID INT PRIMARY KEY,
    CourseName VARCHAR(255),
    AdminID INT,
    AboutCourse TEXT,
    CourseDuration INT,
    CourseFee DECIMAL(10, 2),
    FOREIGN KEY (AdminID) REFERENCES Admin(AdminID)
);

//Create a Table with name "Exam"
CREATE TABLE Exam (
    ExamID INT PRIMARY KEY,
    EName VARCHAR(255),
    EDate DATE,
    ExamMode VARCHAR(50),
    Place VARCHAR(255),
    TotalMarks INT,
    Duration INT,
    CourseID INT,
    FOREIGN KEY (CourseID) REFERENCES Course(CourseID)
);

//Create a Table with name "Questions"
CREATE TABLE Questions (
    QID INT PRIMARY KEY,
    ExamID INT,
    QueType VARCHAR(50),
    Marks INT,
    FOREIGN KEY (ExamID) REFERENCES Exam(ExamID)
);

//Create a Table with name "Options"
CREATE TABLE Options (
    Option_Number INT PRIMARY KEY,
    QuestionID INT,
    Correct_Opt VARCHAR(255),
    Wrong_Opt VARCHAR(255),
    FOREIGN KEY (QuestionID) REFERENCES Questions(QID)
);

//Create a Table with name "Result"
CREATE TABLE Result (
    ResultID INT PRIMARY KEY,
    StuID INT,
    ExamID INT,
    MarksObtained INT,
    Grade VARCHAR(10),
    StuRank INT,
    PassFail VARCHAR(10),
    FOREIGN KEY (StuID) REFERENCES Student(StuID),
    FOREIGN KEY (ExamID) REFERENCES Exam(ExamID)
);
