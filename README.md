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
<br>
问题<br>
1、user-mapper 中，resultMap 最好放前面<br>
2、user-mapper 中，46 like 的用法不正确<br>
3、未实现统计的功能，比如60分以上多少人，80-90分的多少人，不需要看明细数据<br>
4、未实现批量插入的功能<br>
5、UserService.addUsers 方法未被调用<br>
6、UserService.addUsers 中的count定义无意义或者说定义位置错误<br>
7、可以不写页面，测试使用junit、testng或者直接postman 测试接口<br>
修改<br>
统计功能不用查询明细数据，因此只用统计各个等级的人数即可，弃用模糊查询<br>
批量插入直接通过sql实现批处理，不用循环插入
