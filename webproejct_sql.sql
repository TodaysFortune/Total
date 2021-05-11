SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS humorcomment;
DROP TABLE IF EXISTS humorboard;
DROP TABLE IF EXISTS ITcomment;
DROP TABLE IF EXISTS ITboard;
DROP TABLE IF EXISTS userinfo;




/* Create Tables */

CREATE TABLE humorboard
(
	bidx int NOT NULL,
	id varchar(15) NOT NULL,
	name varchar(15) NOT NULL,
	subject varchar(100) NOT NULL,
	content varchar(2000) NOT NULL,
	board_ref int NOT NULL,
	board_lev int NOT NULL,
	board_seq int NOT NULL,
	board_hit int NOT NULL,
	writedate timestamp DEFAULT NOW(), SYSDATE() NOT NULL,
	good int unsigned NOT NULL,
	PRIMARY KEY (bidx),
	UNIQUE (id)
);


CREATE TABLE humorcomment
(
	cidx int NOT NULL,
	bidx int NOT NULL,
	id varchar(15) NOT NULL,
	name varchar(15) NOT NULL,
	writedate timestamp DEFAULT NOW(), SYSDATE() NOT NULL,
	content varchar(100) NOT NULL,
	UNIQUE (id)
);


CREATE TABLE ITboard
(
	bidx int NOT NULL,
	id varchar(15) NOT NULL,
	name varchar(15) NOT NULL,
	subject varchar(100) NOT NULL,
	content varchar(2000) NOT NULL,
	board_ref int NOT NULL,
	board_lev int NOT NULL,
	board_seq int NOT NULL,
	board_hit int NOT NULL,
	writedate timestamp DEFAULT NOW(), SYSDATE() NOT NULL,
	good int unsigned NOT NULL,
	PRIMARY KEY (bidx),
	UNIQUE (bidx)
);


CREATE TABLE ITcomment
(
	cidx int NOT NULL,
	bidx int NOT NULL,
	id varchar(15) NOT NULL,
	name varchar(15) NOT NULL,
	writedate timestamp DEFAULT NOW(), SYSDATE() NOT NULL,
	content varchar(100) NOT NULL
);


CREATE TABLE userinfo
(
	id varchar(15) NOT NULL,
	password varchar(15) NOT NULL,
	name varchar(10) NOT NULL,
	email varchar(30) NOT NULL,
	phone varchar(15),
	PRIMARY KEY (id),
	UNIQUE (name),
	UNIQUE (email)
);



/* Create Foreign Keys */

ALTER TABLE humorcomment
	ADD FOREIGN KEY (bidx)
	REFERENCES humorboard (bidx)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE ITcomment
	ADD FOREIGN KEY (bidx)
	REFERENCES ITboard (bidx)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE humorboard
	ADD FOREIGN KEY (id)
	REFERENCES userinfo (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE humorcomment
	ADD FOREIGN KEY (id)
	REFERENCES userinfo (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE ITboard
	ADD FOREIGN KEY (id)
	REFERENCES userinfo (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE ITcomment
	ADD FOREIGN KEY (id)
	REFERENCES userinfo (id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



