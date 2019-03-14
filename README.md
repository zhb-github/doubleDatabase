# spring boot 多数据源配置


## 操作手册

+ 创建两个数据库,一个master,一个slave,也可以自己定义数据库的名称,但是需要在项目的配置文件进行修改
+ 新建表, 导入sql文件master.sql与slave.sql
+ 修改配置, 把项目中的数据库改为自己的数据库配置
+ 启动项目,测试 UserInfoController 类中的两个接口即可



