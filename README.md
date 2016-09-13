# XiangMVPDemo
simple mvc demo 简单的MVP模式应用

1、介绍

Model-view-presenter，简称MVP，是电脑软件设计工程中一种对针对MVC模式，再审议后所延伸提出的一种软件设计模式。

2、描述

Model-view-presenter (MVP)是使用者界面设计模式的一种，被广范用于便捷自动化单元测试和在呈现逻辑中改良分离关注点（separation of concerns）。

Model 定义使用者界面所需要被显示的资料模型，一个模型包含着相关的业务逻辑。

View 视图为呈现使用者界面的终端，用以表现来自 Model 的资料，和使用者命令路由再经过 Presenter 对事件处理后的资料。

Presenter 包含着元件的事件处理，负责检索 Model 取得资料，和将取得的资料经过格式转换与 View 进行沟通。

MVP 设计模式通常会再加上 Controller 做为整体应用程序的后端程序工作。


个人blog：http://www.jianshu.com/p/d492a18bc099

工程主要借鉴：https://github.com/antoniolg/androidmvp
