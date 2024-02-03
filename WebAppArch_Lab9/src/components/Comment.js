// src/components/Comment.js
import React from 'react';

const Comment = ({ name, content }) => {
  return (
    <div className="comment">
      <p className="comment-name"><strong>{name}</strong></p>
      <p className="comment-content">{content}</p>
    </div>
  );
};

export default Comment;
