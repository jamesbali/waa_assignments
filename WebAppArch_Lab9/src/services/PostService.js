// src/services/PostService.js
import axios from 'axios';

const API_URL = 'http://localhost:8080/api/v1'; // Your Spring Boot application URL

const fetchPosts = () => axios.get(`${API_URL}/posts`);
const fetchPostById = (id) => axios.get(`${API_URL}/posts/${id}`);
const deletePost = (id) => axios.delete(`${API_URL}/posts/${id}`);
const addPost = (post) => axios.post(`${API_URL}/posts`, post);
const updatePost = (id, post) => axios.put(`${API_URL}/posts/${id}`,post);
// Optional: Add comment functionality
const addComment = (postId, comment) => axios.post(`${API_URL}/comments/posts/${postId}`, comment);

export { fetchPosts, fetchPostById, deletePost, addPost, addComment, updatePost };
