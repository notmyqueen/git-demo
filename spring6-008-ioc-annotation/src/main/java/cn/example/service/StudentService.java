package cn.example.service;

import cn.example.dao.StudentDao;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Resource
    private StudentDao studentDaoImplForMySQL;

    public void deleteStudent() {
        studentDaoImplForMySQL.deleteById();
    }
}
