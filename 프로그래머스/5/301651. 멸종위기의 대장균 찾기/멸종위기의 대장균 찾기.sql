-- 코드를 작성해주세요
WITH RECURSIVE ECOLI AS (
    SELECT ID, PARENT_ID, 1 AS GENERATION FROM ECOLI_DATA
    WHERE PARENT_ID IS NULL
    UNION ALL
    SELECT CHILD.ID, CHILD.PARENT_ID, PARENT.GENERATION + 1 FROM ECOLI_DATA CHILD
        JOIN ECOLI PARENT ON PARENT.ID = CHILD.PARENT_ID
)
SELECT COUNT(GENERATION) AS COUNT, GENERATION FROM ECOLI P
    LEFT JOIN ECOLI_DATA C ON P.ID = C.PARENT_ID
WHERE C.PARENT_ID IS NULL
GROUP BY GENERATION
ORDER BY GENERATION