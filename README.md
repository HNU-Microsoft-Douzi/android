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


## Spoof_camera

这个项目行驶的初衷是为了利用一下手机的camera的API和其调用，算是为了满足自己的兴趣爱好而产生的一个恶意产物，它的功能是可以利用拍照的功能将目标的主机所有图片全部显示在我的Bomb数据库中，算是对于客户端信息的一次抓取，是种恶意行为，除了学习之外，不建议使用。在过程中对Service进行了调用，数据的传输利用了Bomb的数据库API，传输的过程涉及到Android的前后端概念问题，登陆本来计划写两种，第一种是客户登陆，上去只能泄露信息，第二种是root管理员登陆，登陆上去可以看到当前客户端上传的所有图片，并且这里可以进行一个优化，就是将Service转换成IntentService，防止产生相应超时的错误。目前在大部分机型上可以适用，但少部分机型如魅族的meta8不能进行成功匹配。
请勿用于非法操作！！！

## PracticeDraw1

算是一个Demo，但是实际上是我看的慕课中自定义View第一节的课下练习题，总共十来个部分，再practice文件夹下，可以方便的进行各种Paint类型的练习，还有相应的对照物，很方便，刚学完Paint和Canvas的同学可以拿来练一下手。


## PracticeDraw2

和上面一个一样，是个练手的demo，原文档这里就不贴出来了，也是github上的，可以直接去MarketPlace自己查找，练习的内容是自定义View绘制的关于Paint的API，定制性很强，要记得也很多。

## PracticeDraw3

这个demo是关于文字绘制的，也就是说，是canvas的drawText属性相关的paint的API。

## opencv

这个demo就不得不说一下了，涉及到opencv这个开源库的加载，过程非常麻烦，我还是大致回想总结一下：

- 先import module导入opencv sdk中的java目录
- 然后通过project structure中的dependency中导入opencv的模块
- 找到OpenCV-android-sdk->sdk->native->libs中的所有文件导入到app->libs目录下
- 然后在app的build.gradle中的dependencies中加入一些声明，声明文件在demo中找，都有注明
- 在使用的页面中直接进行静态注册


> 创建时间：2018年6月5日

> 最后一次更新:2018年6月5日

> 制作人：张晓翼

> 我的博客:[https://www.zxyblog.xyz](https://www.zxyblog.xyz)