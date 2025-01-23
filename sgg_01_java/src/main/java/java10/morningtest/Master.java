package java10.morningtest;

public class Master {
    public void shangKe(Teacher teacher){
        if(teacher instanceof EnglishTeacher){
            EnglishTeacher et = (EnglishTeacher)teacher;
            et.jiangKe();
            et.tingLi();
        }else {
            teacher.jiangKe();
        }
    }
}
