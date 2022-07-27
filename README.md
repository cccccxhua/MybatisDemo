# MybatisDemo
利用Mybatis实现CRUD，导入，统计，枚举转换<br>
1.CRUD<br>
2.批量插入<br>
通过导入excel中已有的用户数据进行批量插入，插入数据采用循环执行<br>
3.统计<br>
模糊查询姓名和等级(required)实现统计功能<br>
4.枚举字段的存取和转换<br>
①定义枚举类UserScore<br>
②定义类型转换类UserScoreTypeHandler继承BaseTypeHandler<br>
③重写其方法<br>
④在mapper.xml中指定其类型转换<br>
