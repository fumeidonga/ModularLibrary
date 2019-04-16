
### 相关概念
1. 格栅化

    将图片等矢量资源,转化为一格格像素点的像素图,显示到屏幕上.
    
    所谓的栅格化就是绘制那些Button，Shape，Path，String，Bitmap等组件最基础的操作.
    
    它把那些组件拆分到不同的像素上进行显示，说的俗气一点，就是解决那些复杂的XML布局文件和标记语言，使之转化成用户能看懂的图像，
    
    但是这不是直接转换的，XML布局文件需要在CPU中首先转换为多边形或者纹理，
    然后再传递给GPU进行格栅化，对于栅格化，跟OpenGL有关，格栅化是一个特别费时的操作。

    ![](https://github.com/fumeidonga/markdownPic/blob/master/performance/geshanhua.png?raw=true)

2. 60FPS  &  16ms

    是指画面每秒传输帧数, 安卓中固定是60fps
    
    每秒60fps，那么每一帧的间隔时间就是 1000ms / 60 = 16.66ms.
    
    Android系统每隔16ms发出VSYNC信号(1000ms/60=16.66ms)，触发对UI进行渲染， 如果每次渲染都成功，这样就能够达到流畅的画面所需要的60fps，为了能够实现60fps，这意味着计算渲染的大多数操作都必须在16ms内完成

[参考文章](https://www.jianshu.com/p/71cba1711de0)

### 1. 绘制原理

   手机的画面渲染依赖于cpu & gpu

1. CPU 的作用

* 负责计算显示的内容，eg：视图创建，布局计算，图片解码，文本绘制等,将对象处理为多维图形,纹理

2. GPU 的作用

* 负责格栅化操作(UI 元素绘制到屏幕上)

    ![](https://github.com/fumeidonga/markdownPic/blob/master/performance/xuanran.png?raw=true)

### 2. 优化工具
1. Systrace 中的frames & Alerts ， 这里面有些提示信息，frames中绿色代表正常，其他颜色表示丢帧

    ![](https://github.com/fumeidonga/markdownPic/blob/master/performance/systrace_frames.png?raw=true)


    ![](https://github.com/fumeidonga/markdownPic/blob/master/performance/systrae_alerts.png?raw=true)

2. Layout Inspector 布局检查器

    ![](https://github.com/fumeidonga/markdownPic/blob/master/performance/layoutinstract.png?raw=true)

3. Choreographer

检测UI丢帧跟卡顿，网上的文章还是很多的

<pre>
public class FPSFrameCallback implements Choreographer.FrameCallback {
    ....
    @Override
    public void doFrame(long frameTimeNanos) {
        
        //注册下一帧回调
        Choreographer.getInstance().postFrameCallback(this);
    }
}

Choreographer.getInstance().postFrameCallback(new FPSFrameCallback(System.nanoTime()));

</pre>


[Choreographer](https://developer.android.com/reference/android/view/Choreographer)

[参考1](https://zhuanlan.zhihu.com/p/22239486)

[参考2](https://www.jianshu.com/p/dd32ec35db1d)

[参考3](https://blog.csdn.net/yangwen123/article/details/39518923)

[参考4](https://juejin.im/entry/58c83f3f8ac247072018d926)


### 3. 布局加载原理

  1.  LayoutInflater 解析xml文件，然后从解析出来的对象里面进行view的创建，这里就涉及到IO的操作，这是一个性能点
   
    final View temp = createViewFromTag(root, name, inflaterContext, attrs);


   ![](https://github.com/fumeidonga/markdownPic/blob/master/performance/createviw1.png?raw=true)

   ![](https://github.com/fumeidonga/markdownPic/blob/master/performance/createview.png?raw=true)

2. 当factory2 factory都为空，进入createView，里面用到了反射，这是一个性能点

针对这两点， 我们可以：

* LayoutInflater创建view的 Hook，

* 定制创建view的过程: 全局替换自定义TextView等控件。


