DROP SEQUENCE BOARD_SEQ;
CREATE SEQUENCE BOARD_SEQ NOCACHE;

DROP TABLE BOARD;
CREATE TABLE BOARD(
    BOARD_NO NUMBER NOT NULL,
       TITLE VARCHAR2(1000 BYTE) NOT NULL,
     CONTENT VARCHAR2(4000 BYTE),           -- 에디터 사용 예정
   WRITER_ID VARCHAR2(45 BYTE) NOT NULL UNIQUE,
 CREATE_DATE TIMESTAMP,
 MODIFY_DATE TIMESTAMP,
       STATE NUMBER(1) NOT NULL,
       DEPTH NUMBER(2) NOT NULL,
    GROUP_NO NUMBER NOT NULL,
 GROUP_ORDER NUMBER NOT NULL,
  CONSTRAINT PK_BOARD PRIMARY KEY(BOARD_NO)
);
        
        
INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL, '제목1', '내용1', '작성자1', SYSDATE, SYSDATE, 1, 0, BOARD_SEQ.CURRVAL, 0);

COMMIT;



