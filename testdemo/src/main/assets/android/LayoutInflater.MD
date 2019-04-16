

















   ![](https://github.com/fumeidonga/markdownPic/blob/master/performance/createviw1.png?raw=true)

#### LyoutInflater 构造方法

<pre>

// 1
public View inflate(int resource, ViewGroup root) {
    // root不为空时，attachToRoot默认为true
    return inflate(resource, root, root != null);
}

// 2
public View inflate(int resource, ViewGroup root, boolean attachToRoot) {
    XmlResourceParser parser = getContext().getResources().getLayout(resource);
    try {
        return inflate(parser, root, attachToRoot);
    } finally {
        parser.close();
    }
}

// 3
public View inflate(XmlPullParser parser, ViewGroup root) {
    // root不为空时，attachToRoot默认为true
    return inflate(parser, root, root != null);
}

前三个方法最终调用的都是 4

// 4
public View inflate(XmlPullParser parser, ViewGroup root, boolean attachToRoot) {
    ...
}
</pre>

* root == null， attachToRoot无用
> 此时传进来的布局会被加载成为一个View并直接返回；  
> 布局根View的android:layout_xxx属性会被忽略,只能显示默认的大小

* root != null， attachToRoot == false
> 传进来的布局会被加载成为一个View并直接返回。  
> 布局根View的android:layout_xxx属性会被解析成LayoutParams并保留。  
> (root只用来参与生成布局根View的LayoutParams)

* root != null， attachToRoot == true
> 传进来的布局会被加载成为一个View并作为子View添加到root中，最终返回
root；  
> 而且这个布局根节点的android:layout_参数会被解析用来设置View的大小


#### 原理

其实就是从根节点开始，递归解析xml的每个节点，每一步递归的过程是：
通过节点名称（全类名），使用ClassLoader创建对应类的实例，也就是View，
然后，将这个View添加到它的上层节点（父View）。并同时会解析对应xml
节点的属性作为View的属性。每个层级的节点都会被生成一个个的View，
并根据View的层级关系add到对应的直接父View（上层节点）中，最终返回一
个包含了所有解析好的子View的布局根View。


