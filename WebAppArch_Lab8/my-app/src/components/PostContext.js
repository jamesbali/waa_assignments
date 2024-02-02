import React from "react";

const PostContext = React.createContext();

export const PostProvider = ({ children }) => {
  const [selectedPostId, setSelectedPostId] = React.useState(null);

  const value = { selectedPostId, setSelectedPostId };

  return <PostContext.Provider value={value}>{children}</PostContext.Provider>;
};
