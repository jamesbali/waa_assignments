// import React from "react";

// const Post = ({ id, title, author, onSelectPost, activePost }) => {
//   var onClick = (event) => {
//     onSelectPost({
//       id: id,
//       title: title,
//       author: author,
//     });
//   };
//   return (
//     <div
//       className={activePost === id ? "active-post" : "post"}
//       onClick={onClick}
//     >
//       <p>Id: {id}</p>
//       <p>Title: {title}</p>
//       <p>Author: {author}</p>
//     </div>
//   );
// };

// export default Post;

//v2

// import React from 'react';

// const Post = ({ post, onSelectPost }) => (
//   <div onClick={() => onSelectPost(post.id)}>
//     <h2>Id:{post.id}</h2>
//     <h2>Title:{post.title}</h2>
//     <h2>Author:{post.author}</h2>

//   </div>
// );

// export default Post;

//v3

import React from "react";

import "../App.css";

const Post = ({ post, selectPost, activePost }) => {
  const isActive = post.id === activePost;
  const postClass = isActive ? "post active-post" : "post";

  return (
    <div className="post" onClick={() => selectPost(post.id)}>
      <p>ID:{post.id}</p>
      <h3>Title: {post.title}</h3>
      <h3>Content:{post.content} </h3>
      <p>Author: {post.author}</p>
    </div>
  );
};

export default Post;
