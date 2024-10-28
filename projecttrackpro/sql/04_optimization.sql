USE projecttrackpro;

-- Create a view to get project summaries, including the number of tasks and completed tasks
CREATE VIEW project_summary AS
SELECT p.id AS project_id, p.name AS project_name,
       COUNT(t.id) AS total_tasks,
       SUM(CASE WHEN t.status = 'Completed' THEN 1 ELSE 0 END) AS completed_tasks
FROM projects p
LEFT JOIN tasks t ON p.id = t.project_id
GROUP BY p.id;

-- View the optimized project summary view
SELECT * FROM project_summary;

-- Example of using an EXPLAIN statement to optimize a query
EXPLAIN SELECT * FROM tasks WHERE status = 'In Progress';

-- Optimize: Use indexing for frequently searched fields like status and project_id
ALTER TABLE tasks ADD INDEX idx_status_project_id (status, project_id);
