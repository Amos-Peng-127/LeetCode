# Write your MySQL query statement below
SELECT DISTINCT l1.num AS ConsecutiveNums
FROM
    Logs l1
JOIN Logs l2 ON l1.Id = l2.Id - 1
JOIN Logs l3 ON l1.Id = l3.Id - 2
WHERE
    l1.num = l2.num AND l2.num = l3.num;