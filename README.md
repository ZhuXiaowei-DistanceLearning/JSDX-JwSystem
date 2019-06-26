# JSDX-JwSystem
基于springcloud的教务管理系统
技术栈：
  springcloud
  springboot
  thymeleaf
  jwt权限验证
  rabbitmq 消息队列
  redis 数据库
  mongodb 数据库
  mysql 数据库
  springdata 数据操作框架
  mybatis-plus 数据库操作框架
项目分布：
  JSDX-JwSystem 父.pom
    jw-common 工具类.pom
    jw-registry eureka注册服务中心.pom
    jw-gateway  zuul路由网关.pom
    jw-user 用户中心父.pom
      jw-user-interface user模块接口.pom
      jw-user-service   user模块服务.pom
    jw-manager 后台管理系统父.pom
      jw-manager-interface manager模块接口.pom
      jw-manager-service   manager模块服务.pom
    jw-auth-center 用户认证中心父.pom
      jw-auth-common  认证中心工具包.pom
      jw-auth-service 认证中心服务.pom
    jw-upload 文件上传/下载中心.pom
    jw-sms-service 邮件发送中心.pom