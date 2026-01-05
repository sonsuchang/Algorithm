-- 코드를 작성해주세요
WITH CTE AS (
    SELECT ID,
        PERCENT_RANK() OVER(ORDER BY SIZE_OF_COLONY DESC) * 100 AS R
    FROM ECOLI_DATA
)

SELECT ID, CASE
            WHEN R <= 25 THEN "CRITICAL"
            WHEN R <= 50 THEN "HIGH"
            WHEN R <= 75 THEN "MEDIUM"
            ELSE "LOW"
            END AS COLONY_NAME
        FROM CTE
ORDER BY ID