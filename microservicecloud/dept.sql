DROP DATABASE IF EXISTS clouddb01;
CREATE DATABASE cloudDB01 CHARACTER set UTF8;
USE cloudDB01;
CREATE TABLE dept
(
  deptno BIGINT NOT  NULL PRIMARY KEY AUTO_INCREMENT,
  dname VARCHAR(60),
  db_source VARCHAR(60)
);

insert into dept( dname, db_source) values('开发部',DATABASE());
insert into dept( dname, db_source) values('人事部',DATABASE());
insert into dept( dname, db_source) values('财务部',DATABASE());
insert into dept( dname, db_source) values('市场部',DATABASE());
insert into dept( dname, db_source) values('运维部',DATABASE());

SELECT * from dept;



DROP DATABASE IF EXISTS clouddb02;
CREATE DATABASE cloudDB02 CHARACTER set UTF8;
USE cloudDB02;
CREATE TABLE dept
(
  deptno BIGINT NOT  NULL PRIMARY KEY AUTO_INCREMENT,
  dname VARCHAR(60),
  db_source VARCHAR(60)
);

insert into dept( dname, db_source) values('开发部',DATABASE());
insert into dept( dname, db_source) values('人事部',DATABASE());
insert into dept( dname, db_source) values('财务部',DATABASE());
insert into dept( dname, db_source) values('市场部',DATABASE());
insert into dept( dname, db_source) values('运维部',DATABASE());

SELECT * from dept;


DROP DATABASE IF EXISTS clouddb03;
CREATE DATABASE cloudDB03 CHARACTER set UTF8;
USE cloudDB03;
CREATE TABLE dept
(
  deptno BIGINT NOT  NULL PRIMARY KEY AUTO_INCREMENT,
  dname VARCHAR(60),
  db_source VARCHAR(60)
);

insert into dept( dname, db_source) values('开发部',DATABASE());
insert into dept( dname, db_source) values('人事部',DATABASE());
insert into dept( dname, db_source) values('财务部',DATABASE());
insert into dept( dname, db_source) values('市场部',DATABASE());
insert into dept( dname, db_source) values('运维部',DATABASE());

SELECT * from dept;