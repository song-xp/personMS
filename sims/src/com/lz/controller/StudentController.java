package com.lz.controller;

import com.lz.pojo.Student;
import com.lz.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/selectAll",method = RequestMethod.POST)
    public String selectAll(Model model,HttpSession session,String steam){
        List<Student> students = studentService.selectAll();
        List<Student> tname = studentService.findGetTname();
        model.addAttribute("students",students);
        session.setAttribute("Team",tname);
        return "home";
    }

    @RequestMapping(value = "/findByTeam",method = RequestMethod.POST)
    public String findByTeam(Model model,String steam){
        List<Student> team = studentService.findByTeam(steam);
        model.addAttribute("students",team);
        model.addAttribute("steam",steam);
        return "home";
    }

    @RequestMapping(value = "/likeName",method = RequestMethod.POST)
    public String search(Model model,String sname){
        List<Student> likeName = studentService.search(sname);
        model.addAttribute("students",likeName);
        return "home";
    }

    @RequestMapping(value = "addInfo",method = RequestMethod.POST)
    public String addInfo(Student student,Model model){
        int rows = studentService.addInfo(student);
        if(rows>0){
            model.addAttribute("msg","信息插入成功！");
        }else{
            model.addAttribute("msg","信息插入失败！！！");
        }
        return "home";
    }

    @RequestMapping(value = "updateInfo",method = RequestMethod.POST)
    public String updateInfo(Student student,Model model){
        int rows = studentService.updateInfo(student);
        if(rows>0){
            model.addAttribute("msg","信息修改成功！");
        }else{
            model.addAttribute("msg","信息修改失败！！！");
        }
        return "home";
    }

    @RequestMapping(value = "deleteInfo",method = RequestMethod.POST)
    public String deleteInfo(Integer sid,Model model){
        int rows = studentService.deleteInfo(sid);
        if(rows>0){
            model.addAttribute("msg","信息删除成功！");
        }else{
            model.addAttribute("msg","信息删除失败！！！");
        }
        return "home";
    }
}
