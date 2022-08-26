DROP USER SCOTT CASCADE;    -- 테이블이 많이 존재함으로 CASCADE를 기입해야함

CREATE USER SCOTT IDENTIFIED BY TIGER;

GRANT CONNECT, RESOURCE TO SCOTT;    -- 접속 권한과 리소스 권한 부여해야 접속이 가능