# 选择构建用基础镜像
FROM maven:3.9.4-eclipse-temurin-21-alpine as build

# 指定构建过程中的工作目录
WORKDIR /app

# 将src目录下所有文件，拷贝到工作目录中src目录下
COPY src /app/src

# 将pom.xml文件，拷贝到工作目录下
COPY settings.xml pom.xml /app/

# 执行代码编译命令
RUN mvn -s /app/settings.xml -f /app/pom.xml clean package

# 选择运行时基础镜像
FROM eclipse-temurin:21-jre-alpine

# 容器默认时区为UTC，如需使用上海时间请启用以下时区设置命令
# RUN apk add tzdata && cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo Asia/Shanghai > /etc/timezone

# 使用 HTTPS 协议访问容器云调用证书安装
RUN apk add --no-cache ca-certificates

# 指定运行时的工作目录
WORKDIR /app

# 将构建产物jar包拷贝到运行时目录中
COPY --from=build /app/target/*.jar .

# 暴露端口
EXPOSE 80

# 执行启动命令
CMD ["java", "-jar", "/app/your-app-name.jar"]