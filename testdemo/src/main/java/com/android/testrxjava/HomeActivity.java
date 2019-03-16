package com.android.testrxjava;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.TimeUtils;
import android.widget.Button;

import com.android.modulcommons.utils.DVLogUtils;
import com.android.testdagger.R;
import com.android.testrxjava.base.BaseActivity;
import com.android.testrxjava.base.Man;
import com.android.testrxjava.base.Woman;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.operators.flowable.FlowableInternalHelper;
import io.reactivex.schedulers.Schedulers;

public class HomeActivity extends BaseActivity {

    /**
     * Observable 三部曲
     * just创建发送指定值的Observerble，just只是简单的原样发射，将数组或Iterable当做单个数据。
     * 如果传递的值为null，则发送的Observable的值为null。参数最多为9个
     */
    @OnClick(R.id.bottom0)
    public void begin(){
        // Observable 三部曲
        //初始Observable有很多方式，我们比较常用的是create

        // 第一步：初始化一个Observable
        Observable<Integer> observable0 = Observable.just(1,2);
        Observable<Integer> observable = Observable.fromArray(1, 2, 3);
        Observable<Integer> observable1 = new Observable<Integer>() {
            @Override
            protected void subscribeActual(Observer<? super Integer> observer) {
                DVLogUtils.dt();
                observer.onNext(1);
                observer.onNext(2);
                observer.onComplete();
            }
        };

        Observable<Integer> observable2 = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                DVLogUtils.dt();
                e.onNext(1);
                e.onNext(2);
                e.onComplete();
            }
        });


        // 第二步：初始化一个Observer
        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

                DVLogUtils.dt();
            }

            @Override
            public void onNext(Integer o) {

                DVLogUtils.dt(o);
            }

            @Override
            public void onError(Throwable e) {

                DVLogUtils.dt();
            }

            @Override
            public void onComplete() {

                DVLogUtils.dt();
            }
        };

        Observer<Integer> observer1 = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

                DVLogUtils.dt();
            }

            @Override
            public void onNext(Integer o) {

                DVLogUtils.dt(o);
            }

            @Override
            public void onError(Throwable e) {

                DVLogUtils.dt();
            }

            @Override
            public void onComplete() {

                DVLogUtils.dt();
            }
        };

        Observer<Integer> observer2 = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

                DVLogUtils.dt();
            }

            @Override
            public void onNext(Integer o) {

                DVLogUtils.dt(o);
            }

            @Override
            public void onError(Throwable e) {

                DVLogUtils.dt();
            }

            @Override
            public void onComplete() {

                DVLogUtils.dt();
            }
        };
        // 第三部：建立订阅关系
//        observable.subscribe(observer);
//        observable1.subscribe(observer1);
        observable2.subscribe(observer2);



    }


    /**
     * 上游可以发送无限个onNext, 下游也可以接收无限个onNext.
     * 当上游发送了一个onComplete后, 上游onComplete之后的 事件将会继续发送, 而下游收到onComplete事件之后将不再继续接收事件.
     * 当上游发送了一个onError后, 上游onError之后的 事件将继续发送, 而下游收到onError事件之后将 不再继续接收事件.
     * 上游可以不发送onComplete或onError.
     * 最为关键的是onComplete和onError必须唯一并且互斥,
     * 即不能发多个onComplete, 也不能发多个onError, 也不能先发一个onComplete, 然后再发一个onError, 反之亦然
     */
    @OnClick(R.id.bottom1)
    public void create1(){
        //1. 初始化一个Observable
        Observable.create(new ObservableOnSubscribe<Integer>(){

            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                DVLogUtils.dt();
                e.onNext(1);
                e.onNext(2);
                e.onComplete();//下游收到onComplete事件之后将不再继续接收事件
                e.onNext(3);// 事件将会继续发送, 但是订阅器里面并不会接受
                e.onComplete();
                DVLogUtils.dt();
            }
        }).subscribe(new Observer<Integer>() {//2,3,并订阅
            @Override
            public void onSubscribe(Disposable d) {
                DVLogUtils.dt();
            }

            @Override
            public void onNext(Integer integer) {

                DVLogUtils.dt(integer);
            }

            @Override
            public void onError(Throwable e) {
                DVLogUtils.dt();
            }

            @Override
            public void onComplete() {
                DVLogUtils.dt();
            }
        });
    }

    /**
     * onComplete和onError必须唯一并且互斥,
     */
    @OnClick(R.id.bottom2)
    public void create2(){
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {

                DVLogUtils.dt();
                e.onNext(1);
                e.onNext(2);
                e.onError(new Throwable("123"));//下游收到onComplete事件之后将不再继续接收事件
                e.onNext(3);// 事件将会继续发送, 但是订阅器里面并不会接受
                //e.onComplete(); //只能发同一种类型
                DVLogUtils.dt();
            }
        }).subscribe();

        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {

                DVLogUtils.dt();
                e.onNext(1);
                e.onNext(2);
                //e.onError(new Throwable("123"));//下游收到onComplete事件之后将不再继续接收事件
                e.onNext(3);// 事件将会继续发送, 但是订阅器里面并不会接受
                //e.onComplete(); //只能发同一种类型
                DVLogUtils.dt();
            }
        }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {

            }
        });

        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {

                DVLogUtils.dt();
                e.onNext(1);
                e.onNext(2);
                e.onError(new Throwable("123"));//下游收到onComplete事件之后将不再继续接收事件
                e.onNext(3);// 事件将会继续发送, 但是订阅器里面并不会接受
                //e.onComplete(); //只能发同一种类型
                DVLogUtils.dt();
            }
        }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {

                DVLogUtils.dt();
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {

                DVLogUtils.dt();
            }
        });

        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {

                DVLogUtils.dt();
                e.onNext(1);
                e.onNext(2);
                e.onError(new Throwable("123"));//下游收到onComplete事件之后将不再继续接收事件
                e.onNext(3);// 事件将会继续发送, 但是订阅器里面并不会接受
                //e.onComplete(); //只能发同一种类型
                DVLogUtils.dt();
            }
        }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {

            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {

            }
        }, new Action() {
            @Override
            public void run() throws Exception {

            }
        });


        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {

                DVLogUtils.dt();
                e.onNext(1);
                e.onNext(2);
                e.onError(new Throwable("123"));//下游收到onComplete事件之后将不再继续接收事件
                e.onNext(3);// 事件将会继续发送, 但是订阅器里面并不会接受
                //e.onComplete(); //只能发同一种类型
                DVLogUtils.dt();
            }
        }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {

            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {

            }
        }, new Action() {
            @Override
            public void run() throws Exception {

            }
        }, new Consumer<Disposable>() {
            @Override
            public void accept(Disposable disposable) throws Exception {

            }
        });

    }

    /**
     * Consumer是简易版的Observer，他有多重重载，可以自定义你需要处理的信息，
     * 他只提供一个回调接口accept，由于没有onError和onCompete，无法再
     * 接受到onError或者onCompete之后，实现函数回调。
     * 无法回调，并不代表不接收，他还是会接收到onCompete和onError之后做出默认操作，
     * 也就是监听者（Consumer）不在接收
     */
    @OnClick(R.id.bottom3)
    public void create3(){

//        Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
//
//                DVLogUtils.dt();
//                e.onNext(1);
//                e.onNext(2);
//                e.onComplete();//下游收到onComplete事件之后将不再继续接收事件
//                e.onNext(3);// 事件将会继续发送, 但是订阅器里面并不会接受
//                //e.onComplete(); //只能发同一种类型
//                DVLogUtils.dt();
//            }
//        }).subscribe(new Consumer<Integer>() {
//            @Override
//            public void accept(Integer integer) throws Exception {
//
//                DVLogUtils.dt();
//            }
//        });

        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {

                DVLogUtils.dt();
                e.onNext(1);
                e.onNext(2);
                e.onError(new Throwable("123"));//下游收到onComplete事件之后将不再继续接收事件
                e.onNext(3);// 事件将会继续发送, 但是订阅器里面并不会接受
                //e.onComplete(); //只能发同一种类型
                DVLogUtils.dt();
            }
        }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                DVLogUtils.dt(integer);

            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                DVLogUtils.dt(throwable);

            }
        });

//        Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
//
//                DVLogUtils.dt();
//                e.onNext(1);
//                e.onNext(2);
//                e.onComplete();//下游收到onComplete事件之后将不再继续接收事件
//                e.onNext(3);// 事件将会继续发送, 但是订阅器里面并不会接受
//                //e.onComplete(); //只能发同一种类型
//                DVLogUtils.dt();
//            }
//        }).subscribe(new Consumer<Integer>() {
//            @Override
//            public void accept(Integer integer) throws Exception {
//                DVLogUtils.dt();
//
//            }
//        }, new Consumer<Throwable>() {
//            @Override
//            public void accept(Throwable throwable) throws Exception {
//                DVLogUtils.dt();
//
//            }
//        }, new Action() {
//            @Override
//            public void run() throws Exception {
//                DVLogUtils.dt();
//
//            }
//        });
//
//
//        Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
//
//                DVLogUtils.dt();
//                e.onNext(1);
//                e.onNext(2);
//                e.onComplete();//下游收到onComplete事件之后将不再继续接收事件
//                e.onNext(3);// 事件将会继续发送, 但是订阅器里面并不会接受
//                //e.onComplete(); //只能发同一种类型
//                DVLogUtils.dt();
//            }
//        }).subscribe(new Consumer<Integer>() {
//            @Override
//            public void accept(Integer integer) throws Exception {
//                DVLogUtils.dt();
//
//            }
//        }, new Consumer<Throwable>() {
//            @Override
//            public void accept(Throwable throwable) throws Exception {
//                DVLogUtils.dt();
//
//            }
//        }, new Action() {
//            @Override
//            public void run() throws Exception {
//                DVLogUtils.dt();
//
//            }
//        }, new Consumer<Disposable>() {
//            @Override
//            public void accept(Disposable disposable) throws Exception {
//                DVLogUtils.dt();
//
//            }
//        });

    }

    /**
     * map
     * Observable.create return Observable
     */
    @OnClick(R.id.bottom4)
    public void create4() {
        Observable observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                DVLogUtils.dt();
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                DVLogUtils.dt();
            }
        });

        observable.map(new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) throws Exception {
                DVLogUtils.dt();
                return integer.toString();
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {

                DVLogUtils.dt(s);
            }
        });
    }

    /**
     * flatmap
     * 类型转换
     * 比如说服务端返回的数据我们再重新组装一下
     * woman -> man
     */
    @OnClick(R.id.bottom5)
    public void create5(){

        Disposable disposable = Observable.create(new ObservableOnSubscribe<Woman>() {
            @Override
            public void subscribe(ObservableEmitter<Woman> e) throws Exception {
                e.onNext(new Woman("woman11", 30, "woman"));
                e.onNext(new Woman("woman111", 31, "woman"));
            }
        }).flatMap(new Function<Woman, ObservableSource<Man>>() {
            @Override
            public ObservableSource<Man> apply(Woman t) throws Exception {
                final List<Man> list = new ArrayList<>();
                for (int i = 0; i < 2; i++) {
                    Man man = new Man(t.getName(), t.getAge(), "man");
                    list.add(man);
                }
                return Observable.fromIterable(list);
            }
        }).subscribe(new Consumer<Man>() {
            @Override
            public void accept(Man man) throws Exception {

                DVLogUtils.dt(man);
            }
        });

        Observable.create(new ObservableOnSubscribe<Woman>() {
            @Override
            public void subscribe(ObservableEmitter<Woman> e) throws Exception {

                e.onNext(new Woman("woman", 30, "woman"));
                e.onNext(new Woman("woman1", 31, "woman"));
            }
        }).flatMap(new Function<Woman, ObservableSource<Man>>() {
            @Override
            public ObservableSource<Man> apply(final Woman woman) throws Exception {
                return Observable.create(new ObservableOnSubscribe<Man>() {
                    @Override
                    public void subscribe(ObservableEmitter<Man> e) throws Exception {
                        e.onNext(new Man(woman.getName(), woman.getAge(), "man"));
                    }
                });
            }
        }).subscribe(new Observer<Man>() {
            @Override
            public void onSubscribe(Disposable d) {

                DVLogUtils.dt();
            }

            @Override
            public void onNext(Man man) {

                DVLogUtils.dt(man);
            }

            @Override
            public void onError(Throwable e) {

                DVLogUtils.dt();
            }

            @Override
            public void onComplete() {

                DVLogUtils.dt();
            }
        });
    }

    /**
     * zip 合并事件
     */
    @OnClick(R.id.bottom6)
    public void create6(){

        Observable integer = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {

                DVLogUtils.dt();
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                DVLogUtils.dt();
            }
        });

        Observable string = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {

                DVLogUtils.dt();
                e.onNext("A");
                e.onNext("B");
                e.onNext("C");
                DVLogUtils.dt();
            }
        });

        Observable.zip(string, integer, new BiFunction<String, Integer, String>() {
            @Override
            public String apply(String s, Integer i) throws Exception {
                return s + " " + i;
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                DVLogUtils.dt("zip : accept : " + s);
            }
        });
    }

    /**
     *
     */
    @OnClick(R.id.bottom7)
    public void doOnNext() {
        Disposable disposable = Observable.just(1,2,3)
                .doOnNext(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        integer += 3;
                        DVLogUtils.dt(integer);
                    }
                })
                .flatMap(new Function<Integer, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(final Integer integer) throws Exception {
                        return Observable.create(new ObservableOnSubscribe<String>() {
                            @Override
                            public void subscribe(ObservableEmitter<String> e) throws Exception {
                                e.onNext("" + integer.intValue() + 3);
                            }
                        });
                    }
                })
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String integer) throws Exception {
                        DVLogUtils.dt(integer);
                    }
                });
    }


    /**
     * 过滤,满足条件的事件才会往下传递
     */
    @OnClick(R.id.bottom8)
    public void filter() {
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                for (int i = 0;i < 4; i++) {
                    e.onNext(""+i);
                }
            }
        }).filter(new Predicate<String>() {
            @Override
            public boolean test(String integer) throws Exception {
                return integer.equals("3");
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String integer) throws Exception {
                DVLogUtils.dt(integer);
            }
        });
    }

    /**
     * delay
     */
    @OnClick(R.id.bottom9)
    public void timer(){

        Observable.timer(2, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.newThread()) // 指定的是上游发送事件的线程
                .observeOn(Schedulers.io()) // 指定的是下游接收事件的线程
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        DVLogUtils.dt("timer :" + aLong);
                    }
                });
    }

    /**
     * 每间隔 N s 执行一次
     */
    @OnClick(R.id.bottom10)
    public void interval(){

        Observable.interval(1, TimeUnit.SECONDS)
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {

                        DVLogUtils.dt("timer :" + aLong);
                    }
                });
    }

    /**
     * 将 observable 中的数据按 skip（步长）分成最长不超过 count 的 buffer，然后生成一个 observable
     */
    @OnClick(R.id.bottom11)
    public void buffer() {

        /**
         * 将12345分组，每组的个数不超过count 2， 每隔skip 3 来取值
         * 结果
         * [1, 2]，[4, 5]
         */
        Observable.just(1, 2, 3, 4, 5)
                .buffer(2, 3)
                .subscribe(new Consumer<List<Integer>>() {
                    @Override
                    public void accept(@NonNull List<Integer> integers) throws Exception {
                        DVLogUtils.dt(integers);
                    }
                });
    }

    @OnClick(R.id.bottom12)
    public void flowable() {
        Flowable<String> flowable = Flowable.create(new FlowableOnSubscribe<String>() {
            @Override
            public void subscribe(FlowableEmitter<String> e) throws Exception {
                e.onNext("a");
                e.onNext("b");
            }
        }, BackpressureStrategy.BUFFER);

        flowable.subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.newThread())
                .subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                DVLogUtils.dt();
            }
        });

//        flowable.subscribe(new Subscriber<String>() {
//            @Override
//            public void onSubscribe(Subscription s) {
//                s.request(Long.MAX_VALUE);
//                DVLogUtils.dt();
//            }
//
//            @Override
//            public void onNext(String s) {
//
//                DVLogUtils.dt();
//            }
//
//            @Override
//            public void onError(Throwable t) {
//
//                DVLogUtils.dt();
//            }
//
//            @Override
//            public void onComplete() {
//
//                DVLogUtils.dt();
//            }
//        });

//        flowable.subscribeOn(Schedulers.newThread())
//        .observeOn(Schedulers.io())
//        .subscribe(new FlowableSubscriber<String>() {
//            @Override
//            public void onSubscribe(Subscription s) {
//                //订阅时候的操作
//                 s.request(Long.MAX_VALUE);//请求多少事件，这里表示不限制
//                DVLogUtils.dt(s);
//            }
//
//            @Override
//            public void onNext(String s) {
//
//                DVLogUtils.dt(s);
//            }
//
//            @Override
//            public void onError(Throwable t) {
//
//                DVLogUtils.dt(t);
//            }
//
//            @Override
//            public void onComplete() {
//
//                DVLogUtils.dt();
//            }
//        });

    }


    @OnClick(R.id.bottom13)
    public void compose(){

        Observable observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                DVLogUtils.dt();
                e.onNext("a");
            }
        });

        Disposable disposable1 = observable.compose(new ObservableTransformer() {
            @Override
            public ObservableSource apply(Observable upstream) {
                return upstream.subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        }).subscribe(new Consumer() {
            @Override
            public void accept(Object o) throws Exception {
                DVLogUtils.dt();
            }
        });
    }


    @OnClick(R.id.bottom14)
    public void toflowable(){

        Observable observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                DVLogUtils.dt();
                e.onNext("a");
            }
        });

        observable = observable.compose(new ObservableTransformer() {
            @Override
            public ObservableSource apply(Observable upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        });

        Flowable flowable = observable.toFlowable(BackpressureStrategy.BUFFER);

        flowable.subscribe(new Subscriber() {
            @Override
            public void onSubscribe(Subscription s) {
                s.request(2);
                DVLogUtils.dt();
            }

            @Override
            public void onNext(Object o) {
                DVLogUtils.dt();

            }

            @Override
            public void onError(Throwable t) {
                DVLogUtils.dt();

            }

            @Override
            public void onComplete() {
                DVLogUtils.dt();

            }
        });
    }
}
