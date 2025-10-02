DROP database IF EXISTS ssafit_db;
CREATE database ssafit_db DEFAULT CHARACTER SET utf8mb4;

use ssafit_db;

CREATE TABLE user (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(20) NOT NULL,
    user_email VARCHAR(30) NOT NULL,
    user_password VARCHAR(20) NOT NULL
);

INSERT INTO user (user_name, user_email, user_password) 
VALUES ("김싸피", "abc@gmail.com", "1234"), ("이싸피", "def@gmail.com", "5678"),("박싸피", "ghi@gmail.com", "9012")
;

SELECT * FROM user;

CREATE TABLE video (
	id int AUTO_INCREMENT PRIMARY KEY, 
	view_cnt int DEFAULT 0,
	title VARCHAR(50) NOT NULL, 
	url VARCHAR(50) NOT NULL,
	part VARCHAR(20) NOT NULL, 
	channel_name VARCHAR(30) NOT NULL, 
	reg_date TIMESTAMP DEFAULT now()
);

INSERT INTO video(title, url, part, channel_name) 
VALUES ("전신 다이어트 최고의 운동 [칼소폭 찐 핵핵매운맛]", "https://www.youtube.com/embed/gMaB-fG4u4g", "전신", "ThankyouBUBU"),
("하루 15분! 전신 칼로리 불태우는 다이어트 운동", "https://www.youtube.com/embed/swRNeYw1JkY", "전신",  "ThankyouBUBU"),
("상체 다이어트 최고의 운동 BEST [팔뚝살/겨드랑이살/등살/가슴어깨라인]", "https://www.youtube.com/embed/54tTYO-vU2E", "상체","ThankyouBUBU"),
( "상체비만 다이어트 최고의 운동 [상체 핵매운맛]", "https://www.youtube.com/embed/QqqZH3j_vH0", "상체",  "ThankyouBUBU");

SELECT * FROM video;

CREATE TABLE review (
    videoId INT NOT NULL,
    reviewId INT AUTO_INCREMENT PRIMARY KEY,
    writer VARCHAR(50) NOT NULL,
    title VARCHAR(50) NOT NULL,
    content TEXT,
    regDate TIMESTAMP DEFAULT NOW()
);


