# Write your MySQL query statement below
-- WITH RankDate AS (
--     SELECT
--         player_id,
--         event_date,
--         RANK() OVER (
--             PARTITION BY player_id
--             ORDER BY event_date ASC
--         ) as rnk
--     FROM Activity
-- )
-- SELECT
--     player_id,
--     event_date AS first_login
-- FROM RankDate
-- WHERE rnk = 1;

SELECT 
    player_id, 
    MIN(event_date) AS first_login
FROM Activity
GROUP BY player_id;