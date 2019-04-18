# log-test
spring-boot项目集成log4j和logback

## 项目介绍

此项目为spring-boot集成log4j或logback的测试项目，项目组可以选择log4j或logback作为项目日志打印，同一个项目只能选择一种日志打印方式，springboot默认集成logback，推荐使用logback

##  项目说明



- 如果选择log4j作为项目日志输出，需要显示排除spring-boot-starter-logging，并且加入spring-boot-starter-log4j2

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter</artifactId>
    <exclusions>
        <exclusion>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-logging</artifactId>
        </exclusion>
    </exclusions>
</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-log4j2</artifactId>
</dependency>
```

- src/main/resources中存放了log4j及logback的配置文件

  两种配置都支持日志控制台及文件打印，并且支持日志文件自动分割

  测试里设置成了1kb，根据情况自动设置日志大小

- 测试代码LogBackTest实现了CommandLineRunner接口，会随项目启动执行测试日志打印的方法，模拟一个线程每个一秒钟循环打印一行日志，用以测试日志分割效果