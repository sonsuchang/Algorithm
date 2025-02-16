-- 코드를 입력하세요
WITH MOST_VIEWS AS (
    SELECT BOARD_ID FROM USED_GOODS_BOARD
    ORDER BY VIEWS DESC
    LIMIT 1
)

SELECT CONCAT("/home/grep/src/", BOARD_ID, "/", FILE_ID, FILE_NAME, FILE_EXT)
    AS FILE_PATH FROM USED_GOODS_FILE 
WHERE BOARD_ID IN (
    SELECT * FROM MOST_VIEWS
)
ORDER BY FILE_ID DESC