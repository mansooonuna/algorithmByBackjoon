-- 코드를 입력하세요
SELECT p.product_code, sum(p.price * o.sales_amount) as sales from product p
inner join offline_sale o
on p.product_id = o.product_id
group by p.product_code
order by sum(p.price * o.sales_amount) desc, product_code asc