import React, { useState, FormEvent } from 'react';

interface ProjectFormProps {
  onSubmit: (projectData: { name: string; description: string }) => void;
}

const ProjectForm: React.FC<ProjectFormProps> = ({ onSubmit }) => {
  const [name, setName] = useState('');
  const [description, setDescription] = useState('');

  const handleSubmit = (e: FormEvent) => {
    e.preventDefault();

    if (!name || !description) {
      alert('Please fill in both fields');
      return;
    }

    // Call the parent component's onSubmit function with the form data
    onSubmit({ name, description });

    // Clear the form fields after submission
    setName('');
    setDescription('');
  };

  return (
    <form onSubmit={handleSubmit} className="project-form">
      <div className="form-group">
        <label htmlFor="name">Project Name:</label>
        <input
          type="text"
          id="name"
          value={name}
          onChange={(e) => setName(e.target.value)}
          required
        />
      </div>

      <div className="form-group">
        <label htmlFor="description">Description:</label>
        <textarea
          id="description"
          value={description}
          onChange={(e) => setDescription(e.target.value)}
          required
        />
      </div>

      <button type="submit" className="submit-button">Create Project</button>
    </form>
  );
};

export default ProjectForm;
