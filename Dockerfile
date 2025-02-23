# 使用官方的 OpenJDK 基础镜像
FROM openjdk:21-jdk-slim

# 设置工作目录
WORKDIR /app

# 复制 Maven 的 pom.xml 并下载依赖
COPY pom.xml .
RUN mvn dependency:go-offline -B

# 复制源代码
COPY src ./src

# 构建项目
RUN mvn package -DskipTests

# 暴露应用端口
EXPOSE 8080

# 设置启动命令
CMD ["java", "-jar", "target/AliyunDeemo.jar"]