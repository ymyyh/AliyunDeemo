# 第一阶段：构建
FROM maven:3.8.6-eclipse-temurin-21 AS builder
WORKDIR /app

# 安装必要的工具
RUN apt-get update && apt-get install -y curl git

# 复制 pom.xml 并下载依赖
COPY pom.xml .
RUN mvn dependency:go-offline -B

# 复制源代码并构建项目
COPY baseProject/src ./src
RUN mvn package -DskipTests

# 第二阶段：运行
FROM openjdk:21-jre-slim
WORKDIR /app
COPY --from=builder /app/target/AliyunDeemo.jar .
EXPOSE 8080
CMD ["java", "-jar", "AliyunDeemo.jar"]