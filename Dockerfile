# 构建阶段
FROM maven:3.9.9-eclipse-temurin-21 AS builder

WORKDIR /app

# 复制 baseProject 的 pom.xml 并下载依赖
COPY baseProject/pom.xml .

# 下载所有依赖，以便后续步骤可以利用缓存
RUN mvn dependency:go-offline -B

# 复制 baseProject 的源代码
COPY baseProject/src ./baseProject/src

# 构建 baseProject 模块
RUN mvn -f baseProject/pom.xml clean package -DskipTests

# 运行阶段
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# 从构建阶段复制生成的 JAR 文件
COPY --from=builder /app/baseProject/target/baseProject-0.0.2.jar .

EXPOSE 8080

# 确保引用的 JAR 文件名称正确
CMD ["java", "-jar", "baseProject-0.0.2.jar"]