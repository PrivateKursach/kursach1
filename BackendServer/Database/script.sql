CREATE SEQUENCE TP_TRAINING_SEQ INCREMENT BY 1 START WITH 1;

CREATE TABLE TP_TRAINING
(
  ID NUMBER NOT NULL
, NAME VARCHAR2(100) NOT NULL
, DESCRIPTION CLOB
, START_DATE DATE NOT NULL
, END_DATE DATE NOT NULL
);

ALTER TABLE TP_TRAINING
ADD CONSTRAINT TP_TRAINING_PK PRIMARY KEY
(
  ID
)
ENABLE;

begin
 execute immediate 'create or replace trigger TP_TRAINING  '||chr(10)||
	'   before insert on "SYSTEM"."TP_TRAINING" '||chr(10)||
	'   for each row '||chr(10)||
	'begin  '||chr(10)||
	'   if inserting then '||chr(10)||
	'      if :NEW."ID" is null then '||chr(10)||
	'         select TP_TRAINING_SEQ.nextval into :NEW."ID" from dual; '||chr(10)||
	'      end if; '||chr(10)||
	'   end if; '||chr(10)||
	'end;'||chr(10);
	end;
