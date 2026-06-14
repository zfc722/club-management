-- schema.sql
CREATE DATABASE IF NOT EXISTS clubdb DEFAULT CHARSET = utf8mb4;
USE clubdb;

CREATE TABLE IF NOT EXISTS user_account (
  id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(50) NOT NULL UNIQUE,
  password VARCHAR(255) NOT NULL,
  name VARCHAR(100),
  role VARCHAR(20) DEFAULT 'admin'
);

CREATE TABLE IF NOT EXISTS club (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  category VARCHAR(50),
  president VARCHAR(100),
  description TEXT,
  contact VARCHAR(100),
  created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO user_account (username, password, name, role)
VALUES ('admin', 'admin123', '系统管理员', 'admin');

INSERT INTO club (name, category, president, description, contact)
VALUES
('计算机协会', '技术', '张三', '面向计算机爱好者的学术与实践型社团', 'wechat:zhangsan'),
('摄影协会', '艺术', '李四', '校园摄影与交流活动', 'wechat:lisi'),
('志愿者协会', '公益', '王五', '组织公益与志愿服务', 'wechat:wangwu');
