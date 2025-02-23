# 构建阶段
FROM maven:3.9.9-eclipse-temurin-21 AS builder

WORKDIR /app

# 复制 pom.xml 并下载依赖
COPY pom.xml .
RUN mvn dependency:go-offline -B

# 复制源代码并构建项目
COPY baseProject/src ./baseProject/src
COPY baseProject/pom.xml ./baseProject/pom.xml
RUN mvn -f baseProject/pom.xml package -DskipTests

# 运行阶段
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# 从构建阶段复制生成的 JAR 文件
COPY --from=builder /app/baseProject/target/AliyunDeemo.jar .

EXPOSE 8080

CMD ["java", "-jar", "AliyunDeemo.jar"]