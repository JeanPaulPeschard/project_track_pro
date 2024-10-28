import React from 'react';
import { render, screen } from '@testing-library/react';
import '@testing-library/jest-dom';
import { AuthProvider, useAuth } from '@context/AuthContext';

const TestComponent = () => {
    const { user, login, logout } = useAuth();
    return (
        <div>
            <p>{user ? `Logged in as: ${user}` : 'Not logged in'}</p>
            <button onClick={() => login('testuser')}>Login</button>
            <button onClick={logout}>Logout</button>
        </div>
    );
};

describe('AuthContext', () => {
    test('allows login and logout', () => {
        render(
            <AuthProvider>
                <TestComponent />
            </AuthProvider>
        );

        expect(screen.getByText('Not logged in')).toBeInTheDocument();

        screen.getByText('Login').click();
        expect(screen.getByText('Logged in as: testuser')).toBeInTheDocument();

        screen.getByText('Logout').click();
        expect(screen.getByText('Not logged in')).toBeInTheDocument();
    });
});
