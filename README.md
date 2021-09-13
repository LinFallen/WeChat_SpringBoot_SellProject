# WeChat_SpringBoot_SellProject
基于SpringBoot的微信页面点餐系统

- 微信公众平台公众号开发
- 微信开放平台——用于第三方微信登录
- github轮子，用于调用微信公众号接口 https://github.com/Wechat-Group/weixin-java-tools
- github轮子，用于调用微信支付接口 https://github.com/Pay-Group/best-pay-sdk
- 图床，利用Gitee仓库 https://gitee.com/Wablers/images

**代码写于：2021-08**

- JDK：JDK1.8版本

- SpringBoot：2.5.3

- IDE：IntelliJ IDEA 2021.1 (Ultimate Edition)

- 操作系统：Windows 10 专业版  版本号 21H1

- 虚拟机与系统：VMware 16，CentOS7.3

    包括软件：

    - jdk 1.8.0_111
    - nginx 1.11.7
    - mysql 5.7.17
    - redis 3.2.8
    
- **写在前面**：支付和微信扫码登录功能可能有bug：因为没有合适的商户号可以使用支付和第三方登录接口，所以只是跟着视频操作了一波

- **其他**：相关文档接口、数据库构建、流程文档都在 [doc](https://github.com/LinFallen/WeChat_SpringBoot_SellProject/tree/master/doc) 中

    ​			课程链接：https://pan.baidu.com/s/1wVtGvWyaIfDpUvAPPSmYuw ，提取码：rp70

**最后注意**：因为项目后台系统验证身份时会跳转到外网映射地址，而外网映射工具映射的是本地IP，而非服务器端IP
&emsp;&emsp;所以，想要成功运行项目，要么就在服务端设置外网映射，要么更改application-prod，全指向服务器地址，而不指向外网映射网址，要么运行本地项目
