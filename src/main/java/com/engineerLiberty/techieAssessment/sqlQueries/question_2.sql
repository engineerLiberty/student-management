SELECT g.yr, c.country
FROM games g
JOIN city c ON g.city = c.name;
