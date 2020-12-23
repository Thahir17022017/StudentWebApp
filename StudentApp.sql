SHOW VARIABLES WHERE Variable_name = 'port';

Select user();

SELECT user,authentication_string,plugin,host FROM mysql.user;

create database studentappdb;

CREATE TABLE studentappdb.TCOODS_STUDENT(STUDENT_ID INT NOT NULL UNIQUE AUTO_INCREMENT,  
   FIRST_NAME VARCHAR(50) UNIQUE NOT NULL,
   MIDDLE_NAME VARCHAR(50) NOT NULL,
   LAST_NAME VARCHAR(50) NOT NULL, 
   GENDER VARCHAR(6) NOT NULL,
   PRIMARY KEY (STUDENT_ID)  
);

CREATE TABLE studentappdb.TCOODS_STUDENT_MARKS(  
   MARK_ID INT NOT NULL UNIQUE AUTO_INCREMENT,
   STUDENT_ID INT NOT NULL,
   MARK1 int NOT NULL,
   MARK2 int NOT NULL,
   MARK3 int NOT NULL,
   TOTAL int NOT NULL,
   PRIMARY KEY (MARK_ID),
   FOREIGN KEY fk_student_id(STUDENT_ID) references studentappdb.TCOODS_STUDENT(STUDENT_ID) ON UPDATE CASCADE ON DELETE RESTRICT
);


CREATE VIEW student_details
AS 
SELECT 
    Student.FIRST_NAME,
    Student.MIDDLE_NAME, 
    Student.LAST_NAME, 
    Student.GENDER, 
    StudentMarks.MARK1,
    StudentMarks.MARK2,
    StudentMarks.MARK3,
    StudentMarks.TOTAL
FROM
    studentappdb.TCOODS_STUDENT as Student
INNER JOIN
    studentappdb.TCOODS_STUDENT_MARKS as StudentMarks 
    ON Student.STUDENT_ID = StudentMarks.STUDENT_ID;
    

delimiter #

create trigger STUDENT_MARKS_TRIGGER before update on studentappdb.tcoods_student_marks
for each row
begin
  set new.total = new.mark1 + new.mark2 +new.mark3;
end#

delimiter ;