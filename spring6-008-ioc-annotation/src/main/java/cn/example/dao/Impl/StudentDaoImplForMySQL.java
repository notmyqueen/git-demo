package cn.example.dao.Impl;

import cn.example.dao.StudentDao;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDaoImplForMySQL implements StudentDao {
    @Override
    public void deleteById() {
        System.out.println("mysql数据库正在删除学生信息");
    }
}
