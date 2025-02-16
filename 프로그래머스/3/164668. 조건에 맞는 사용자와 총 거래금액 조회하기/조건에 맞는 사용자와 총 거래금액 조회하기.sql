-- 코드를 입력하세요
WITH USER_SALES AS (
    SELECT WRITER_ID, SUM(PRICE) AS TOTAL_SALES FROM USED_GOODS_BOARD
    WHERE STATUS = "DONE"
    GROUP BY WRITER_ID
)

SELECT U.USER_ID, NICKNAME, S.TOTAL_SALES FROM USED_GOODS_USER U
    JOIN USER_SALES S ON U.USER_ID = S.WRITER_ID
WHERE S.TOTAL_SALES >= 700000
ORDER BY S.TOTAL_SALES