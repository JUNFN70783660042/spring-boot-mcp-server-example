# MCP Server

[![Language](https://img.shields.io/badge/language-Java17+-blue.svg)](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
[![Framework](https://img.shields.io/badge/framework-SpringBoot3.5.7-green.svg)](https://spring.io/projects/spring-boot)
[![License](https://img.shields.io/badge/license-Apache--2.0-blue.svg)](LICENSE)

MCP Server 是一个基于 Spring Boot 的 Model Controller Protocol (MCP) 服务端实现，用于构建 AI 应用程序与工具之间的标准通信接口。

## 目录

- [项目介绍](#项目介绍)
- [技术栈](#技术栈)
- [功能特性](#功能特性)
- [快速开始](#快速开始)
- [API 文档](#api文档)
- [项目结构](#项目结构)
- [配置说明](#配置说明)
- [测试](#测试)
- [贡献指南](#贡献指南)
- [许可证](#许可证)

## 项目介绍

MCP Server 实现了 Model Controller Protocol 协议，允许 AI 模型通过标准化接口调用各种工具和服务。该项目提供了一个轻量级、可扩展的服务框架，便于开发者快速构建和部署自己的 AI 工具集。

## 技术栈

- Java 17+
- Spring Boot 3.5.7
- Spring AI 1.1.2
- Hutool 5.8.24
- Lombok
- Maven

## 功能特性

- ✅ MCP 协议实现
- ✅ 健康检查接口
- ✅ 注解扫描自动注册工具
- ✅ 同步/异步处理模式
- ✅ 可扩展的工具服务架构

## 快速开始

### 环境要求

- JDK 17 或更高版本
- Maven 3.6+

### 构建项目

```bash
# 克隆项目
git clone <repository-url>

# 进入项目目录
cd mcp-server

# 编译和打包
./mvnw clean package
```

### 运行应用

```bash
# 方式一：直接运行
./mvnw spring-boot:run

# 方式二：运行打包后的jar
java -jar target/bi-chatter.jar
```

应用默认启动在 `8088` 端口。

## API 文档

项目使用 MCP 协议进行通信，默认 endpoint 为 `/mcp`。

健康检查接口：
```
GET /mcp/tools/healthy
```

## 项目结构

```
mcp-server/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/mcp_server/
│   │   │       ├── McpServerApplication.java  # 启动类
│   │   │       └── mcp/
│   │   │           └── BaseToolService.java  # 基础工具服务示例
│   │   └── resources/
│   │       └── application.yaml             # 配置文件
│   └── test/                               # 测试代码
└── pom.xml                                 # Maven 配置文件
```

## 配置说明

在 `application.yaml` 中可以配置以下关键参数：

```yaml
spring:
  ai:
    mcp:
      server:
        type: SYNC                          # 处理类型：SYNC(同步)或ASYNC(异步)
        annotation-scanner:
          enabled: true                     # 是否启用注解扫描
        name: bi-chat-mcp                 # MCP服务名称
        protocol: STREAMABLE              # 协议类型
        streamable-http:
          mcp-endpoint: /mcp              # MCP端点路径
```

## 测试

运行测试用例：

```bash
./mvnw test
```

## 贡献指南

欢迎提交 Issue 和 Pull Request 来改进本项目。

1. Fork 本仓库
2. 创建功能分支 (`git checkout -b feature/AmazingFeature`)
3. 提交更改 (`git commit -m 'Add some AmazingFeature'`)
4. 推送到分支 (`git push origin feature/AmazingFeature`)
5. 开启 Pull Request

## 许可证

本项目采用 Apache License 2.0 许可证，详情请见 [LICENSE](LICENSE) 文件。