-- 코드를 입력하세요
with info as (
    select c.car_id, c.car_type, c.daily_fee, p.duration_type, p.discount_rate
        from car_rental_company_car c
        left join car_rental_company_discount_plan p on c.car_type = p.car_type
    where c.car_type = "트럭"
),

history as (
    select h.car_id, datediff(h.end_date, h.start_date) + 1 as rental_day, daily_fee,
        history_id
        from car_rental_company_rental_history h
        join car_rental_company_car c on h.car_id = c.car_id
    where c.car_type = "트럭"
),

no_discount as (
    select history_id, daily_fee * rental_day as fee from history
    where rental_day < 7
),

discount as (
    select car_id, daily_fee, rental_day,
    case
    when rental_day < 30 then 7
    when rental_day < 90 then 30
    else 90
    end as rental_info, history_id
    from history
    where rental_day >= 7
),

discount_info as (
    select car_id, car_type, daily_fee, discount_rate,
        case
        when duration_type like "90%" then 90
        when duration_type like "30%" then 30
        when duration_type like "7%" then 7
        end as duration_type
        from info
),

result as (
    select d.history_id,
    round((i.daily_fee - i.daily_fee * (discount_rate * 0.01)) * rental_day) as fee
    from discount d
    join discount_info i on d.car_id = i.car_id and d.rental_info = i.duration_type
    union
    select * from no_discount
)

select * from result
order by fee desc, history_id desc