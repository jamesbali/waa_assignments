// src/components/EditPost.js
import React, { useState } from 'react';
import { updatePost } from '../services/PostService';

const EditPost = ({ post, setEditing }) => {
  const [editedPost, setEditedPost] = useState({ ...post });

  const handleChange = (event) => {
    const { name, value } = event.target;
    setEditedPost({ ...editedPost, [name]: value });
  };

  const handleSubmit = async (event) => {
    event.preventDefault();
    try {
      await updatePost(editedPost.id, editedPost);
      setEditing(false);
    } catch (error) {
      console.error('Error updating post:', error);
    }
  };

  return (
    <form onSubmit={handleSubmit} className="editPostForm">
      <input
        name="title"
        value={editedPost.title}
        onChange={handleChange}
        placeholder="Title"
        required
      />
      <input
        name="author"
        value={editedPost.author}
        onChange={handleChange}
        placeholder="Author"
        required
      />
      <textarea
        name="content"
        value={editedPost.content}
        onChange={handleChange}
        placeholder="Content"
        required
      />
      <button type="submit">Update Post</button>
      <button onClick={() => setEditing(false)}>Cancel</button>
    </form>
  );
};

export default EditPost;
