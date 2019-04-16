




















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




