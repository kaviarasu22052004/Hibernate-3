package Dao;

import Model.Student;

public interface DaoInterface {
    void savedata(Student s);
    void removeByRoll(int roll);
    void updatebyroll(int roll, String name, double mark);
    void searchbyroll(int roll);
	void ShowData();
	void searchname(String name);
}
