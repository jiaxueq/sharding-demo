项目使用springboot+mybatis+shardingsphere+mysql 演示 shardingsphere 不同需求下的分库分表

1. 演示大表的分库分表操作，及数据分布在不同数据库（db0,db1）下的多张表（table0,table1）进行数据新增与查询

2. 演示大表的单库分表操作，及数据分布在同一数据库（db0）下的多张表（table0,table1）进行数据新增与查询

3. 演示大表的多库自定义分表操作，及数据自定义分布在多数据库（db0,db1）下的多张表（table0,table1）进行数据新增与查询


准备工作
1. 新建2个mysql库，分别 导入resources/db下的sql文件


项目说明
功能演示查看UserController，进行调试

![核心查看application.yml](https://foruda.gitee.com/images/1668509574539888817/19269331_1784941.png "屏幕截图")

