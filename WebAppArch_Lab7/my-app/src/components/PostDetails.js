// PostDetails.js
import React, { useState, useEffect } from "react";
import Comment from "./Comment";
import axios from "axios";

const PostDetails = ({ post, onDelete }) => {
  const [comments, setComments] = useState([]);

  useEffect(() => {
    const fetchComments = async () => {
      if (post) {
        try {
          const response = await axios.get(
            `http://localhost:8080/api/posts/${post.id}/comments`
          );
          setComments(response.data);
        } catch (error) {
          console.error("Failed to fetch comments:", error);
        }
      }
    };

    if (post) {
      fetchComments();
    }
  }, [post]);

  const handleDelete = async () => {
    try {
      const response = await axios.delete(
        `http://localhost:8080/api/posts/${post.id}`
      );

      onDelete(post.id);
    } catch (error) {
      console.error("Failed to delete post:", error);
    }
  };

  if (!post) return <div>Select a post to view details</div>;

  return (
    <div className="post-details">
      <h3>{post.title}</h3>
      <p>ID: {post.id}</p>
      <p>Author: {post.author}</p>
      {comments.map((comment) => (
        <Comment key={comment.id} {...comment} />
      ))}
      <button onClick={handleDelete}>Delete</button>
    </div>
  );
};

export default PostDetails;

/*import React from "react";

const PostDetails = ({ post }) => {
  if (!post) return <div>Select a post to view details</div>;

  var editClicked = (event) => {
    event.preventDefault();
    alert("edit clicked");
  };

  var deleteClicked = (event) => {
    event.preventDefault();
    alert("delete clicked");
  };

  return (
    <div className="post-details">
      <p>Id: {post.id}</p>
      <h3>{post.title}</h3>
      <p>Author: {post.author}</p>

      <form className="button-row">
        <button className="edit-button" onClick={editClicked}>
          Edit
        </button>
        <button className="delete-button" onClick={deleteClicked}>
          Delete
        </button>
      </form>
    </div>
  );
};

export default PostDetails; */
