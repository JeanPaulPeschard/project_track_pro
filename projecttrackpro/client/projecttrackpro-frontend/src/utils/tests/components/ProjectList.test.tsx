import React from 'react';
import { render, screen } from '@testing-library/react';
import '@testing-library/jest-dom';
import ProjectList from '@components/ProjectList';
import { AuthProvider } from '@context/AuthContext';

describe('ProjectList Component', () => {
    test('displays project names', async () => {
        const projects = [
            { id: 1, name: 'Project Alpha', description: 'First project' },
            { id: 2, name: 'Project Beta', description: 'Second project' },
        ];

        render(
            <AuthProvider>
                <ProjectList projects={projects} />
            </AuthProvider>
        );

        expect(screen.getByText('Project Alpha')).toBeInTheDocument();
        expect(screen.getByText('Project Beta')).toBeInTheDocument();
    });
});
