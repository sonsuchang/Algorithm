-- 코드를 작성해주세요
SELECT PARENT.ID AS ID, COUNT(CHILD.ID) AS CHILD_COUNT FROM ECOLI_DATA PARENT
    LEFT JOIN ECOLI_DATA CHILD ON PARENT.ID = CHILD.PARENT_ID
GROUP BY PARENT.ID
ORDER BY ID