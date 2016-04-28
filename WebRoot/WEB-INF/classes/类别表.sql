drop database if exists shop;

create database shop default character set utf8;

use shop;

drop table if exists category;

create table category
(
   /* ����ţ��Զ����� */
   id  int not null auto_increment,
   /* ������� */
   type varchar(20),
   /* ����Ƿ�Ϊ�ȵ�����ȵ������п�����ʾ����ҳ*/
   hot  bool default false,
   /* ���������Ϊ����*/
   primary key (id)
);

