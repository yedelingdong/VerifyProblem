package com.xx.verifyproblem.testjava;

import androidx.annotation.IntDef;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * SOURCE,CLASS,RUNTIME注解
 *
 * 分析:
 * 引用:https://blog.csdn.net/u011315960/article/details/64918467
 *
 * Android java源代码到apk可执行文件
 * java -> class -> dex -> apk
 *
 * 1、SOURCE：在原文件中有效，被编译器丢弃。
 *   在编译之后被抛弃的，存活的时间是在源码和编译中，所以我们的编译处理器仍然能正常工作。
 * 2、CLASS：在class文件有效，可能会被虚拟机忽略。
 *   .class文件我们无法操作。android系统定制开发编译过程的开发人员能够操作CLASS注解。
 * 3、RUNTIME：在运行时有效。
 *
 * 源代码级别的注解有两个意图, 一是作为文档的补充, 给人看的, 比如Override注解,
 * 二是作为源代码生成器(java和android都有注解处理器APT)的材料, 比如ButterKnife框架.
 *
 * 同样字节码级别的注解, 可以作为字节码修改, 插桩, 代理的依据, 可以使用aspectj,
 * asm等工具进行字节码修改. 比如一些模块间调用, 如果你直接写代码, 会导致耦合,
 * 此时可以加入一个注解, run一下asm这样的工具, 将注解标注的方法字段以generate的方式插入进去.
 *
 * 运行时级别的注解, 显然是用于反射后参与某些业务逻辑用的, 比如spring依赖注入.
 *
 * https://tieba.baidu.com/f?kz=4365820127&mo_device=1&ssid=0&from=1086k&uid=0&pu=usm@0,sz@320_1001,ta@iphone_2_6.0_3_537&bd_page_type=1&baiduid=BF7A8D7636F152AE405578512A7448BD&tj=www_normal_5_0_10_title?pn=0&
 *
 */
public class TestAnnotation {

    public static final int OPEN = 1;
    public static final int CLOSE = 0;

    private static int mStatus = OPEN;

    /** 限定取值范围为(OPEN,CLOSE) */
    @Retention(RetentionPolicy.SOURCE)
    @Target(ElementType.PARAMETER)
    @IntDef({OPEN,CLOSE})
    public @interface Status{
    }

    public static int getmStatus() {
        return mStatus;
    }

    public static void setmStatus(@Status int mStatus) {
        TestAnnotation.mStatus = mStatus;
    }

    public static void getCurrentStatus() {
        if (mStatus == OPEN) {
            System.out.println("打开状态");
        } else {
            System.out.println("关闭状态");
        }
    }

    public static void main(String[] args) {
        TestAnnotation.setmStatus(OPEN);
        getCurrentStatus();

        TestAnnotation.setmStatus(CLOSE);
        getCurrentStatus();
    }

}