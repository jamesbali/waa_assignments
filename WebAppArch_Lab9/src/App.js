// src/App.js
import React from 'react';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import Dashboard from './components/Dashboard';
import AddPost from './components/AddPost';
import Login from './components/Login';
import { PostProvider } from './PostContext';
import PostDetails from './components/PostDetails';
import './App.css';

function App() {
  return (
    <PostProvider>
      <Router>
        <div className="App">
          <header className="App-header" id="begin">
            <Link to="/">Dashboard</Link> | <Link to="/add-post">Add New Post</Link> | <Link to="/login">Login</Link>
          </header>
          <Routes>
            <Route path="/" element={<Dashboard />} />
            <Route path="/add-post" element={<AddPost />} />
            <Route path="/post-details" element={<PostDetails />} />
            <Route path="/login" element={<Login />} />
          </Routes>
        </div>
      </Router>
    </PostProvider>
  );
}

export default App;
