# spring-learning 

## customAnnotation 自定义注解
#### 注解的原理
<p>
    &emsp &emsp 注解本质是一个继承了Annotation的特殊接口，其具体实现类是Java运行时生成的动态代理类。而我们通过反射获取注解时，返回的是Java运行时生成的动态代理对象$Proxy1。通过代理对象调用自定义注解（接口）的方法，会最终调用AnnotationInvocationHandler的invoke方法。该方法会从memberValues这个Map中索引出对应的值。而memberValues的来源是Java常量池。
</p>

#### 元注解 @Documented,@Retention,@Target,@Inherited
- @Documented –注解是否将包含在JavaDoc中
- @Retention –定义该注解的生命周期,它接收RetentionPolicy参数可能的值包括:
    - SOURCE : –在编译阶段丢弃。这些注解在编译结束之后就不再有任何意义，所以它们不会写入字节码。@Override, @SuppressWarnings都属于这类注解。
    - CLASS : –在类加载的时候丢弃。在字节码文件的处理中有用,但会被VM丢弃,注解默认使用这种方式
    - RUNTIME : –始终不会丢弃，VM将在运行期间保留注解，因此可以通过反射机制读取注解的信息。(常用)。
- @Target : -定义注解所修饰的对象范围,它接收RetentionPolicy参数可能的值包括:
    - CONSTRUCTOR : -用于构造器的声明
    - FIELD : -用于成员变量、对象、属性（包括enum实例）的常量
    - LOCAL_VARIABLE : -用于描述局部变量
    - METHOD : -用于方法声明
    - PACKAGE : -用于描述包
    - PARAMETER : -用于描述参数（方法参数）
    - TYPE : -用于描述类、接口(包括注解类型) 或enum声明
- @Inherited –定义该注释和子类的关系
## customTag 自定义标签
#### 大致需要以下几个步骤：
- 创建需要扩展的组件
- 定义XSD文件描述组件内容
- 解析XSD文件中的定义和组件定义
- 将组件注册到Spring容器
- 配置文件 spring.handlers和spring.schemas 