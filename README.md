# multipleDataDources
基于springboot mybatis实现方式的多数据源项目基础架构

#### 项目说名
实际上就相当于一个项目中启动了两套Mybatis，两套Mybatis互不耽误、互不影响，两套Mybatis的mapper接口和mapper.xml文件互相分开

#### 另外说明
多数据源项目还有另一种通过AOP在访问数据库时临时添加一个数据源来实现动态数据源，而本项目中本质山是启动了两个mybatis的非动态数据源
