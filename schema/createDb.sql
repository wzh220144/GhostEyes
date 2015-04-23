DROP DATABASE IF EXISTS ghosteyes;
CREATE DATABASE ghosteyes DEFAULT CHARACTER SET utf8;
USE ghosteyes;
/*==============================================================*/
/* DBMS name:      MySQL                                        */
/* Created on:     2015-04-14                                   */
/*==============================================================*/

drop table if exists t_usr;

drop table if exists t_login_log;

drop table if exists t_note;

drop table if exists t_notebook;

/*==============================================================*/
/* Table: t_usr                                                 */
/*==============================================================*/
create table t_usr
(
   usrid				int(20) not null auto_increment,
   username				varchar(150) not null,
   passwd				varchar(80) not null,
   email				varchar(100) default NULL,
   tel					varchar(20) default NULL,
   superuser			varchar(20) default 'normal_user',
   birth				datetime default NULL,
   note					varchar(200) default NULL,
   country				varchar(100) default NULL,
   gender				varchar(20) default NULL,
   createDate			datetime default NULL,
   lastEditeDate		datetime default NULL,
   primary key (usrid)
);

/*==============================================================*/
/* Table: t_note                                                */
/*==============================================================*/
create table t_note
(
   usrid				int(20) not null,
   articleid			int(20) not null auto_increment,
   content				mediumtext default NULL,
   md5					varchar(80) default NULL,
   category				varchar(100) default NULL,
   createDate			datetime default NULL,
   lastEditDate				datetime default NULL,
   title				varchar(100) default 'N/A',
   nbid					int(20) not null,
   stat				int(5) default 0,
   primary key (articleid)
);

/*==============================================================*/
/* Table: t_login_log                                           */
/*==============================================================*/
create table t_login_log
(
	logid				int(20) not null auto_increment,
	usrid				int(20) not null,
	ip					varchar(80) default NULL,
	logDate				datetime default NULL,
	primary key (logid)
);

/*==============================================================*/
/* Table: t_notebook                                           */
/*==============================================================*/
create table t_notebook
(
	nbid				int(20) not null auto_increment,
	usrid				int(20) not null,
    notebook			varchar(50) not null,
	nt_count			int(20) not null,
	createDate			datetime default NULL,
	lastEditDate		datetime default NULL,
	primary key (nbid)
);



/*insert into t_forum(forum_id,forum_name,forum_desc) values(1,'forum1','desc1');
insert into t_forum(forum_id,forum_name,forum_desc) values(2,'forum2','desc2');

insert into t_topic (topic_id,forum_id, topic_title, user_id, topic_time, topic_views, topic_replies) values (1,1, '主题1', 1, '1-1-1 0:0:1', 166, 1);
insert into t_topic (topic_id,forum_id, topic_title, user_id, topic_time, topic_views, topic_replies) values (2,1, '主题2', 1, '1-1-1 0:0:0', 100, 49);
insert into t_topic (topic_id,forum_id, topic_title, user_id, topic_time, topic_views, topic_replies) values (3,2, '主题3', 1, '1-1-1 0:0:1', 130, 70);
insert into t_topic (topic_id,forum_id, topic_title, user_id, topic_time, topic_views, topic_replies) values (4,2, '主题4', 2, '1-1-1 0:0:2', 166, 22);
commit;*/
