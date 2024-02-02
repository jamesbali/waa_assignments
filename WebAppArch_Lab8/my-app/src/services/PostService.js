// src/services/PostService.js
import axios from "axios";

const API_URL = "http://localhost:8080/api"; // Your Spring Boot application URL

const fetchPosts = () => axios.get(`${API_URL}/posts`);
const fetchPostById = (id) => axios.get(`${API_URL}/posts/${id}`);
const deletePost = (id) => axios.delete(`${API_URL}/posts/${id}`);
const addPost = (post) => axios.post(`${API_URL}/posts/create`, post);
const updatePost = (id, post) => axios.put(`${API_URL}/posts/${id}`, post);
const fetchCommentsByPostId = (postId) =>
  axios.get(`${API_URL}/posts/${postId}/comments`);
// Optional: Add comment functionality
const addComment = (postId, comment) =>
  axios.post(`${API_URL}/comments/posts/${postId}`, comment);

export {
  fetchPosts,
  fetchPostById,
  deletePost,
  addPost,
  addComment,
  updatePost,
  fetchCommentsByPostId,
};
