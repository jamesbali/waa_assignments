// Dashboard.js
import React, { useState, useEffect } from "react";
import Posts from "./Posts";
import PostDetails from "./PostDetails";
import AddPost from "./AddPost";
import axios from "axios";

const Dashboard = () => {
  const [posts, setPosts] = useState([]);
  const [selectedPost, setSelectedPost] = useState(null);

  useEffect(() => {
    const fetchPosts = async () => {
      try {
        const response = await axios.get("http://localhost:8080/api/posts");

        setPosts(response.data);
      } catch (error) {
        console.error("Failed to fetch posts:", error);
      }
    };
    fetchPosts();
  }, []);

  const handlePostSelected = (post) => {
    setSelectedPost(post);
  };

  const handlePostAdded = (newPost) => {
    setPosts([...posts, newPost]);
  };

  const handlePostDeleted = (postId) => {
    setPosts(posts.filter((post) => post.id !== postId));
    if (selectedPost?.id === postId) {
      setSelectedPost(null); // Deselect if deleted
    }
  };

  return (
    <div>
      <AddPost onPostAdded={handlePostAdded} />
      <Posts posts={posts} onSelectPost={handlePostSelected} />
      {selectedPost && (
        <PostDetails post={selectedPost} onDelete={handlePostDeleted} />
      )}
    </div>
  );
};

export default Dashboard;

/*import React, { useState } from "react";
import Posts from "./Posts";
import PostDetails from "./PostDetails";

const Dashboard = () => {
  const [title, setTitle] = useState("");
  const [selectedPost, setSelectedPost] = useState(null);

  const handleInput = (e) => {
    setTitle(e.target.value);
  };

  const handleUpdate = () => {
    console.log(`Updating title to ${title}`);
    setTitle("");
  };
  const selectPost = (post) => {
    console.log(post.id);
    setSelectedPost(post);
  };

  return (
    <div>
      <Posts onSelectPost={selectPost} activePost={selectedPost?.id} />
      <PostDetails post={selectedPost} />

      <input
        type="text"
        value={title}
        onChange={handleInput}
        placeholder="Enter new title"
      />
      <button onClick={handleUpdate}>Update Title</button>
    </div>
  );
};

export default Dashboard;*/
