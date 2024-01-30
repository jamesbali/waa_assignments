import React from "react";

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

export default PostDetails;
