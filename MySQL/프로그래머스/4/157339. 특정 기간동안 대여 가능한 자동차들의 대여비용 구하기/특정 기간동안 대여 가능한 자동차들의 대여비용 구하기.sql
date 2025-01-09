SELECT 
    R.CAR_ID
    ,R.CAR_TYPE
    ,FLOOR(R.DAILY_FEE * 30 * (1 - P.DISCOUNT_RATE/100)) AS FEE
FROM CAR_RENTAL_COMPANY_CAR R
LEFT JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN P
    ON R.CAR_TYPE = P.CAR_TYPE
    AND P.DURATION_TYPE = '30일 이상'
    AND R.CAR_TYPE IN ('SUV', '세단')
LEFT JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY H
    ON R.CAR_ID = H.CAR_ID
    AND H.START_DATE <= '2022-11-30'
    AND H.END_DATE >= '2022-11-01'
WHERE H.START_DATE IS NULL
HAVING FEE >= 500000 AND FEE < 2000000
ORDER BY FEE DESC, CAR_TYPE ASC, CAR_ID DESC