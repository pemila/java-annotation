# java-annotation
java代码中自定义注解的实现



### 元注解
元注解是java中注解的注解。所有注解的实现都需要使用元注解。

元注解包含如下集中：

- @Documented

   > 会将注释包含到javaDoc中

- @Retention
   > 传入参数**RetentionPolicy**表示需要在什么级别保存该注解信息

   RetentionPolicy枚举值如下：  

   - SOURCE: 注解信息只保存在源代码中，编译时会被编译器丢弃
   - CLASS: 注解信息在.class文件中可见，但会被 VM丢弃。此项为默认项
   - RUNTIME: VM在运行时也会保留这些信息，因此可以通过反射读取到 

- @Target
    >  传入参数**ElementType**定义注解可在使用的位置

    ElementType 枚举如下：

    | 枚举值         | 解释                               |
    | -------------- | ---------------------------------- |
    | CONSTRUCT      | 构造器的声明                       |
    | LOCAL_VARIABLE | 局部变量声明                       |
    | FIELD          | 字段声明                           |
    | METHOD         | 方法声明                           |
    | PACKAGE        | 包声明                             |
    | PARAMETER      | 参数声明                           |
    | TYPE           | 类、接口（包括注解类型）或枚举声明 |

- @Inherited

    > 允许子类继承父类中的注释

### 自定义注解

自定义类注解RecordVisit

```java
@Documented
// 设定为RUNTIME时生效
@Retention(RetentionPolicy.RUNTIME)
// 声明为Class级别的注解
@Target(value = ElementType.TYPE)
public @interface RecordVisit {
    String visit() default "服务器被访问了一次";
}
```

使用如下：

```java
@RecordVisit
public class UserServiceImpl implements UserService{

    @Override
    public User register(User user) {
        user.setId(new Random().nextInt());
        return user;
    }
｝
```

##### 测试

1. 定义代理工厂

   ```java
   public class ProxyFactory {
       private Object target;
       public ProxyFactory(Object target){
           this.target = target;
       }
       /** 生成代理对象*/
       public Object getProxyInstance(){
           return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                   target.getClass().getInterfaces(),
                   (proxy, method, args) -> {
                       // 拦截目标类，检查注解使用情况
                       valid(target);
                       return method.invoke(target,args);
                   }
           );
       }
       private  <T> void valid(T t){
           Annotation[]  annotations = t.getClass().getAnnotations();
           for(Annotation an :annotations){
               AnnotationCheck.check(an);
           }
       }
   }
   ```

2. 定义注解处理类

   ``` java
   public class AnnotationCheck {
       private static Map<String,Integer> map;
   
       static {
           map = new HashMap<>();
           map.put("RecordVisit",0);
       }
   
       public static void check(Annotation annotation){
           String simpleName = annotation.annotationType().getSimpleName();
           switch (map.get(simpleName)){
               case 0:
                   // 检测到注解被使用时，do something
                   System.out.println("服务器访问次数 + 1");
                   break;
               default:
                   break;
           }
       }
   }
   ```

3. 使用jdk动态代理调用服务

   ``` java
   public static void main(String[] args) {
       UserService target = new UserServiceImpl();
       // 创建代理
       UserService proxy = (UserService) new ProxyFactory(target).getProxyInstance();
       User user = new User("天天");
       // 账号注册
       user = proxy.register(user);
       System.out.println(user);
   }
   ```

4. 输出结果

   ```verilog
   服务器访问次数 + 1
   User{id=-952421621, name='天天', password='null', status='null'}
   ```

   

### 注解的说明

![java中的annotation图解](src/main/resources/Annotation.jpg)