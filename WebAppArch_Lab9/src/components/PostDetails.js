// src/components/PostDetails.js
import React, { useState, useContext } from 'react';
import { deletePost, updatePost } from '../services/PostService';
import { PostContext } from '../PostContext';
import EditPost from './EditPost';
import Comment from './Comment';

const PostDetails = ({ post }) => {
  const [editing, setEditing] = useState(false);
  const { refreshPosts } = useContext(PostContext);

  const handleDeleteClick = async () => {
    if (window.confirm('Are you sure you want to delete this post?')) {
      try {
        await deletePost(post.id);
        refreshPosts();
      } catch (error) {
        console.error('Error deleting post:', error);
      }
    }
  };

  const handleEditClick = () => {
    setEditing(true);
  };

  return (
    <div className="post-details">
      {!editing ? (
        <>
          <h2>{post.title}</h2>
          <p>ID: {post.id}</p>
          <p>Author: {post.author}</p>
          {post.comments &&
            post.comments.map((comment) => (
              <Comment key={comment.id} {...comment} />
            ))}
          <button onClick={handleEditClick}>Edit</button>
          <button onClick={handleDeleteClick}>Delete</button>
        </>
      ) : (
        <EditPost post={post} setEditing={setEditing} />
      )}
    </div>
  );
};

export default PostDetails;
