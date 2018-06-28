# android
**安卓练手项目**

<img src ="https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=319776870,3039074219&fm=27&gp=0.jpg">

创建这个项目的初衷是为了记录一下我在安卓学习过程中拿来练手的一些项目。

另一方面也是对自己学习工作的一个总结，方便以后的回顾。


##　AdapterDemo

这个项目是由`ListView`的升级版`RecyclerView`构建出来的一个列表项，里面数据我没有进行加入，然后用一组数据生成一万次构成了一个列表，利用适配器进行数据的传输，实现了`Recycler View`的点击事件，可以用来删除你点击的`item`。


##  Calculate

这个项目是为了实现一个传统的手机计算器而写的，传统的手机计算器只有简单的加减乘除操作，对于进制间的转换并不能有有效的处理，那么在这个Calculate项目中加入了进制转换的逻辑实现，并且对界面的布局有了一定的优化处理，但是计算器本身逻辑上的处理不是那么简单，整个计算器还是有逻辑上的bug，会在后期进行修复，并对界面进行再一次的优化。

## TulingRobotTraining

这个项目是为了完成网络数据的传输的json格式的解析而专门写的一个练手项目，用了一个下午的时间对整个界面做了优化，连接的APi是这个[Tuling_Robot](http://www.tuling123.com)，通过对数据格式的解析来实现对话机器人的功能，数据提交的方式是使用的okhttp3的post封包提交，解析的数据用Gson的对象进行迭代化处理，对于整个聊天界面主要使用ListView作为大体布局，左右两边的框架分别用不同的布局来实现，对聊天框的.9图片进行了美化处理，实现渐变过度，Robot平台上搭载的数据库是自带的22个语料库，可以自行向里面加入数据，但是由于使用的是免费的资源，所以每天的上限数据只有1000条（我实现没有什么钱去买付费版...）



> 创建时间：2018年6月5日

> 最后一次更新:2018年6月5日

> 制作人：张晓翼

> 我的博客:[https://www.zxyblog.xyz](https://www.zxyblog.xyz)