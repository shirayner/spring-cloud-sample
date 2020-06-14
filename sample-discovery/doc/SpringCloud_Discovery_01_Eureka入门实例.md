# Eureka入门实例

[toc]



## 推荐阅读

> - [SpringCloud之Eureka](https://juejin.im/post/5ca4ca43e51d4577dd2e82e3)
> - [Spring Cloud Eureka：服务注册与发现](https://juejin.im/post/5d78cd53f265da03d55e8351)
> - 



## 概述

Netflix Eureka 是由Netflix 开源的一款基于 REST 的服务发现组件，包括Eureka Server 及 Eureka Client。2.x 版本已停止维护，目前主要是以1.x版本为主。



P2P的复制模式：

> Eureka Server 端采用的是 **P2P的复制模式**，但是它不保证复制操作一定能成功，因此它提供的是一个最终一致性的服务实例视图；

服务租约与定时剔除：

> Client 端在Server端 的注册信息有一个带期限的租约，一旦Server 端在指定期间没有收到Client 端发送的心跳，则Server端会认为Client端注册的服务是不健康的，定时任务会将其从注册表中删除。





## 一、Eureka 注册中心（单机版）

### 1.父工程Pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>sample-discovery</artifactId>
        <groupId>com.ray.study.sample</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>sample-discovery-eureka</artifactId>
    <packaging>pom</packaging>

    <modules>
        <module>eureka-server</module>
        <module>eureka-client</module>
    </modules>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
        <java.version>1.8</java.version>
        <maven.compiler.source>${java.version}</maven.compiler.source>
        <maven.compiler.target>${java.version}</maven.compiler.target>
        <spring-boot.version>2.2.4.RELEASE</spring-boot.version>
        <spring-cloud.version>Hoxton.SR5</spring-cloud.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-dependencies</artifactId>
                <version>${spring-boot.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>${spring-cloud.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>

</project>
```





### 2.注册中心

#### 2.1 添加依赖

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>sample-discovery-eureka</artifactId>
        <groupId>com.ray.study.sample</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>eureka-server</artifactId>

    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
        </dependency>
    </dependencies>
</project>
```



#### 2.2 启动类

```java
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }

}

```



#### 2.3 application.yml

```yml
server:
  port: 8761

eureka:
  instance:
    hostname: localhost
  client:
    register-with-eureka: false
    fetch-registry: false
    service-url:
      defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/
  server:
    wait-time-in-ms-when-sync-empty: 0
    enable-self-preservation: false
```





此时启动`EurekaServerApplication` ，然后浏览器访问 http://localhost:8761/

![image-20200614204650313](images/image-20200614204650313.png)





### 3.Eureka 客户端

#### 3.1 添加依赖









