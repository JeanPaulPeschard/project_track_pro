USE projecttrackpro;

-- Insert sample projects
INSERT INTO projects (name, description) VALUES
('Project Alpha', 'Description of Project Alpha'),
('Project Beta', 'Description of Project Beta'),
('Project Gamma', 'Description of Project Gamma');

-- Insert sample tasks for each project
INSERT INTO tasks (project_id, name, description, status, due_date) VALUES
(1, 'Task A1', 'Description for Task A1', 'To Do', '2023-11-15'),
(1, 'Task A2', 'Description for Task A2', 'In Progress', '2023-12-01'),
(2, 'Task B1', 'Description for Task B1', 'Completed', '2023-10-20'),
(2, 'Task B2', 'Description for Task B2', 'To Do', '2023-11-05'),
(3, 'Task C1', 'Description for Task C1', 'In Progress', '2023-12-10');
