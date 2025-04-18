-- 코드를 작성해주세요
WITH SUM_EMPLOYEES AS (
    SELECT DEPT_ID, ROUND(AVG(SAL)) AS AVG_SAL FROM HR_EMPLOYEES
    GROUP BY DEPT_ID
)

SELECT D.DEPT_ID, D.DEPT_NAME_EN, E.AVG_SAL FROM HR_DEPARTMENT D
    JOIN SUM_EMPLOYEES E ON D.DEPT_ID = E.DEPT_ID
ORDER BY E.AVG_SAL DESC