## 类的加载器深入解析
### 类的生命周期
加载
类的加载就是把java的二进制文件.class加载到java虚拟机中
连接
    验证
        验证类的文件的类文件的有效性
    准备
        赋予变量初始值
    解析
        解析就是在类的常量池中寻找类的、接口、字段和方法的符号引用替换成直接引用
初始化
    为类的变量赋予正确的初始值
类的实例化
    为新对象分配内存
    为实例变量赋予默认值
    为实例变量为编译一个实例初始化的方法，java的class文件实例化方法惩治为init方法
垃圾回收和对象终结
### 类加载器
系统加载器
根加载器 扩展加载器  系统加载器（应用加载器）
自定义加载
jvm允许类加载器在预料到某个类将要被使用时就预先加载它
 比如调用的子接口的父接口的变量，子接口已经加载到内存里
### 类的验证
类文件的结构检查
语义检查
字节码检查
二进制兼容性检查
### 类的初始化
静态变量的初始化可以分为：1静态变量声明处 2静态代码块
初始化步骤
   类没有被加载和初始化，先进行加载和初始化
   假如这个类的父类没有被初始化，先初始化这个类的父类
   假如这个类有初始化语句，就依次执行这些初始语句
类的初始化时机（七种），主动使用
    创建类的实例
    访问某个类或者接口的静态变量，或者对该静态变量赋值
    调用类的静态方法
    反射
    初始化一个类的子类
    启动类
初始化一个接口、类并不会初始化它的父接口，只有首次使用该接口的静态变量的时候，
才会初始化接口

双亲委派机制
jdK1.2开始，加载类时双亲委派机制，比如加载Sample类的时候，会让父加载器去加载Sample，若
父加载器能加载，则由父加载器完成加载任务，否则有loader本身加载Sample
根加载器（BootStrap）
没有父加载器，负责加载虚拟机的核心类库，比如java.lang.*
扩展类加载器（Extension)
父加载器是根加载器，时java.lang.ClassLoader的子类
系统加载器（System）
从环境变量classpath或者系统属性指定的目录加载类，它是用户指定的类的加载器的父加载器

   
## 工具
### jstack
```shell
top -Hp 19478 
asiainfo@ynyux-ps-dpifx-bd001-rh2288h:[/export/home/asiainfo/project/ai-c3-dpi-filler/logs]printf "%x\n" 19479
4c17
asiainfo@ynyux-ps-dpifx-bd001-rh2288h:[/export/home/asiainfo/project/ai-c3-dpi-filler/logs]jstack  19478|grep  4c17
"DestroyJavaVM" #43 prio=5 os_prio=0 tid=0x00007f4924008800 nid=0x4c17 waiting on condition [0x0000000000000000]
asiainfo@ynyux-ps-dpifx-bd001-rh2288h:[/export/home/asiainfo/project/ai-c3-dpi-filler/logs]
```