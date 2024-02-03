// src/PostContext.js
import React, { createContext, useState } from 'react';

export const PostContext = createContext();

export const PostProvider = ({ children }) => {
  const [selectedPostId, setSelectedPostId] = useState(null);

  return (
    <PostContext.Provider value={{ selectedPostId, setSelectedPostId }}>
      {children}
    </PostContext.Provider>
  );
};
