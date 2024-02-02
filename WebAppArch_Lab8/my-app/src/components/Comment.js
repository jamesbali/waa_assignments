import React from "react";

const Comment = React.memo(({ id, name }) => {
  return (
    <div className="comment-item">
      <p className="comment-content">
        {" "}
        {id}: {name}
      </p>
    </div>
  );
});

export default Comment;

/*import React from "react";

const Comment = ({ id, name }) => {
  return (
    <div className="comment-item">
      <p className="comment-content">
        {" "}
        {id}: {name}
      </p>
    </div>
  );
};

export default Comment;*/
