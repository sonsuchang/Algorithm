-- 코드를 작성해주세요
WITH HR_DATA AS (
    SELECT EMP_NO, AVG(SCORE) AS SCORE FROM HR_GRADE
    GROUP BY EMP_NO
)

SELECT D.EMP_NO, E.EMP_NAME, CASE
                            WHEN SCORE >= 96 THEN "S"
                            WHEN SCORE >= 90 THEN "A"
                            WHEN SCORE >= 80 THEN "B"
                            ELSE "C" END AS GRADE,
                                CASE
                                WHEN SCORE >= 96 THEN E.SAL * 0.2
                                WHEN SCORE >= 90 THEN E.SAL * 0.15
                                WHEN SCORE >= 80 THEN E.SAL * 0.1
                                ELSE 0 END AS BONUS
                            FROM HR_DATA D
    JOIN HR_EMPLOYEES E ON D.EMP_NO = E.EMP_NO
ORDER BY EMP_NO