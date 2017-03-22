#MVP 模式结构定义

###概述
业务模块划分：在同一个业务组件中，每个mvp目录，可按业务功能划分，相同或相似的为一组，粒度大小可以自己控制  

###目录结构划分
有以下几种方式，具体根据业务功能的复杂程度来决定：  
1、mvp1  
    为多个功能模块合并后的mvp目录结构，  

2、mvp2  
    为多个功能模块细分后的mvp目录结构，粒度更小  
    如果业务不复杂contract、presenter可以不用建立，放置根目录  

3、mvp3  
    
contract：放置View和Presenter的契约规则定义  
model：纯model类  
presenter：展示逻辑处理  
ui：activity、fragment等  
views：模块自定义的View或Widget  
utils：组件自己特有的公共类、util类  


