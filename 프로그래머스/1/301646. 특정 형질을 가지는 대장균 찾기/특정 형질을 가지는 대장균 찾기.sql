-- 코드를 작성해주세요
SELECT COUNT(ID) AS COUNT FROM ECOLI_DATA
WHERE 1=1 AND (2 != GENOTYPE & 2) AND ((GENOTYPE & 1 = 1) OR (GENOTYPE & 4 = 4))