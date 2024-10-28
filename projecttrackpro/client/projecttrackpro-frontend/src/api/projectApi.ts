import axios from 'axios';

const api = axios.create({
  baseURL: process.env.REACT_APP_API_URL || 'http://localhost:8080/api',
});

export const fetchProjects = async () => {
  const response = await api.get('/projects');
  return response.data;
};

export const createProject = async (projectData: { name: string; description: string }) => {
  const response = await api.post('/projects', projectData);
  return response.data;
};

export const fetchTasks = async (projectId: string) => {
  const response = await api.get(`/projects/${projectId}/tasks`);
  return response.data;
};
