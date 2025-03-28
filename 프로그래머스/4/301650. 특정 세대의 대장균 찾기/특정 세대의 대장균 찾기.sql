-- 코드를 작성해주세요
SELECT ID FROM ECOLI_DATA
WHERE PARENT_ID IN (
    SELECT ID FROM ECOLI_DATA
    WHERE ID IN (
        SELECT CHILD.ID FROM ECOLI_DATA PARENT
            LEFT JOIN ECOLI_DATA CHILD ON PARENT.ID = CHILD.PARENT_ID
        WHERE PARENT.PARENT_ID IS NULL
    )
)
ORDER BY ID