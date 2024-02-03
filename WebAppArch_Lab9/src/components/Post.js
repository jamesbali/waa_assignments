// src/components/Post.js
import React, { useContext } from 'react';
import { PostContext } from '../PostContext';

const Post = ({ post }) => {
  const { selectedPostId, setSelectedPostId } = useContext(PostContext);

  return (
    <div
      className={`post ${post.id === selectedPostId ? 'active-post' : ''}`}
      onClick={() => setSelectedPostId(post.id)}
    >
      <p>ID: {post.id}</p>
      <h3>Title: {post.title}</h3>
      <p>Author: {post.author}</p>
    </div>
  );
};

export default Post;
