import React, { useState } from "react";
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

export default Dashboard;
