import { useEffect, useState } from 'react';
import { fetchProjects } from '../api/projectApi';
import { Project } from '../types';

const useFetchProjects = () => {
  const [projects, setProjects] = useState<Project[]>([]);

  useEffect(() => {
    const fetchData = async () => {
      const data = await fetchProjects();
      setProjects(data);
    };
    fetchData();
  }, []);

  return projects;
};

export default useFetchProjects;
