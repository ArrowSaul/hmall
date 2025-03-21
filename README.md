# 黑马商城
基于SpringCloud微服务架构的分布式电商平台，整合主流技术栈实现商品管理、订单交易、支付结算等核心功能。项目采用模块化设计，支持高并发场景下的服务治理与容错机制，并通过Docker容器化部署提升运维效率。

### 🛠️ 技术架构

| 类别         | 技术栈                                                       |
| ------------ | ------------------------------------------------------------ |
| **核心框架** | SpringBoot + SpringCloud + MyBatis-Plus                      |
| **服务治理** | Nacos（注册中心/配置中心） + Sentinel（流量控制） + Seata（分布式事务） |
| **服务通信** | OpenFeign（声明式HTTP调用） + Nginx（负载均衡）              |
| **数据库**   | MySQL  +  Redis（缓存）                                      |
| **部署运维** | Docker                                                       |

### 🧩 服务模块

| 模块              | 功能描述                                          | 关键技术点                    |
| ----------------- | ------------------------------------------------- | ----------------------------- |
| **hm-gateway**    | 全局API网关，负责路由转发、鉴权、限流             | SpringCloud Gateway + JWT鉴权 |
| **hm-common**     | 共享功能模块                                      | 共享功能                      |
| **hm-api**        | OpenFeign远程调用                                 | 声明式HTTP调用                |
| **item-service**  | 商品服务，支持SKU管理、库存扣减、商品搜索         | Elasticsearch                 |
| **trade-service** | 订单服务，处理交易流程（创建/取消订单）、状态追踪 | Seata AT模式                  |
| **pay-service**   | 支付服务，集成支付宝/微信沙箱支付                 | 分布式事务 + 幂等性设计       |
| **cart-service**  | 购物车服务，支持多端同步、过期清理                | Redis Hash结构 + TTL过期策略  |
| **user-service**  | 用户服务，实现OAuth2.0登录、权限分级管理          | Spring Security + RBAC模型    |

### 🧩功能特点

- 用户管理：实现用户注册、登录、信息管理等功能。
- 商品管理：支持商品的增删改查、分类管理等操作。
- 购物车：用户可添加、删除商品至购物车，调整商品数量。
- 订单系统：支持订单创建、支付、查询等功能。
- 支付集成：集成多种支付方式，确保支付安全便捷。
### ⚙️技术亮点

- 微服务架构：采用Spring Cloud构建微服务架构，提升系统的可扩展性和维护性。
- 分布式事务：使用Seata解决分布式事务问题，保证数据一致性。
- 服务治理：通过Nacos实现服务注册与发现，进行配置管理。
- API网关：利用Feign实现微服务间的高效通信。
- 监控与限流：使用Sentinel进行流量监控和限流，保障系统稳定性。
### 🚀启动与部署

- 配置文件：在hm-common的resources目录中有Nacos配置文件和数据库配置文件，可根据实际部署环境进行修改。
- JDK版本：项目采用JDK11，版本过低或过高可能导致启动失败或运行异常。
- 组件部署：除Sentinel外，其他组件均采用Docker部署，也可根据需要自行调整。
- 启动方式：每个可启动工程有四个YAML文件，其中bootstrap文件用于引入Nacos配置，dev和local可选，使用时需指定，application.yaml可配置数据库名等信息。
