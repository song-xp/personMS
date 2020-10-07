package com.lz.service;

import com.lz.pojo.Student;

import java.util.List;

public interface StudentService {
    public List<Student> selectAll();
    public List<Student> findByTeam(String steam);
    public List<Student> findGetTname();
    public List<Student> search(String sname);
    public int addInfo(Student student);
    public int updateInfo(Student student);
    public int deleteInfo(Integer sid);
}
