主要流程：
	1、主线程会并发的新建100个session
	2、每个session会有start和stop操作
	3、start操作首先会调用http请求，告诉服务器自己开始了，然后会异步调用stop
	4、本项目中的stop是根据session的时长自动调用，采取的时timer+线程池实现异步调用
	5、项目会在所有session均stop之后才会结束
覆盖率报告：
    见/coverage目录
