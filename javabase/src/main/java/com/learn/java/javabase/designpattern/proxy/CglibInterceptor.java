package com.learn.java.javabase.designpattern.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @description
 * @author: fangjc
 * @create: 2021-04-07 12:30
 **/
public class CglibInterceptor implements MethodInterceptor {
    //生成代理类
    //
    public Object getProxy(Class cla) {
        //Enhancer是CGLIB的字节码增强器
        //Generates dynamic subclasses to enable method interception
        Enhancer enhancer = new Enhancer();
        //设置要被extend的class 因此一个final类是不可以被继承的 即不能被代理
        enhancer.setSuperclass(cla);
        //设置回调方法，即设置自己的回调方法，就会调用intercept方法
        enhancer.setCallback(this);
        //反射构造方法，创建代理类对象
        return enhancer.create();
/*        MethodInterceptor tmp17_14 = this.CGLIB$CALLBACK_0;
        if (tmp17_14 != null) {
            return tmp17_14.intercept(this, CGLIB$clone$5$Method, CGLIB$emptyArgs, CGLIB$clone$5$Proxy);
        }*/
        /*
        	protected Object create(Object key) {
		try {
			ClassLoader loader = getClassLoader();
			Map<ClassLoader, ClassLoaderData> cache = CACHE;
			ClassLoaderData data = cache.get(loader);
			if (data == null) {
				synchronized (AbstractClassGenerator.class) {
					cache = CACHE;
					data = cache.get(loader);
					if (data == null) {
						Map<ClassLoader, ClassLoaderData> newCache = new WeakHashMap<ClassLoader, ClassLoaderData>(cache);
						data = new ClassLoaderData(loader);
						newCache.put(loader, data);
						CACHE = newCache;
					}
				}
			}
			this.key = key;
			Object obj = data.get(this, getUseCache());
			if (obj instanceof Class) {
				return firstInstance((Class) obj);
			}
			return nextInstance(obj);
		}
		catch (RuntimeException | Error ex) {
			throw ex;
		}
		catch (Exception ex) {
			throw new CodeGenerationException(ex);
		}
	}
         */


    }
    //被增强的对象  objects参数给拦截的方法
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib 代理");
        Object object= methodProxy.invokeSuper(o,objects);
        System.out.println("cglib 代理结束");
        return object;
    }
}
