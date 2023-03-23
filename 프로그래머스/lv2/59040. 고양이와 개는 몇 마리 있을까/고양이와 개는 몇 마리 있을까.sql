-- 코드를 입력하세요
SELECT animal_type, count (animal_type)
from animal_ins
where animal_type = "cat"
union
SELECT animal_type, count (animal_type)
from animal_ins
where animal_type = "dog";

SELECT ANIMAL_TYPE, COUNT(ANIMAL_TYPE)
FROM ANIMAL_INS
GROUP BY ANIMAL_TYPE
ORDER BY ANIMAL_TYPE ASC;