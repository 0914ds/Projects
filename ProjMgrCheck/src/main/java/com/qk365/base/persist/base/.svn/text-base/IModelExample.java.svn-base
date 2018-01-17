package com.qk365.base.persist.base;

/**
 * IModelExample是一个动态查询条件的标识接口.
 * 
 * 1. 简单查询:
 * 以下示例是使用生成的example类生成where语句
 * TestTableExample example = new TestTableExample();
 * example.createCriteria().andField1EqualTo(5);
 * 也可以这样写
 * TestTableExample example = new TestTableExample();
 * example.or().andField1EqualTo(5);
 * 产生的where语句如
 * where field1 = 5.
 * 
 * 
 * 2. 复杂查询:
 * TestTableExample example = new TestTableExample();
 * example.or()
 *   .andField1EqualTo(5)
 *   .andField2IsNull();
 *
 * example.or()
 *   .andField3NotEqualTo(9)
 *   .andField4IsNotNull();
 *
 * List<Integer> field5Values = new ArrayList<Integer>();
 * field5Values.add(8);
 * field5Values.add(11);
 * field5Values.add(14);
 * field5Values.add(22);
 *
 * example.or()
 *   .andField5In(field5Values);
 *
 * example.or()
 *   .andField6Between(3, 7);
 * 
 * 产生的where语句如
 * where (field1 = 5 and field2 is null)
 *     or (field3 <> 9 and field4 is not null)
 *     or (field5 in (8, 11, 14, 22))
 *     or (field6 between 3 and 7)
 * 
 * 
 * 3. distinct查询:
 * 调用setDistinct(true)
 * 
 * 
 * 4. Criteria查询:
 * 每一个字段都有一个andXXX方法
 * IS NULL - 表示相关字段必须为NULL
 * IS NOT NULL - 表示相关字段必须不为NULL
 *  = (equal) - 表示相关字段必须为传入的值
 *  <> (not equal) - 表示相关字段必须不为传入的值
 *  > (greater than) - 表示相关字段必须大于传入的值
 *  >= (greater than or equal) - 表示相关字段必须大于或等于传入的值
 *  < (less than) - 表示相关字段必须小于传入的值
 *  <= (less than or equal) - 表示相关字段必须小于或等于传入的值
 *  LIKE - 表示相关字段与传入的值模糊匹配，方法本身没有加入'%'，调用者必须自行加入'%'
 *  NOT LIKE - 表示相关字段不是与传入的值模糊匹配的，方法本身没有加入'%'，调用者必须自行加入'%'
 *  BETWEEN - 表示相关字段在传入的参数之间的
 *  NOT BETWEEN - 表示相关字段不在传入的参数之间的
 *  IN - 表示相关字段必须在传入的列表之中
 *  NOT IN - 表示相关字段必须不在传入的列表之中
 *
 */
public interface IModelExample {

}