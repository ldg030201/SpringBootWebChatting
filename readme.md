# 실행방법
1. 아래 SQL 실행
2. 프로젝트 IDE로 열어서 실행 OR 3번 방법
3. run_v1.0.zip 다운로드 후 start.bat 실행 (자바 11기준)
# SQL

```SQL
CREATE DATABASE `spring-boot-web-chatting`
```

```SQL
CREATE TABLE `chat` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '고유 ID값',
  `room_id` varchar(100) DEFAULT NULL COMMENT '방 ID',
  `message` text DEFAULT NULL COMMENT '메시지 내용',
  `registration_id` varchar(100) DEFAULT NULL COMMENT '송신자 ID',
  `registration_name` varchar(300) DEFAULT NULL COMMENT '송신시 이름',
  `registration_datetime` datetime DEFAULT NULL COMMENT '송신시간',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8mb4;
```