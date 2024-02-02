import React, { useState, useEffect } from "react";
import { updatePost } from "../services/PostService";

const EditPost = ({ post, refreshPosts, setEditing, finishEditing }) => {
  const [editedPost, setEditedPost] = useState(post);

  useEffect(() => {
    setEditedPost(post);
  }, [post]);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setEditedPost((prevPost) => ({ ...prevPost, [name]: value }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await updatePost(editedPost);
      refreshPosts();
      finishEditing(); // This will toggle off the editing mode
    } catch (error) {
      console.error("Failed to update post", error);
    }
  };

  if (!editedPost) return null;

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
    </form>
  );
};

export default EditPost;
