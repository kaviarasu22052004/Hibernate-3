package Hibernet.Hiberex2;

import Service.StudentService;

public class App {
    public static void main(String[] args) {
        StudentService st = new StudentService();
        //st.saveStudent();
        //st.delete();
        //st.update();
        //st.searchbyroll();
        //st.showdata();
        st.searchbyname();
    }
}
