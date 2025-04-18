-- 코드를 입력하세요
WITH INFO AS (
    SELECT B.BOOK_ID, B.CATEGORY, B.AUTHOR_ID,
    SUM(S.SALES) * PRICE AS BOOK_TOTAL_SALE FROM BOOK B
        JOIN BOOK_SALES S ON B.BOOK_ID = S.BOOK_ID
    WHERE S.SALES_DATE LIKE "2022-01%"
    GROUP BY B.BOOK_ID
)
SELECT I.AUTHOR_ID, A.AUTHOR_NAME, I.CATEGORY,
    SUM(I.BOOK_TOTAL_SALE) AS TOTAL_SALES FROM INFO I
    JOIN AUTHOR A ON I.AUTHOR_ID = A.AUTHOR_ID
GROUP BY AUTHOR_ID, CATEGORY
ORDER BY I.AUTHOR_ID, I.CATEGORY DESC