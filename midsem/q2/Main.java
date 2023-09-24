package Question_2;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args){
        System.out.println("least criteria is first (ascending order)\n");
        Student s1 = new Student("A","A",1,"A","A","A",110034,8.1,2022,"dayScholar");
        Student s2 = new Student("B","B",2,"B","B","B",110040,8.3,2021,"dayScholar");
        Student s3 = new Student("C","C",3,"C","C","C",110036,7.9,2022,"dayScholar");
        Student s4 = new Student("D","D",4,"D","D","D",110038,8.0,2021,"dayScholar");
        Student s5 = new Student("E","E",5,"E","E","E",110032,8.2,2022,"dayScholar");
        int IIITD_pin = 110020;
        s1.calcDist(IIITD_pin);
        s2.calcDist(IIITD_pin);
        s3.calcDist(IIITD_pin);
        s4.calcDist(IIITD_pin);
        s5.calcDist(IIITD_pin);

        ArrayList<Student> arr = new ArrayList<Student>();
        arr.add(s1);
        arr.add(s2);
        arr.add(s3);
        arr.add(s4);
        arr.add(s5);

        arr.sort(Comparator.comparing(Student::getCGPA));
        System.out.print("ranks on basis of CGPA: ");
        System.out.println(arr);
        arr.sort(Comparator.comparing(Student::getDist));
        System.out.print("ranks on basis of distance: ");
        System.out.println(arr);

        arr.sort(Comparator.comparing(Student::getHostel));
        System.out.print("ranks on basis of joint criteria: ");
        System.out.println(arr);

        for (int i=2; i<arr.size(); i++){
            arr.get(i).setStatus("onCampus");
        }
        System.out.println("\nHostels have been alloted to 3 selected students\n");

        s1.goToWork();
        s2.goToWork();
        s3.goToWork();
        s4.goToWork();
        s5.goToWork();
    }
}