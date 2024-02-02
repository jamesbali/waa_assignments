// import React from "react";

// PostDetails.js
import React, { useState, useEffect } from "react";
import Comment from "./Comment";
import { fetchCommentsByPostId } from "../services/PostService";
import { deletePost, updatePost } from "../services/PostService";
import EditPost from "./EditPost";

const PostDetails = ({ post, refreshPosts }) => {
  const [comments, setComments] = useState([]);
  const [editing, setEditing] = useState(false);

  // Fetch comments whenever the selected post changes
  useEffect(() => {
    if (post?.id) {
      fetchCommentsByPostId(post.id)
        .then((response) => {
          setComments(response.data);
        })
        .catch((error) => {
          console.error("Failed to fetch comments:", error);
        });
    }
  }, [post]);

  const handleEditClick = () => {
    setEditing(true);
  };

  const finishEditing = () => {
    setEditing(false);
    refreshPosts(); // Call this to ensure the parent component knows to refresh the post list
  };

  const handleDelete = () => {
    // Confirm before deleting
    if (window.confirm("Are you sure you want to delete this post?")) {
      deletePost(post.id)
        .then(() => {
          alert("Post deleted successfully");
          refreshPosts(); // Refresh the list of posts after deletion
        })
        .catch((error) => {
          console.error("Error deleting post:", error);
        });
    }
  };

  if (!post) return <div>Select a post to view details</div>;

  return (
    <div className="post-details">
      <h2>{post.title}</h2>
      <p>ID: {post.id}</p>
      <p>Author: {post.author}</p>
      <p>{post.content}</p>

      {/* Render Comments */}
      <div className="comments-section">
        {comments.map((comment) => (
          <Comment
            key={comment.id}
            name={comment.name}
            content={comment.content}
          />
        ))}
      </div>

      {editing ? (
        <EditPost post={post} finishEditing={finishEditing} />
      ) : (
        <>
          <button className="edit-button" onClick={handleEditClick}>
            Edit
          </button>
          <button className="delete-button" onClick={handleDelete}>
            Delete
          </button>
        </>
      )}
    </div>
  );
};

export default PostDetails;

// import React, { useState } from "react";
// import { deletePost } from "../services/PostService";
// import { updatePost } from "../services/PostService";
// import EditPost from "./EditPost";
// import Comment from "./Comment";

// const PostDetails = ({ post, refreshPosts }) => {
//   //edit handler
//   const [editing, setEditing] = useState(false);
//   const handleEditClick = () => {
//     setEditing(true);
//   };

//   //when editing is done
//   const finishEditing = () => {
//     setEditing(false);
//   };

//   //delete handler
//   const handleDelete = () => {
//     const confirmDelete = window.confirm(
//       "Are you sure you want to delete this post?"
//     );
//     if (confirmDelete) {
//       deletePost(post.id)
//         .then(() => {
//           alert("Post deleted successfully");
//           refreshPosts(); // Refresh the list of posts
//         })
//         .catch((error) => console.error("Error deleting post:", error));
//     }
//   };

//   if (!post) return <div>Select a post to view details</div>;

//   //Function to handle edit click
//   // const editClicked = (event)=>{
//   //   event.preventDefault();//prevent default form action
//   //   onEdit(post); //call the onedit function passed via props with the post
//   // }

//   return (
//     <div className="post-details">
//       <h2>{post.title}</h2>
//       <p>ID:{post.id}</p>
//       <p>Author: {post.author}</p>
//       <p>{post.content}</p>

//       {/* Render Comments */}
//       <div className="comments-section">
//         {post.comments &&
//           post.comments.map((comment) => (
//             <Comment key={comment.id} name={comment.name} id={comment.id} />
//             // <Comment key={comment.id} comment={comment} />
//           ))}
//       </div>

//       {editing && (
//         <EditPost
//           post={post}
//           refreshPosts={refreshPosts}
//           setEditing={setEditing}
//           finishEditing={finishEditing}
//         />
//       )}

//       <div className="button-row">
//         <button className="edit-button" onClick={() => handleEditClick()}>
//           {" "}
//           Edit
//         </button>
//         <button className="delete-button" onClick={handleDelete}>
//           Delete
//         </button>
//       </div>
//     </div>
//   );
// };

// export default PostDetails;
