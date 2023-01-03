회원 - 접속기록
접속한 기록이 없는 회원도 조회할 수 있는 방법 : 외부조인

select 회원.칼럼, 접속기록.칼럼
  from 회원 left outer join 접속기록 / from 접속기록 right outer join 회원
    on 회원.아이디 = 접속기록.아이디
 where months_between(sysdate, 접속기록.last_login_date) >= 12 -- 접속기록이 있는 회원
    or (months_between(sysdate, 회원.join_date) >= 12 and 접속기록.last_login_date is null)  -- 접속기록이 없는 회원

INSERT INTO SLEEP_USERS(USER_NO, ID, PW, NAME, GENDER, EMAIL, MOBILE, BIRTHYEAR, BIRTHDAY, POSTCODE, ROAD_ADDRESS, JIBUN_ADDRESS, DETAIL_ADDRESS, EXTRA_ADDRESS, AGREE_CODE, SNS_TYPE, JOIN_DATE, LAST_LOGIN_DATE)    
	(SELECT U.USER_NO, U.ID, U.PW, U.NAME, U.GENDER, U.EMAIL, U.MOBILE, U.BIRTHYEAR, U.BIRTHDAY, U.POSTCODE, U.ROAD_ADDRESS, U.JIBUN_ADDRESS, U.DETAIL_ADDRESS, U.EXTRA_ADDRESS, U.AGREE_CODE, U.SNS_TYPE, U.JOIN_DATE, A.LAST_LOGIN_DATE
	   FROM USERS U LEFT OUTER JOIN ACCESS_LOG A
		 ON U.ID = A.ID
	  WHERE MONTHS_BETWEEN(SYSDATE, A.LAST_LOGIN_DATE) >= 12 -- 접속기록이 있는 회원
         OR (MONTHS_BETWEEN(SYSDATE, U.JOIN_DATE) >= 12 AND A.LAST_LOGIN_DATE IS NULL));  -- 접속기록이 없는 회원    
    
DELETE FROM SLEEP_USERS;
COMMIT;


DELETE
  FROM 회원
 WHERE 회원.아이디 IN (삭제할 아이디);
 
DELETE
FROM USERS
WHERE ID IN (SELECT U.ID
FROM USERS U LEFT OUTER JOIN ACCESS_LOG A
ON U.ID = A.ID
WHERE MONTHS_BETWEEN(SYSDATE, A.LAST_LOGIN_DATE) >= 12
OR (MONTHS_BETWEEN(SYSDATE, U.JOIN_DATE) >= 12 AND A.LAST_LOGIN_DATE IS NULL));

-- 아이디가 파라미터로 제공됨

-- sleep_users -> users
INSERT INTO USERS(USER_NO, ID, PW, NAME, GENDER, EMAIL, MOBILE, BIRTHYEAR, BIRTHDAY, POSTCODE, ROAD_ADDRESS, JIBUN_ADDRESS, DETAIL_ADDRESS, EXTRA_ADDRESS, AGREE_CODE, SNS_TYPE, JOIN_DATE)
(SELECT USER_NO, ID, PW, NAME, GENDER, EMAIL, MOBILE, BIRTHYEAR, BIRTHDAY, POSTCODE, ROAD_ADDRESS, JIBUN_ADDRESS, DETAIL_ADDRESS, EXTRA_ADDRESS, AGREE_CODE, SNS_TYPE, JOIN_DATE
  FROM SLEEP_USERS
 WHERE ID = #{id})

-- sleep_users delete
DELETE
  FROM SLEEP_USERS
  WHERE ID = #{id}

rollback;










