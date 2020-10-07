package com.lz.service.impl;

import com.lz.dao.StudentDao;
import com.lz.pojo.Student;
import com.lz.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("/studentService")
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;
    @Override
    public List<Student> selectAll() {
        List<Student> students = studentDao.selectAll();
        return students;
    }

    @Override
    public List<Student> findByTeam(String steam) {
        List<Student> student = studentDao.findByTeam(steam);
        return student;
    }

    @Override
    public List<Student> findGetTname() {
        List<Student> tname = studentDao.findGetTname();
        return tname;
    }

    @Override
    public List<Student> search(String sname) {
        List<Student> likeName = studentDao.search(sname);
        return likeName;
    }

    @Override
    public int addInfo(Student student) {
        return studentDao.addInfo(student);
    }

    @Override
    public int updateInfo(Student student) {
        return studentDao.updateInfo(student);
    }

    @Override
    public int deleteInfo(Integer sid) {
        return studentDao.deleteInfo(sid);
    }
}
