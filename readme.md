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