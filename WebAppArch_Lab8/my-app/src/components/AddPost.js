import React, { useRef } from "react";
import { addPost } from "../services/PostService";

const AddPost = ({ refreshPosts }) => {
  const titleRef = useRef();
  const authorRef = useRef();
  const contentRef = useRef();

  const handleSubmit = async (e) => {
    e.preventDefault();
    const post = {
      title: titleRef.current.value,
      author: authorRef.current.value,
      content: contentRef.current.value,
    };

    if (!post.title || !post.author || !post.content) {
      alert("All fields are required");
      return;
    }

    try {
      await addPost(post);
      alert("Post added successfully");
      // Reset form fields by resetting their current value
      titleRef.current.value = "";
      authorRef.current.value = "";
      contentRef.current.value = "";
      refreshPosts(); // update the list of posts
    } catch (error) {
      console.error("Failed to add post", error);
    }
  };

  return (
    <form onSubmit={handleSubmit} className="addPostForm">
      <input
        type="text"
        placeholder="Title"
        name="title"
        ref={titleRef}
        required
      />
      <input
        type="text"
        placeholder="Author"
        name="author"
        ref={authorRef}
        required
      />
      <textarea
        placeholder="Content"
        name="content"
        ref={contentRef}
      ></textarea>
      <button type="submit">Add Post</button>
    </form>
  );
};

export default AddPost;

/*import React, { useState } from "react";
import { addPost } from "../services/PostService";


const AddPost = ({ refreshPosts }) => {
  const [post, setPost] = useState({ title: "", author: "", content: "" });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setPost((prevPost) => ({ ...prevPost, [name]: value }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    // const newPost = { title, author, content };
    if (!post.title || !post.author || !post.content) {
      alert("All fields are required");
      return;
    }

    try {
      await addPost(post);
      alert("post added successfully");
      setPost({ title: "", author: "", content: "" }); //reset form
      refreshPosts(); // update the list of posts
    } catch (error) {
      console.error("Failed to add post", error);
    }
  };

  return (
    <form onSubmit={handleSubmit} className="addPostForm">
      <input
        type="text"
        placeholder="Title"
        name="title"
        value={post.title}
        onChange={handleChange}
        required
      />
      <input
        type="text"
        placeholder="Author"
        name="author"
        value={post.author}
        onChange={handleChange}
        required
      />
      <textarea
        placeholder="Content"
        name="content"
        value={post.content}
        onChange={handleChange}
      ></textarea>
      <button type="submit">Add Post</button>
    </form>
  );
};

export default AddPost;*/
