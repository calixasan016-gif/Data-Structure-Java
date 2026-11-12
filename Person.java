class Person {
    protected String name;
    protected String id;

    public void setDetails(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String describe() {
        return name + " (" + id + ")";
    }
}

class Student extends Person {
    protected double gpa;

    public void setGpa(double gpa) {
        if (gpa >= 0 && gpa <= 4.0) { // the class still protects its own validity
            this.gpa = gpa;
        }
    }

    public String studentCard() {
        return "Student " + describe() + ", GPA = " + gpa; // describe() is inherited
    }
}

class Lecturer extends Person {
    private String faculty;

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String staffCard() {
        return "Lecturer " + name + " (" + id + "), Faculty: " + faculty; // protected fields used directly
    }
}

// Level 3: inherits from Student AND (through Student) from Person
class PostgraduateStudent extends Student {
    private String thesisTitle;

    public void setThesisTitle(String thesisTitle) {
        this.thesisTitle = thesisTitle;
    }

    public String postgradCard() {
        return studentCard() + ", thesis: \"" + thesisTitle + "\"";
    }
}

// Main Class
public class UniversityPeopleDemo {
    public static void main(String[] args) {
        Student amina = new Student();
        amina.setDetails("Amina Hassan", "C1210345"); // from Person
        amina.setGpa(3.6);                          // from Student

        Lecturer abdi = new Lecturer();
        abdi.setDetails("Abdi Yusuf", "L0042");
        abdi.setFaculty("Computer & IT");

        PostgraduateStudent hodan = new PostgraduateStudent();
        hodan.setDetails("Hodan Ali", "P2300117");   // from Person, two levels up
        hodan.setGpa(3.8);                           // from Student, one level up
        hodan.setThesisTitle("Somali text classification");

        System.out.println(amina.studentCard());
        System.out.println(abdi.staffCard());
        System.out.println(hodan.postgradCard());

        // IS-A runs one way only
        System.out.println("Hodan IS-A Student? " + (hodan instanceof Student)); // true
        System.out.println("Hodan IS-A Person? " + (hodan instanceof Person));   // true

        Person p = new Person();
        System.out.println("A plain Person IS-A Student? " + (p instanceof Student)); // false

        // abdi.setGpa(3.0); // ERROR if uncommented: a Lecturer is not a Student
    }
}
