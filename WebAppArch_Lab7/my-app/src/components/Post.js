// Post.js
import React from "react";

const Post = ({ id, title, content, author, onSelectPost }) => {
  return (
    <div
      className="post"
      onClick={() => onSelectPost({ id, title, content, author })}
    >
      <p>Id: {id}</p>
      <p>Title: {title}</p>
      <p>Content: {content}</p>
      <p>Author: {author}</p>
    </div>
  );
};

export default Post;

/*import React from "react";

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

export default Post;*/
