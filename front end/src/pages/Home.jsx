import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import {Navbar, Button} from 'react-bootstrap';
import NavDropdown from 'react-bootstrap/NavDropdown';
import { Link, Outlet } from 'react-router-dom';
import Table from 'react-bootstrap/Table';
import { useEffect, useState } from 'react';
import axios from 'axios';

function Home() {
    return (
        <div className="home">
            <Navbar expand="lg" className="bg-body-tertiary">
                <Container>
                    <Navbar.Brand ><Link to="/">CRUD</Link></Navbar.Brand>
                    <Navbar.Toggle aria-controls="basic-navbar-nav" />
                    <Navbar.Collapse id="basic-navbar-nav">
                        <Nav className="me-auto">
                            <Nav.Link href="#home">Home</Nav.Link>
                            <Nav.Link href="#link">Product</Nav.Link>
                            <Nav.Link href="#link">Cart</Nav.Link>
                            <Nav.Link href="#link">Login</Nav.Link>
                            <Nav.Link><Link to="/register">Register</Link></Nav.Link>

                        </Nav>
                    </Navbar.Collapse>
                </Container>
            </Navbar>

            <Outlet />
        </div>
    )
}

function Empty() {
    const [userdetails, setUserDetails ] = useState([])
    useEffect(()=>{
        getUsers()
    },[])
    async function getUsers (){
       let resopnse= await axios.get("http://localhost:8080/admin/get/user")
    setUserDetails(resopnse.data)
    console.log(resopnse.data);
    
       
    }
    return (
        <div>
            <Table striped bordered hover>
                <thead>
                    <tr>
                        <th>id</th>
                        <th>Username</th>
                        <th>Email</th>
                        <th>Number</th>
                        <th>Date of Birth</th>
                        <th>Password</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {userdetails.map((data, index)=>(
                        <tr key={index}>
                            <td>{data.id}</td>
                            <td>{data.userName}</td>
                            <td>{data.email}</td>
                            <td>{data.number}</td>
                            <td>{data.dateOfBirth}</td>
                            <td>{data.password}</td>
                            <td>
                            <Button variant="warning">Update</Button>
                            <Button variant="danger">Delete</Button>
                            </td>
                        </tr>
                    ))}
                   
                </tbody>
            </Table>
        </div>
    )
}
export { Home, Empty }
