#Architecture

**design for app architecture demo and test**

####**原则：**  
控制粒度、职责单一、高内聚、低耦合  
业务流转通过路由，对于依赖的对象有回调或者事务的监听可通过消息来处理，消息ID全局唯一。  
不过度设计，遵循简单化原则  

####**1、组件化结构**  
framework开始的都是最基础、最核心、粒度较小的组件，职责单一，其他组件都可依赖它。
除了最基础的framework之外，根据情况适当的增加2、3个模块以上的公共业务组件
frameworkCore       所有组件都可能依赖的底层组件  
frameworkResource   纯资源组件, eg:drawable、String  
frameworkUI         各组件公共的UI层，不含差异化的内容()  
frameworkRouter     各组件通讯的桥梁，包含Web路由，原生路由、上下文信息协调等。  
frameworkWeb        各组件公共的Web组件，如JsBridge、缓存、WebView、WebActivitiy封装，独立进程的方式启动。  
frameworkPlayer     各组件公共的播放器模块  
frameworkAnnotation 注解库  
frameworkCompiler   编译库，处理注解  

app                 是一个空壳程序，只负责集成其他组件编译执行  
bizCommon           业务组件1  
bizProduct          产品组件主要的架构模式demo  
bizOrder            订单组件  
bizUser             用户组件  
bizWeb              Web组件，附带业务规则的，独立进程，依赖纯粹的frameworkWeb  

每个组件中的DebugActivity可用来准备一些组件测试的前置工作

####**2、架构模式、组件分层**  
业务组件可依赖基础组件，也可依赖其他业务组件  
业务组件之间不直接产生影响  
业务组件根据场景采用MVP，根据需要可增加多层  

通常业务组件有：  
用户  
登录  
注册  
分享  
埋点  
监控  
配置  
……  

####**3、路由规则**  
   H5、Native、RN都可通过同一个路由进行跳转，eg：xujian://com.abc.test/activity/product/main?a=b&c=d  
   有参数时会拓传到目标对象，没有则不传递参数，不影响跳转.  
   还有一种方式跳转目标对象，是需要为每个Activity等定义<data>，但是这样太麻烦，我们只需要定义一个入口，让路由器来转发即可。  
   多个业务组件的Fragment聚合到APP，可通过路由反射，也可通过直接依赖业务组件的方式。  
   如果不采用Annotation的方式，那么可以直接自己定义好路由和目标对象的映射，路由调用时查找转发。
     
####**4、资源冲突**  
   为避免同名资源被App或其他组件库覆盖，严格意义上需进行前缀定义，除非自己有信心可以不让它重复:)。  
   组件资源名定义前缀resourcePrefix 'p_'，定义之后：  
   value中变量名需要p_, eg:string、color、……  
   layout资源名需要p_activity_debug.xml  
   mipmap图片别名p_  

####**5、组件单独测试**  
   debug模式时单一组件的测试是独立的，有时会关联到其他业务组件的上下文，没办法像App那样依赖所有模块进行集成测试，所以可通过以下方法尝试：  
  （1）可为待测试的组件写一些模拟的代码  
  （2）可直接引用其他组件的aar文件，显示跳转  
      此时可通过根build.gradle文件定义flatDir，业务组件依赖依赖aar即可，当然也可以写个gradle插件完成依赖的aar拷贝。  
  （3）app壳工程gradle中修改为只依赖当前业务组件来测试。

####**6、App部署**  
debug编译时每个bizModule可独立部署和运行  
release编译时各bizModule作为基础类库，支撑app作为主程序进行编译和部署

组件化还有很多细节的问题需要处理，具体在不同的业务项目中在实践总结，前提是遵循组件隔离原则。  

