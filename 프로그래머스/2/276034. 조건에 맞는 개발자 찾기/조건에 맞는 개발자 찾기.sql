-- 코드를 작성해주세요
SELECT DISTINCT(D.ID), EMAIL, FIRST_NAME, LAST_NAME FROM DEVELOPERS D
    JOIN SKILLCODES S ON D.SKILL_CODE & S.CODE
WHERE S.NAME = "Python" OR S.NAME = "C#"
ORDER BY D.ID