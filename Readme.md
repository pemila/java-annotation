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



### 注解的说明
![java中的annotation图解](src/main/resources/Annotation.jpg)