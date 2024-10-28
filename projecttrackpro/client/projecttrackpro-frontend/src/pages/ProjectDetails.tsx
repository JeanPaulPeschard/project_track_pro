import React from 'react';
import TaskBoard from '../components/TaskBoard';
import { useParams } from 'react-router-dom';

const ProjectDetail: React.FC = () => {
  const { projectId } = useParams<{ projectId: string }>();

  return (
    <div>
      <h2>Project Details</h2>
      <TaskBoard projectId={projectId || ''} />
    </div>
  );
};

export default ProjectDetail;
