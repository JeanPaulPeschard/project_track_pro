USE projecttrackpro;

-- Retrieve all projects with task counts
SELECT p.id, p.name, p.description, COUNT(t.id) AS task_count
FROM projects p
LEFT JOIN tasks t ON p.id = t.project_id
GROUP BY p.id;

-- Retrieve tasks that are overdue
SELECT t.id, t.name, t.due_date, p.name AS project_name
FROM tasks t
JOIN projects p ON t.project_id = p.id
WHERE t.status != 'Completed' AND t.due_date < CURDATE();

-- Retrieve all tasks for a specific project
SELECT t.id, t.name, t.status, t.due_date
FROM tasks t
WHERE t.project_id = 1;

-- List completed projects with the count of completed tasks
SELECT p.id, p.name, COUNT(t.id) AS completed_tasks
FROM projects p
JOIN tasks t ON p.id = t.project_id
WHERE t.status = 'Completed'
GROUP BY p.id;
