webchat
=======
1、Browser 发送http请求到 Server;
2、Server接收请求,开启新的线程处理处理请求,线程阻塞掉;(http长连接);
	2.1、长连接何时断开比较方便,服务器端需要设置连接超时时间。
	2.2、Browser发送请求,超时时间设置问题。
3、Server端有消息需要push到Browser端,唤醒所有处理Browser请求阻塞的线程,响应请求;
4、Browser收到请求后,继续步骤1。
