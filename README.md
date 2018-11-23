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


* 拉取镜像
```
docker pull morunchang/fastdfs
```
* 运行tracker
```
docker run -d --name tracker --net=host morunchang/fastdfs sh tracker.sh
```
* 运行storage
```
docker run -d --name storage --net=host -e TRACKER_IP=<your tracker server address>:22122 -e GROUP_NAME=<group name> morunchang/fastdfs sh storage.sh
```
> `Nginx`端口应该是默认映射为`8080`吧  
  1. 使用的网络模式是–net=host,  `<your tracker server address>` 替换为你机器的Ip即可  
  2. `<group name>` 是组名，即storage的组  
  3. 如果想要增加新的storage服务器，再次运行该命令，注意更换 新组名
运行完后会自动进入容器内部，输入【exit】退出容器内部   
  4. docker ps 查看容器信息 
  ```
  [root@iZh3cshm0xz7wjZ ~]# docker ps 
  CONTAINER ID        IMAGE                COMMAND             CREATED              STATUS              PORTS               NAMES
  ccdf6bbeab48        morunchang/fastdfs   "sh storage.sh"     5 seconds ago        Up 4 seconds                            storage
  a7253c93bce1        morunchang/fastdfs   "sh tracker.sh"     About a minute ago   Up About a minute                       tracker
```
* 修改nginx的配置，不拦截上传内容
```
//1.进入容器内部
docker exec -it storage  /bin/bash

 // storage 是 docker ps 中的NAMES
 // exit 退出

root@iZh3cshm0xz7wjZ:/# cd data
root@iZh3cshm0xz7wjZ:/data# ls
fast_data  fastdfs  fastdfs-nginx-module  libfastcommon  nginx  nginx-1.9.11.tar.gz

//2.修改nginx配置文件
root@iZh3cshm0xz7wjZ:/# vi /data/nginx/conf/nginx.conf

//3. 添加修改内容
location /group1/M00 {
   proxy_next_upstream http_502 http_504 error timeout invalid_header;
     proxy_cache http-cache;
     proxy_cache_valid  200 304 12h;
     proxy_cache_key $uri$is_args$args;
     proxy_pass http://fdfs_group1;
     expires 30d;
 }

//4.退出
root@iZh3cshm0xz7wjZ:/data/nginx/conf# exit
exit

//5. 重启storage服务
[root@iZh3cshm0xz7wjZ ~]# docker restart storage
storage
```
</details>
