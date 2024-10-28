import React from 'react';
import { render, screen, fireEvent } from '@testing-library/react';
import '@testing-library/jest-dom';
import ProjectForm from '@components/ProjectForm';

describe('ProjectForm Component', () => {
    test('submits project data', () => {
        const handleSubmit = jest.fn();
        render(<ProjectForm onSubmit={handleSubmit} />);

        fireEvent.change(screen.getByLabelText(/Project Name/i), { target: { value: 'Test Project' } });
        fireEvent.change(screen.getByLabelText(/Description/i), { target: { value: 'Project description' } });

        fireEvent.click(screen.getByText('Submit'));

        expect(handleSubmit).toHaveBeenCalledWith({
            name: 'Test Project',
            description: 'Project description'
        });
    });
});
