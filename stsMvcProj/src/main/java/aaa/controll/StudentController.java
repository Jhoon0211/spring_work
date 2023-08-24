package aaa.controll;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import aaa.model.Student;
import aaa.model.StudentData;

//@Controller
//@RequestMapping("request/")
public class StudentController {

    @RequestMapping("studentForm")
    String studentForm(Model mm) {
        return "req/studentForm";
    }
	/*
	 * // 반 별 정렬
	 * 
	 * @RequestMapping("studentBan") String studentBan(Student student, Model mm) {
	 * ArrayList<StudentData> studentlist = student.getStudat(); //
	 * System.out.println(student.getStudat());
	 * 
	 * // 학생 데이터를 받아와서 정렬 Collections.sort(studentlist,
	 * Comparator.comparing(StudentData::getBan));
	 * 
	 * mm.addAttribute("studentlist", studentlist); return "req/studentBan"; }
	 * 
	 * // 점수 별 정렬
	 * 
	 * @RequestMapping("studentSco") String studentSco(Student student, Model mm) {
	 * ArrayList<StudentData> studentlist = student.getStudat(); //
	 * System.out.println(student.getStudat());
	 * 
	 * // 학생 데이터를 받아와서 정렬 Collections.sort(studentlist,
	 * Comparator.comparing(StudentData::getTotal).reversed());
	 * mm.addAttribute("studentlist", studentlist); return "req/studentSco"; }
	 */
}
