import { Container, Form, Button, Alert } from 'react-bootstrap';
import { useState } from 'react';
import axios from 'axios';

function Register() {
    const [formData, setFormData] = useState({
        userName: '',
        email: '',
        number: '',
        dateOfBirth: '',
        password: ''
    });

    const [errors, setErrors] = useState({
        userName: '',
        email: '',
        number: '',
        dateOfBirth: '',
        password: ''
    });

    const [successMessage, setSuccessMessage] = useState('');

    const validateForm = () => {
        const newErrors = {};
        let isValid = true;

        if (!formData.username) {
            newErrors.username = 'Username is required';
            isValid = false;
        }
        if (!formData.email) {
            newErrors.email = 'Email is required';
            isValid = false;
        }
        if (!formData.number) {
            newErrors.number = 'Phone number is required';
            isValid = false;
        }
        if (!formData.dateOfBirth) {
            newErrors.dateOfBirth = 'Date of birth is required';
            isValid = false;
        }

        setErrors(newErrors);
        return isValid;
    };

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({ ...formData, [name]: value });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();

        if (validateForm()) {
            let response = await axios.post("http://localhost:8080/admin/post/user", formData)
            console.log(response);
            setSuccessMessage(response.data);
            setErrors({});
        }
    };

    return (
        <div className="Register">
            <Container className="mt-5">
                <h2>Login Form</h2>
                {successMessage && <Alert variant="success">{successMessage}</Alert>}
                <Form onSubmit={handleSubmit}>
                    <Form.Group controlId="formUsername">
                        <Form.Label>Username</Form.Label>
                        <Form.Control
                            type="text"
                            placeholder="Enter your username"
                            name="userName"
                            value={formData.userName}
                            onChange={handleChange}
                            isInvalid={!!errors.userName}
                        />
                        <Form.Control.Feedback type="invalid">
                            {errors.userName}
                        </Form.Control.Feedback>
                    </Form.Group>

                    <Form.Group controlId="formEmail">
                        <Form.Label>Email address</Form.Label>
                        <Form.Control
                            type="email"
                            placeholder="Enter your email"
                            name="email"
                            value={formData.email}
                            onChange={handleChange}
                            isInvalid={!!errors.email}
                        />
                        <Form.Control.Feedback type="invalid">
                            {errors.email}
                        </Form.Control.Feedback>
                    </Form.Group>

                    <Form.Group controlId="formnumber">
                        <Form.Label>Phone Number</Form.Label>
                        <Form.Control
                            type="tel"
                            placeholder="Enter your phone number"
                            name="number"
                            value={formData.number}
                            onChange={handleChange}
                            isInvalid={!!errors.number}
                        />
                        <Form.Control.Feedback type="invalid">
                            {errors.number}
                        </Form.Control.Feedback>
                    </Form.Group>

                    <Form.Group controlId="formDateOfBirth">
                        <Form.Label>Date of Birth</Form.Label>
                        <Form.Control
                            type="date"
                            name="dateOfBirth"
                            value={formData.dateOfBirth}
                            onChange={handleChange}
                            isInvalid={!!errors.dateOfBirth}
                        />
                        <Form.Control.Feedback type="invalid">
                            {errors.dateOfBirth}
                        </Form.Control.Feedback>
                    </Form.Group>

                    <Form.Group controlId="formPassword">
                        <Form.Label>Password</Form.Label>
                        <Form.Control
                            type="text"
                            placeholder="Enter your password"
                            name="password"
                            value={formData.password}
                            onChange={handleChange}
                            isInvalid={!!errors.password}
                        />
                        <Form.Control.Feedback type="invalid">
                            {errors.password}
                        </Form.Control.Feedback>
                    </Form.Group>

                    <Button variant="primary" type="submit">
                        Submit
                    </Button>
                </Form>
            </Container>
        </div>
    )
}

export default Register;