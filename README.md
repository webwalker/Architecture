design for app architecture demo and test

原则：控制粒度、职责单一、高内聚、低耦合

1、组件化结构
framework开始的都是最基础、最核心、粒度较小的组件，职责单一，其他组件都可依赖它。
frameworkCore       所有组件都可能依赖的底层组件
frameworkResource   纯资源组件, eg:drawable、String
frameworkUI         各组件公共的UI层，不含差异化的内容()
frameworkRouter     各组件通讯的桥梁，包含Web路由，原生路由、上下文信息协调等。
frameworkWeb        各组件公共的Web组件，如JsBridge、缓存、WebView、WebActivitiy封装，独立进程的方式启动。
frameworkPlayer     各组件公共的播放器模块

frameworkAnnotation 注解库
frameworkCompiler   编译库，处理注解

app                 主程序，空壳，只负责集成其他组件编译执行
bizModule1          业务组件1(依赖2、3)
bizModule2          业务组件2(依赖3)
bizModule3          业务组件3

2、架构模式、组件分层
业务组件可依赖基础组件，也可依赖其他业务组件
业务组件之间不直接产生影响
业务组件根据场景采用MVC或MVP模式，根据需要可增加多层

通常业务组件有：
用户
登录
注册
分享
埋点
监控
配置
……

3、路由规则

4、资源冲突

5、App部署
debug编译时每个bizModule可独立部署和运行
release编译时各bizModule作为基础类库，支撑app作为主程序进行编译和部署

依赖组件：
