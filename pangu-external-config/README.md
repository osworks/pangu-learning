> myclouds-nacos-config-example

## 项目说明

本项目演示如何使用 Nacos Config Starter 完成 Spring Cloud 应用的配置管理。

[Nacos](https://github.com/alibaba/Nacos) 是阿里巴巴开源的一个更易于构建云原生应用的动态服务发现、配置管理和服务管理平台。

## 实现nacos配置中心的价值

- 动态配置服务可以让你以**中心化**、**外部化**和**动态化**的方式管理所有环境的应用配置和服务配置。
- 动态配置消除了配置变更时重新部署应用和服务的需要，让配置管理变得更加高效和敏捷。
- 配置中心化管理让实现无状态服务变得更简单，让服务按需弹性扩展变得更容易。
- Nacos 提供了一个简洁易用的UI (控制台样例 Demo) 帮助你管理所有的服务和应用的配置。Nacos 还提供包括配置版本跟踪、金丝雀发布、一键回滚配置以及客户端配置更新状态跟踪在内的一系列开箱即用的配置管理特性，帮助您更安全地在生产环境中管理配置变更和降低配置变更带来的风险。

## 配置中心使用过程要注意的几个点
- dataId的完整格式：`${prefix}-${spring.profile.active}.${file-extension}`
  - prefix 默认为 spring.application.name 的值，也可以通过配置项 spring.cloud.nacos.config.prefix来配置。
  - spring.profile.active 即为当前环境对应的 profile，详情可以参考 Spring Boot文档。 
    - 规则1：当 spring.profile.active 为空时，dataId 的拼接格式变成 `${prefix}.${file-extension}`
	- 规则2：如果启动环境是test，单配置中心没有创建和test对应的dataId，则视同profile为空，还是会去找`${prefix}.${file-extension}`格式的配置文件。
  - file-exetension 为配置内容的数据格式，可以通过配置项 spring.cloud.nacos.config.file-extension 来配置。目前只支持 properties 和 yaml 类型。

- 通过 Spring Cloud 原生注解 @RefreshScope 实现配置自动更新。
- 如果是程序中通过@value注解获取配置项的值，则应该给缺省值。`@Value("${bankcard.name:}")`否则，如果配置中没有这个配置项，则应用启动失败。

## 如何运行

- 您需要先下载 Nacos 并启动 Nacos server。
- 在nacos配置中心新增一个配置，dataId为：myclouds-nacos-config-example-dev.yml
配置内容如下：
```yaml
bankcard:
  id: 532925
  name: xiongchun
```
![myclouds-nacos-config](https://oscimg.oschina.net/oscnet/c978885239c6f2b30fbfa434bcea8508c82.jpg)
- 启动本项目，增加启动参数：` -Dspring.profiles.active=dev -Dserver.port=18000`
- 请求地址：`http://127.0.0.1:18000/config/user` 将输出：`卡号: 532925，姓名: xiongchun`。
- 在nacos控制台中将xiongchun修改为gosling，再访问此url，输出将同步发生变化。
