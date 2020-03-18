CREATE DATABASE `ssmbuild`;

USE `ssmbuild`;
create table books
(
	id int auto_increment comment '书id'
		primary key,
	name varchar(100) not null comment '书名',
	num int not null comment '数量',
	detail varchar(200) not null comment '描述'
)
charset=utf8;


INSERT INTO ssmbuild.books (id, name, num, detail) VALUES (1, 'Java', 1, '从入门到放弃');
INSERT INTO ssmbuild.books (id, name, num, detail) VALUES (2, 'MySQL', 10, '从删库到跑路');
INSERT INTO ssmbuild.books (id, name, num, detail) VALUES (3, 'Linux', 5, '从进门到进牢');
INSERT INTO ssmbuild.books (id, name, num, detail) VALUES (4, '安慰我', 100, '大声道撒');
INSERT INTO ssmbuild.books (id, name, num, detail) VALUES (5, 'MySQL', 10, '从删库到跑路');
INSERT INTO ssmbuild.books (id, name, num, detail) VALUES (6, 'Linux', 5, '从进门到进牢');
INSERT INTO ssmbuild.books (id, name, num, detail) VALUES (7, 'Java', 1, '从入门到放弃');
INSERT INTO ssmbuild.books (id, name, num, detail) VALUES (8, 'MySQL', 10, '从删库到跑路');
INSERT INTO ssmbuild.books (id, name, num, detail) VALUES (9, 'Linux', 5, '从进门到进牢');
INSERT INTO ssmbuild.books (id, name, num, detail) VALUES (10, '阿斯顿撒', 1, '实时');