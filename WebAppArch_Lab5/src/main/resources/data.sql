-- -- Insert Users
-- INSERT INTO users (name) VALUES ('User 1');
-- INSERT INTO users (name) VALUES ('User 2');
--
-- -- Insert Posts
-- INSERT INTO post (title, content, author) VALUES ('Post 1 Title', 'Post 1 Content', 'User 1');
-- INSERT INTO post (title, content, author) VALUES ('Post 2 Title', 'Post 2 Content', 'User 1');
-- INSERT INTO post (title, content, author) VALUES ('Post 3 Title', 'Post 3 Content', 'User 2');
--
-- -- Insert Comments
-- INSERT INTO comment (name, post_id) VALUES ('Comment 1', 1);
-- INSERT INTO comment (name, post_id) VALUES ('Comment 2', 1);
-- INSERT INTO comment (name, post_id) VALUES ('Comment 3', 2);
-- INSERT INTO comment (name, post_id) VALUES ('Comment 4', 3);

-- Insert Users
INSERT INTO users ( name) VALUES ( 'Alice');
INSERT INTO users ( name) VALUES ( 'Bob');

-- Insert Posts
INSERT INTO post ( title, content, author, user_id) VALUES ( 'First Post', 'This is the content of the first post', 'Alice', 1);
INSERT INTO post ( title, content, author, user_id) VALUES ( 'Second Post', 'Content of the second post', 'Bob', 2);

-- Insert Comments
INSERT INTO comment ( name, post_id) VALUES ( 'This is a comment', 1);
INSERT INTO comment ( name, post_id) VALUES ( 'Another comment', 1);
INSERT INTO comment ( name, post_id) VALUES ( 'Comment on second post', 2);



