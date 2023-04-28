SELECT * FROM users;
SELECT * FROM game;
SELECT * FROM round;
SELECT * FROM word;
INSERT INTO users (username, password) VALUES ('David', 'josh');
UPDATE users SET username='admin', password='pass' WHERE userID=2;