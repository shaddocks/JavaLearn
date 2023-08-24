package com.lulu.mybatis;

import com.lulu.mybatis.bean.Emp;
import com.lulu.mybatis.bean.Student;
import com.lulu.mybatis.mapper.*;
import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Log4j2
public class MybatisTest {

    SqlSession session = null;

    @BeforeEach
    public void testBefore() throws IOException {
        InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(stream);
        session = factory.openSession(true);
        stream.close();
    }

    @Test
    public void test01() throws IOException {
        //加载核心配置文件
        @Cleanup
        InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
        //获取SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //获取factory
        SqlSessionFactory factory = builder.build(stream);
        //获取SqlSession 若为true，则自动提交
        @Cleanup
        SqlSession sqlSession = factory.openSession();
        //获取mapper接口对象
        StudentTestMapper studentTestMapper = sqlSession.getMapper(StudentTestMapper.class);
        System.out.println(studentTestMapper.insertStudent());
        System.out.println(studentTestMapper.getAllStudent());
        System.out.println(studentTestMapper.updateStudent());
        System.out.println(studentTestMapper.getStudentById());
        sqlSession.commit();
    }

    @Test
    public void test02() {
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        System.out.println(mapper.getStudentById("20170910"));
    }

    @Test
    public void test03() {
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        Student student = new Student()
                                .setFirstName("lu").setLastName("lu")
                                .setAge(25).setId("20190110")
                                .setGender(1).setDesc("hello");
        mapper.insertStudent(student);
    }

    @Test
    public void test04() {
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        Random random = new Random(System.currentTimeMillis());
        int id = 20100101;
        for (int i = 0; i < 20; i++) {
            id += 1;
            StringBuilder name = new StringBuilder();
            for (int j = 0; j < 2; j++) {
                name.append((char) (97 + random.nextInt(26)));
            }
            Student student = new Student()
                    .setFirstName(name.toString()).setLastName(name.toString())
                    .setGender(1).setAge(22)
                    .setId(String.valueOf(id));
            mapper.insertStudent(student);
        }
    }

    @Test
    public void test05() {
        SelectMapper mapper = session.getMapper(SelectMapper.class);
        Map<String, Student> map = mapper.getStudentById("20100102");
        for (String key: map.keySet()) {
            System.out.println("key :" + key + ", value: " + map.get(key));
        }
    }

    @Test
    public void test06() {
        SelectMapper mapper = session.getMapper(SelectMapper.class);
        List<Student> students = mapper.getAllStudent();
        students.forEach(System.out::println);
    }

    @Test
    public void test07() {
        SelectMapper mapper = session.getMapper(SelectMapper.class);
        Integer count = mapper.getCount();
        System.out.println(count);
    }

    @Test
    public void test08() {
        SelectMapper mapper = session.getMapper(SelectMapper.class);
        Map<String, Object> attribute = mapper.getAttribute("20100102");
        System.out.println(attribute);
    }

    @Test
    public void test09() {
        SQLMapper mapper = session.getMapper(SQLMapper.class);
        List<Student> students = mapper.getStudentByLike("x");
        students.forEach(System.out::println);
    }

    @Test
    public void test10() {
        SQLMapper mapper = session.getMapper(SQLMapper.class);
        Emp emp1 = mapper.getEmpByIdOne("201701");
        System.out.println(emp1);
        Emp emp2 = mapper.getEmpByIdTwo("201702");
        System.out.println(emp2);
    }

    @Test
    public void test11() {
        EmpMapper mapper = session.getMapper(EmpMapper.class);
        System.out.println(mapper.getEmpById("201701"));
    }

    @Test
    public void test12() {
        DeptMapper mapper = session.getMapper(DeptMapper.class);
        System.out.println(mapper.getDeptAndEmpById("001"));
        System.out.println(mapper.getDeptAndEmpByIdStepOne("001"));
    }

    //if
    //where
    //trim
    //choose-when-otherwise
    @Test
    public void test13() {
        DynamicSQLMapper mapper = session.getMapper(DynamicSQLMapper.class);
        Emp emp = new Emp().setEmpId("201701");
        List<Emp> list1 = mapper.getEmpByCondition(emp);
        System.out.println(list1);
        emp.setDeptId("06");
        List<Emp> list2 = mapper.getEmpByCondition(emp);
        System.out.println(list2);
    }

    //choose-when-otherwise
    @Test
    public void test14() {
        DynamicSQLMapper mapper = session.getMapper(DynamicSQLMapper.class);
        Emp emp = new Emp().setEmpId("201701");
        System.out.println(mapper.getEmpByChoose(emp));
        emp.setDeptId("001");
        System.out.println(mapper.getEmpByChoose(emp));
    }

    //foreach
    @Test
    public void test15() {
        DynamicSQLMapper mapper = session.getMapper(DynamicSQLMapper.class);
        System.out.println(mapper.getEmpsByList(List.of("201701", "201702", "201703")));
    }

    @AfterEach
    public void testAfter() {
        if (session != null) session.close();
    }
}
