# Java仿微信全栈 高性能后台+移动客户端  

## 技术栈
> 前端：MUI H5+  
> 后端：Springboot netty mybatis  
## 数据库
<details><summary>数据表设计</summary> 

> Table structure for chat_msg
```sql
DROP TABLE IF EXISTS `chat_msg`;
CREATE TABLE `chat_msg` (
  `id` varchar(64) NOT NULL,
  `send_user_id` varchar(64) NOT NULL,
  `accept_user_id` varchar(64) NOT NULL,
  `msg` varchar(255) NOT NULL,
  `sign_flag` int(1) NOT NULL COMMENT '消息是否签收状态\r\n1：签收\r\n0：未签收\r\n',
  `create_time` datetime NOT NULL COMMENT '发送请求的事件',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
```
> Table structure for friends_request
```sql
DROP TABLE IF EXISTS `friends_request`;
CREATE TABLE `friends_request` (
  `id` varchar(64) NOT NULL,
  `send_user_id` varchar(64) NOT NULL,
  `accept_user_id` varchar(64) NOT NULL,
  `request_date_time` datetime NOT NULL COMMENT '发送请求的事件',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
```
> Table structure for my_friends
```sql
DROP TABLE IF EXISTS `my_friends`;
CREATE TABLE `my_friends` (
  `id` varchar(64) NOT NULL,
  `my_user_id` varchar(64) NOT NULL COMMENT '用户id',
  `my_friend_user_id` varchar(64) NOT NULL COMMENT '用户的好友id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `my_user_id` (`my_user_id`,`my_friend_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
```
> Table structure for users
```sql
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` varchar(64) NOT NULL,
  `username` varchar(20) NOT NULL COMMENT '用户名，账号，慕信号',
  `password` varchar(64) NOT NULL COMMENT '密码',
  `face_image` varchar(255) NOT NULL COMMENT '我的头像，如果没有默认给一张',
  `face_image_big` varchar(255) NOT NULL,
  `nickname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '昵称',
  `qrcode` varchar(255) NOT NULL COMMENT '新用户注册后默认后台生成二维码，并且上传到fastdfs',
  `cid` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
```
</details>

## Docker安装fastdfs  

<details><summary>安装过程</summary>

* 下载fastdfs镜像，这里选择mypjb/fastdfs  
```dockerfile
docker pull mypjb/fastdfs
```
* 创建宿主机保存fastdfs文件目录  
```dockerfile
mkdir /home/fastdfs
```
* 执行命令运行fastdfs容器  
将下面的【192.168.1.1】替换成自己机器的ip即可
```dockerfile
docker run --add-host fastdfs.net:192.168.1.1 --name fastdfs --net=host -e TRACKER_ENABLE=1 -e NGINX_PORT=81 -v /home/fastdfs:/storage/fastdfs -it mypjb/fastdfs
```
> `Nginx`端口设置为`81`  
> 主机`/home/fastdfs`目录映射到容器`/storage/fastdfs`目录

运行完后会自动进入容器内部，输入【exit】退出容器内部  
* 重启fastdfs容器
```dockerfile
docker restart fastdfs
```
* 开放81端口
如果是阿里云就去控制台开放端口也可以
```dockerfile
firewall-cmd --zone=public --add-port=81/tcp --permanent;firewall-cmd --reload;
```
* 测试是否安装成功  
随便找个jpg文件，重命名为【wKgByFmn1iGAUsF1AAL4cszpkW0032.jpg】，上传至【/home/fastdfs/data/00/00】文件夹中，在浏览器中输入： 
```html
http://192.168.1.1:81/M00/00/00/wKgByFmn1iGAUsF1AAL4cszpkW0032.jpg 
```
如能打开则说明安装成功了。 
</details>
