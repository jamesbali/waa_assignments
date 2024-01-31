import React from "react";
import Post from "./Post";

const Posts = ({ onSelectPost, activePost }) => {
  // Sample data for posts
  const postData = [
    { id: 1, title: "Algorithm", author: "Prof Clyde" },
    { id: 2, title: "Web Application", author: "Prof Dean" },
    { id: 3, title: "Enterprise Arch", author: "Prof Tina" },
    { id: 4, title: "Software Arch", author: "Prof Rene" },
    { id: 11, title: "Algorithm", author: "Prof Clyde" },
    { id: 12, title: "Web Application", author: "Prof Dean" },
    { id: 13, title: "Enterprise Arch", author: "Prof Tina" },
    { id: 14, title: "Software Arch", author: "Prof Rene" },
    { id: 21, title: "Algorithm", author: "Prof Clyde" },
    { id: 22, title: "Web Application", author: "Prof Dean" },
    { id: 23, title: "Enterprise Arch", author: "Prof Tina" },
    { id: 24, title: "Software Arch", author: "Prof Rene" },
    // Add more posts here
  ];

  return (
    <div className="postsContainer">
      {postData.map((post) => (
        // <div onClick={() => onSelectPost(post)} key={post.id}>
        <Post
          key={post.id}
          {...post}
          onSelectPost={onSelectPost}
          activePost={activePost}
        />
        // </div>
      ))}
    </div>
  );
};

export default Posts;
