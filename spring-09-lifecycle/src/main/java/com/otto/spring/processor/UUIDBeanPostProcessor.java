package com.otto.spring.processor;

import com.otto.spring.annotation.Uuid;
import lombok.SneakyThrows;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.UUID;

/**
 *
 * 要求：
 *      1，标注在任何Bean的String属性上
 *      2，在从ioc容器中获取到Bean实例时，这个属性就是一个随机值
 */
@Component
public class UUIDBeanPostProcessor implements BeanPostProcessor {
    @SneakyThrows
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        Class<?> beanClass = bean.getClass();

        // if (beanClass.equals(Department.class)) {
        //
        //     // 获取到bean的所有属性
        //     Field[] fields = beanClass.getDeclaredFields();
        //     for (Field field : fields) {
        //         System.out.println("属性：" + field);
        //         Annotation[] annotations = field.getDeclaredAnnotations();
        //         // System.out.println(Arrays.toString(annotations));
        //         for (Annotation annotation : annotations) {
        //             if (annotation.annotationType().equals(UUID.class)) {
        //                 // field.getName().getClass()
        //                 System.out.println("属性：" + field + ", 注解：" + annotation + ", 属性的类型：" + field.getType());
        //                 if (field.getType().equals(String.class)) {
        //                     // 设置访问权限（对于私有字段必须设置）
        //                     field.setAccessible(true);
        //                     field.set(bean, "uuid");
        //                 }
        //             }
        //         }
        //     }
        //
        // }

        // 获取到bean的所有属性
        Field[] fields = beanClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("属性：" + field);
            Annotation[] annotations = field.getDeclaredAnnotations();
            // System.out.println(Arrays.toString(annotations));
            for (Annotation annotation : annotations) {
                if (annotation.annotationType().equals(Uuid.class)) {
                    // field.getName().getClass()
                    System.out.println("属性：" + field + ", 注解：" + annotation + ", 属性的类型：" + field.getType());
                    if (field.getType().equals(String.class)) {
                        // 设置访问权限（对于私有字段必须设置）
                        field.setAccessible(true);
                        field.set(bean, UUID.randomUUID().toString());
                    }
                }
            }
        }



        return bean;
    }
}
