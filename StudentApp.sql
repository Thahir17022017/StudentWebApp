SHOW VARIABLES WHERE Variable_name = 'port';

Select user();

SELECT user,authentication_string,plugin,host FROM mysql.user;

create database studentappdb;

CREATE TABLE studentappdb.TCOODS_STUDENT(STUDENT_ID INT NOT NULL UNIQUE AUTO_INCREMENT,  
   FIRST_NAME VARCHAR(50) UNIQUE NOT NULL,
   MIDDLE_NAME VARCHAR(50) NOT NULL,
   LAST_NAME VARCHAR(50) NOT NULL, 
   GENDER VARCHAR(6) NOT NULL,
   AGE INT NOT NULL,
   CREATED_TS TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   UPDATE_TS TIMESTAMP DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
   PRIMARY KEY (STUDENT_ID)  
);

CREATE TABLE studentappdb.TCOODS_STUDENT_MARKS(  
   MARK_ID INT NOT NULL UNIQUE AUTO_INCREMENT,
   STUDENT_ID INT NOT NULL,
   MARK1 int NOT NULL,
   MARK2 int NOT NULL,
   MARK3 int NOT NULL,
   TOTAL int,
   CREATED_TS TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
   UPDATE_TS TIMESTAMP DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
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
    Student.AGE,
    StudentMarks.MARK1,
    StudentMarks.MARK2,
    StudentMarks.MARK3,
    StudentMarks.TOTAL
FROM
    studentappdb.TCOODS_STUDENT as Student
INNER JOIN
    studentappdb.TCOODS_STUDENT_MARKS as StudentMarks 
    ON Student.STUDENT_ID = StudentMarks.STUDENT_ID
    ORDER BY Student.STUDENT_ID DESC;
    

DROP TRIGGER IF EXISTS `studentappdb`.`tcoods_student_marks_BEFORE_INSERT`;

DELIMITER $$
USE `studentappdb`$$
CREATE DEFINER = CURRENT_USER TRIGGER `studentappdb`.`tcoods_student_marks_BEFORE_INSERT` BEFORE INSERT ON `tcoods_student_marks` FOR EACH ROW
BEGIN
SET NEW.TOTAL = NEW.MARK1+NEW.MARK2+NEW.MARK3;
END$$
DELIMITER ;

SELECT LAST_INSERT_ID() as ID;

Insert studentappdb.TCOODS_STUDENT(FIRST_NAME,MIDDLE_NAME,LAST_NAME,GENDER,AGE)
values("Abu","mohamed","thahir","male",35);

insert studentappdb.tcoods_student_marks(STUDENT_ID,MARK1,MARK2,MARK3)
values(1,10,20,30);

select first_name,middle_name,last_name from studentappdb.student_details where first_name like '%abu%' or middle_name like '%abu%' or last_name like '%thahir';


