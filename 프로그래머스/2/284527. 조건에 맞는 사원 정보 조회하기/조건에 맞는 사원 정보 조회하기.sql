-- 코드를 작성해주세요
SELECT SUM(SCORE) AS SCORE, G.EMP_NO, EMP_NAME, POSITION, EMAIL FROM HR_EMPLOYEES E
    JOIN HR_GRADE G ON E.EMP_NO = G.EMP_NO
GROUP BY G.EMP_NO
ORDER BY SUM(SCORE) DESC
LIMIT 1