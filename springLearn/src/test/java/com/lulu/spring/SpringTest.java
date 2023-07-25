package com.lulu.spring;

import com.alibaba.druid.pool.DruidDataSource;
import com.lulu.spring.bean.Country;
import com.lulu.spring.factory.MyFactoryBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = "classpath:/spring.xml")
public class SpringTest {

    @Autowired
    Country country;
    @Autowired
    MyFactoryBean factoryBean;
    @Autowired
    DruidDataSource dataSource;

    /**
     * xml属性注入
     */
    @Test
    public void test01() {
        System.out.println(country);
    }

    /**
     * spring包含两种bean，一是普通bean，二是factoryBean
     */
    @Test
    public void test02() {
        System.out.println(factoryBean.getObject());
    }

    /**
     * bean作用域一般是singleton(单例模式)，可设置scope属性，为prototype(原型模式)
     * 设置 scope 值是 singleton 时候，加载 spring 配置文件时候就会创建单实例对象 ；
     * 设置 scope 值是 prototype 时候，不是在加载 spring 配置文件时候创建对象，在调用 getBean 方法时候创建多实例对象
     */
    @Test
    public void test03() {

    }

    /**
     * bean的生命周期
     * 1.通过构造器创建 bean 实例（无参数构造）
     * 2.为 bean 的属性设置值和对其他 bean 引用（调用 set 方法）
     * 3.调用 bean 的初始化的方法（需要进行配置初始化的方法）
     * 4.bean 可以使用了（对象获取到了）
     * 5.当容器关闭时候，调用 bean 的销毁的方法（需要进行配置销毁的方法）
     * ---------七步---------
     * 1,2
     * 3.把 bean 实例传递 bean 后置处理器的方法 postProcessBeforeInitialization
     * 4.调用 bean 的初始化的方法（需要进行配置初始化的方法）
     * 5.把 bean 实例传递 bean 后置处理器的方法 postProcessAfterInitialization
     * 6,7
     */
    @Test
    public void test04() {

    }

    /**
     * 外部属性资源文件
     */
    @Test
    public void test05() {
        System.out.println(dataSource);
        dataSource.close();
    }
}
