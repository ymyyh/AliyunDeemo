# 使用官方的 OpenJDK 21 基础镜像
FROM openjdk:21-jdk-slim

# 设置工作目录
WORKDIR /app

# 安装必要的工具和 Maven
RUN apt-get update && \
    apt-get install -y curl gnupg build-essential && \
    curl https://packages.maven.apache.org/maven.key | gpg --dearmor -o /usr/share/keyrings/maven-archive-keyring.gpg && \
    echo "deb [signed-by=/usr/share/keyrings/maven-archive-keyring.gpg] https://packages.maven.apache.org/maven-2/ $(lsb_release -cs) main" | tee /etc/apt/sources.list.d/maven.list && \
    apt-get update && \
    apt-get install -y maven && \
    rm -rf /var/lib/apt/lists/*

# 复制 Maven 的 pom.xml 并下载依赖
COPY pom.xml .
RUN mvn dependency:go-offline -B

# 复制源代码
COPY baseProject/src ./src

# 构建项目
RUN mvn package -DskipTests

# 暴露应用端口
EXPOSE 8080

# 设置启动命令
CMD ["java", "-jar", "target/AliyunDeemo.jar"]