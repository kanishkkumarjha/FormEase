import React from 'react';
import { Link } from 'react-router-dom';
import './ThankYou.css';
const ThankYou = () => {
    return (
        <div className="container2">
            <h1>Thank You!</h1>
            <p>Thank you for submitting the form. We appreciate your time and effort.</p>
            <Link to="/" className="back-button">Go Back to Home</Link>
        </div>
    );
};

export default ThankYou;
