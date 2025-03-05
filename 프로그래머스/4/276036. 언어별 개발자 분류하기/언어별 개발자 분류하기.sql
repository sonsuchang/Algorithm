-- 코드를 작성해주세요
with cte as (
    select * from developers d
        left join skillcodes s on d.skill_code & s.code
),

A_sub as (
    select id from cte
    where name = "Python"
),

A as (
    select "A" as Grade, id, email from cte
    where id in (
        select * from A_sub
    ) and category = "Front End"
),

B as (
    select "B" as Grade, id, email from cte
    where name = "C#" and id not in (
        select id from A
    )
),

C as (
    select "C" as Grade, id, email from cte
    where category = "Front End" and id not in (
        select id from A
        union
        select id from B
    )
),

result as (
    select * from A
    union
    select * from B
    union
    select * from C
)

select * from result
order by Grade, id