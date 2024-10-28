import React, { useEffect, useState } from 'react';
import { fetchTasks } from '../api/projectApi';
import { Task } from '../types';

interface TaskBoardProps {
  projectId: string;
}

const TaskBoard: React.FC<TaskBoardProps> = ({ projectId }) => {
  const [tasks, setTasks] = useState<Task[]>([]);

  useEffect(() => {
    const getTasks = async () => {
      const data = await fetchTasks(projectId);
      setTasks(data);
    };
    getTasks();
  }, [projectId]);

  return (
    <div>
      <h3>Tasks</h3>
      <ul>
        {tasks.map((task) => (
          <li key={task.id}>{task.title}</li>
        ))}
      </ul>
    </div>
  );
};

export default TaskBoard;
