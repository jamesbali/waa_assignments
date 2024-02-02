//v3
import React from "react";
import Post from "./Post";

const Posts = ({ posts, selectPost, activePost }) => {
  return (
    <div className="postsContainer">
      {posts.map((post) => (
        <Post
          key={post.id}
          post={post}
          selectPost={() => selectPost(post)}
          activePost={activePost}
        />
      ))}
    </div>
  );
};

export default Posts;
