package com.alibaba.function;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

import java.util.concurrent.TimeUnit;

/**
 * Created by xuliang.sxl on 2015/11/2.
 */
public class SupplierInterface {
    public static void main(String[] args) throws InterruptedException {
        /**
         * Lazy初始化，Supplier wrapped的对象只在第一次get时候会被初始化
         */
        Supplier<Integer> memoize = Suppliers.memoize(new Supplier<Integer>() {
            public Integer get() {
                System.out.println("init supplier wrapped object aaaa");
                return 1;
            }
        });
        System.out.println("main thread block");
        Thread.sleep(2000);
        System.out.println(memoize.get());
        /**
         * Supplier wrapped对象只初始化一次
         */
        Supplier<Integer> memoize2 = Suppliers.memoize(new Supplier<Integer>() {
            public Integer get() {
                System.out.println("init supplier wrapped object bbbb");
                return 1;
            }
        });
        System.out.println(memoize2.get());
        System.out.println(memoize2.get());


        /**
         * 可以使用memoizeWithExpiration函数创建过期设置的Supplier对象，时间过期，get对象会重新初始化对象
         */
        Supplier<Integer> memoize3 = Suppliers.memoizeWithExpiration(new Supplier<Integer>() {
            public Integer get() {
                System.out.println("init supplier wrapped object cccc");
                return 1;
            }
        }, 5, TimeUnit.SECONDS);

        System.out.println(memoize3.get());
        System.out.println(memoize3.get());
        Thread.sleep(6000);
        System.out.println(memoize3.get());

    }
}
