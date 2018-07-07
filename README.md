# 一、VMwareProject
整理的vSphere Management SDK，使之能够通过idea编译运行,SDK版本为5.1，可单个sample编译运行。
# 二、注意事项
本人只测试过vsphere-ws里面general、vm目录下部分代码，正常情况下，搭建好vsphere环境，配置好编译参数，都能够编译通过并正常运行。
# 三、idea编译参数配置
![编译参数配置](https://github.com/wulikanhua/VMwareProject/raw/master/images/parameter.png)
# 四、关于vSphere Management SDK 6.0
6.0版本对sample的改动很大，官方只提供了以命令行的模式编译运行，下载6.0版本的sdk解压后在...\VMware-vSphere-SDK-6.0.0-2561048\SDK\vsphere-ws\java\JAXWS目录下有编译脚本(build.sh,build.bat)以及运行脚本(run.sh,run.bat),使用方法可以查看官方文档https://code.vmware.com/docs/1503/vsphere-management-sdk 或者解压SDK后的目录\VMware-vSphere-SDK-6.0.0-2561048\SDK\vSphereManagementSDKReadme.html
# 五、vSphere Management SDK 6.0如何在idea中编译运行
1、将...\VMware-vSphere-SDK-6.0.0-2561048\SDK\vsphere-ws\java\JAXWS\lib下的jar包导入到idea中，例如vsphere-ws/lib目录下，然后在Project Structure中选择Dependencies,点击绿色+ ->选择第一个JARs or directories->选择vsphere-ws/lib  
2、将...\VMware-vSphere-SDK-6.0.0-2561048\SDK\vsphere-ws\java\JAXWS\目录下的connection.properties、logging.properties复制到上述idea编译参数配置截图中working directory下，并指定Main class为vsphere-ws/lib/samples-core-1.0.0.jar/com.vmware.common/Main  
3、其他配置与三相同。
