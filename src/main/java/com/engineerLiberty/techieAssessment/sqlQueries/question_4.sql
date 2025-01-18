-- Query to select userId and the average session duration for each user
-- who has more than one session.
SELECT userId, AVG(duration) AS AverageDuration
FROM sessions
GROUP BY userId
HAVING COUNT(id) > 1;
