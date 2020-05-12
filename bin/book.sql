create database if not exists Book default charset utf8;
use Book;

--创建管理员表--
create table manager(
id varchar(12) primary key,
password varchar(64) not null)character set utf8 collate utf8_general_ci;

--插入 管理员 root 密码 root--
insert into manager values('root','63A9F0EA7BB98050796B649E85481845');


--创建管理员信息表--
create table manager_info(
manager_id varchar(12),constraint manager_id_fk foreign key(manager_id) references manager(id),
manager_name varchar(20) not null,
manager_sex varchar(4) not null,
manager_age int not null,
manager_Wyear int not null,
manager_majors varchar(30) not null
)character set utf8 collate utf8_general_ci;


--创建学生信息表--
create table stu_info(
stu_id varchar(12)primary key,
stu_name varchar(20) not null,
stu_userName varchar(20) not null,
stu_password varchar(64) not null,
stu_sex varchar(4) not null,
stu_age int not null,
stu_major varchar(30) not null,
stu_ci int not null default 3
)character set utf8 collate utf8_general_ci;



--创建书库--
create table Book_info (
book_id varchar(12)primary key,
book_name varchar(20) not null,
book_author varchar(10) not null,
book_price varchar(10) not null,
book_press  varchar(10) not null,
book_category varchar(20) not null,
book_describe varchar(100) not null,
book_Lend varchar(30) not null default '未借出'
)character set utf8 collate utf8_general_ci;

DELETE FROM Book_info WHERE book_id='';
DELETE FROM stu_info WHERE stu_id='123456123456';
