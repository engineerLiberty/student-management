--A LEFT JOIN returns all records from the left table (games), and the matching records from the right table (city).
--If there is no match, NULL is returned for columns from the right table.

SELECT g.yr, g.city, c.country
FROM games g
LEFT JOIN city c ON g.city = c.name;
