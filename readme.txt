IP 121.40.141.75
用户 root #Ly20121223
用户 fpt fpt

在阿里云代备案系统  登录邮箱为：409989258@qq.com
启动FTP服务 service vsftpd start
重启FTP服务 service vsftpd restart
重启防火墙  service iptables restart

nginx目录  /usr/local/nginx-1.5.1
重启或关闭进程：
/usr/local/nginx-1.5.1/sbin/nginx -s reload
/usr/local/nginx-1.5.1/sbin/nginx -s stop

阿里云服务器上，进程性的 nginx -s stop后再次启动nginx -s reload ,总是会报错误nginx: [error] open() "/alidata/server/nginx/logs/nginx.pid" failed (2: No such file or directory)。
原因：nginx进程杀死后pid丢失了，下一次再开启nginx -s reload时无法启动
解决方法： ./nginx -c /usr/local/nginx-1.5.1/conf/nginx.conf

tomcat启动
sh /usr/local/src/tomcat/apache-tomcat-6.0.45/bin/startup.sh

mysql安装目录
/usr/local/mysql
mysql数据库的数据库文件存放位置
/data/mysqldb
开启mysql
service mysqld start
停止mysql
service mysqld stop 

修改mysql root用户密码
mysqladmin -u root password '123456'
创建mysql新用户zhuxin
create user 'zhuxin'@'%' identified by 'zhuxin';
给新用户zhuxin授权，让他可以从外部登陆和本地登陆
grant all privileges on *.* to 'zhuxin'@'localhost' identified by 'zhuxin'; 
grant all privileges on *.* to 'zhuxin'@'%' identified by 'zhuxin';  



阿里云部署
前端nginx负载连接tomcat
mysql数据库
spring mvc+mybatis+spring+spring security

nginx日志切割/分析
切割：脚本cut_nginx_log.sh做日志切割，crontab 1 0 * * * sh /home/fpt/sh/cut_nginx_log.sh
分析：使用工具GoAccess
常用命令：goaccess -d -f access.log -p ~/.goaccessrc -a > report.html 生成HTML分析
需要每天生成一个report.html放入tomcat

遗留问题：
2016年5月5日
构建方式目标：Jenkins+Github+maven http://blog.csdn.net/john_cdy/article/details/7738393
java -jar jenkins.war -httpPort=8082
本地jenkins账户  zhuxin 000000
缓存框架目标：ehcaches
Maven插件知识
需将本地项目关联到GitHub