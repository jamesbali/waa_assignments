// Comment.js
import React from "react";

const Comment = ({ author, content }) => {
  return (
    <div className="comment">
      <p>{content}</p>
      <p>By: {author}</p>
    </div>
  );
};

export default Comment;
