import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import HomePage from './HomePage';
import UserForm from './UserForm';
import SubmittedForms from './ThankYou';


function App() {
    return (
        <Router>
            <Routes>
                <Route path="/" element={<HomePage />} />
                <Route path="/user-form" element={<UserForm />} />
                <Route path="/thank-you" element={<SubmittedForms />} />
            </Routes>
        </Router>
    );
};

export default App;