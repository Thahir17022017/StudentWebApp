SHOW VARIABLES WHERE Variable_name = 'port';

Select user();

SELECT user,authentication_string,plugin,host FROM mysql.user;

create database studentappdb;

CREATE TABLE studentappdb.TCOLKP_USER(  
   USER_ID INT NOT NULL UNIQUE AUTO_INCREMENT,  
   USER_NAME VARCHAR(100) UNIQUE NOT NULL,
   USER_SALT VARCHAR(36) NOT NULL, 
   USER_PWD VARCHAR(130) NOT NULL,
   ACTIVE_FLG VARCHAR(1) NOT NULL DEFAULT 'N',
   PRIMARY KEY (USER_ID)  
);