
SELECT 
ins.animal_id, ins.name -- , ins.datetime, outs.datetime, datediff(ins.datetime, outs.datetime)
from animal_ins as ins
inner join animal_outs as outs
on ins.animal_id = outs.animal_id
where timediff(outs.datetime, ins.datetime) < 0
order by ins.datetime;