-- 코드를 작성해주세요
WITH NEW AS (
    SELECT YEAR(DIFFERENTIATION_DATE) AS YEAR,
    MAX(SIZE_OF_COLONY) AS MAX_SIZE
    FROM ECOLI_DATA
    GROUP BY YEAR(DIFFERENTIATION_DATE)
)

SELECT NEW.YEAR AS YEAR, (NEW.MAX_SIZE - SIZE_OF_COLONY) AS YEAR_DEV, ID
    FROM ECOLI_DATA D 
    JOIN NEW ON YEAR(D.DIFFERENTIATION_DATE) = NEW.YEAR
ORDER BY YEAR, YEAR_DEV