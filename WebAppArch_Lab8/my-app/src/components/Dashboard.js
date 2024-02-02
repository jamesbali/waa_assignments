//version 3

import React, { useState, useEffect } from "react";
import { fetchPosts } from "../services/PostService";
import Posts from "./Posts";
import PostDetails from "./PostDetails";
import AddPost from "./AddPost";

const Dashboard = () => {
  const [posts, setPosts] = useState([]);
  const [selectedPost, setSelectedPost] = useState(null);

  // useEffect hook to fetch posts when the component mounts
  useEffect(() => {
    refreshPosts();
  }, []);

  // Function to refresh the list of posts from the backend
  const refreshPosts = async () => {
    try {
      const response = await fetchPosts();
      setPosts(response.data); // Update the posts state with the fetched data
    } catch (error) {
      console.error("Error fetching posts:", error);
    }
  };

  // Function to select a post and show its details
  const selectPost = (post) => {
    setSelectedPost(post);
  };

  const handlePostAdded = () => {
    refreshPosts();
  };

  return (
    <div>
      <AddPost refreshPosts={handlePostAdded} />{" "}
      {/* AddPost component to add new posts */}
      <Posts posts={posts} selectPost={selectPost} />
      {selectedPost && (
        <PostDetails post={selectedPost} refreshPosts={refreshPosts} />
      )}
    </div>
  );
};

export default Dashboard;
