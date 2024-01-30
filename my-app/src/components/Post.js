import React from "react";

const Post = ({ id, title, author, onSelectPost, activePost }) => {
  var onClick = (event) => {
    onSelectPost({
      id: id,
      title: title,
      author: author,
    });
  };
  return (
    <div
      className={activePost === id ? "active-post" : "post"}
      onClick={onClick}
    >
      <p>Id: {id}</p>
      <p>Title: {title}</p>
      <p>Author: {author}</p>
    </div>
  );
};

export default Post;
