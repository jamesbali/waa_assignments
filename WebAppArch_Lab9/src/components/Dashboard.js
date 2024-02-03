// src/components/Dashboard.js
import React, { useState, useEffect } from 'react';
import { fetchPosts } from '../services/PostService';
import Posts from './Posts';
import PostDetails from './PostDetails';
import AddPost from './AddPost';
import { useNavigate } from 'react-router-dom';

const Dashboard = () => {
  const [posts, setPosts] = useState([]);
  const [selectedPost, setSelectedPost] = useState(null);
  
  const navigate = useNavigate();

  useEffect(() => {
    refreshPosts();
  }, []);

  const refreshPosts = async () => {
    try {
      const response = await fetchPosts();
      setPosts(response.data);
    } catch (error) {
      console.error('Error fetching posts:', error);
    }
  };

  const handleSelectPost = (post) => {
    setSelectedPost(post);
    navigate('/post-details'); // Assuming you have a route set up for this
  };

  return (
    <div>
    {/* <AddPost refreshPosts={refreshPosts} />*/}
      <Posts posts={posts} onSelectPost={handleSelectPost} />
      {selectedPost && <PostDetails post={selectedPost} refreshPosts={refreshPosts} />}
    </div>
  );
};

export default Dashboard;
