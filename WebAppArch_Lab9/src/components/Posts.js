// src/components/Posts.js
import React from 'react';
import Post from './Post';

const Posts = ({ posts, selectPost }) => {
  return (
    <div className="postsContainer">
      {posts.map((post) => (
        <Post key={post.id} post={post} selectPost={selectPost} />
      ))}
    </div>
  );
};

export default Posts;
