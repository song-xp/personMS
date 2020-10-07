package com.lz.dao;

import com.lz.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {
    public List<Student> selectAll();
    public List<Student> findByTeam(String steam);
    public List<Student> findGetTname();
    public List<Student> search(String sname);
    public int addInfo(Student student);
    public int updateInfo(Student student);
    public int deleteInfo(Integer sid);
}
