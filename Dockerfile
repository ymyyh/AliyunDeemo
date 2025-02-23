# 第一阶段：构建
FROM maven:3.8.6-openjdk-21 AS builder
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY baseProject/src ./src
RUN mvn package -DskipTests

# 第二阶段：运行
FROM openjdk:21-jre-slim
WORKDIR /app
COPY --from=builder /app/target/AliyunDeemo.jar .
EXPOSE 8080
CMD ["java", "-jar", "AliyunDeemo.jar"]