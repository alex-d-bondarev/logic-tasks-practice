package org.parctice.app.hackerrank.java.data_structures;

import java.util.*;

public class JavaPriorityQueue {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}

/*
 * Create the Student and Priorities classes below.
 */

class Student implements Comparable<Student> {

    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa){
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getCgpa() {
        return cgpa;
    }

    private Comparator<Student> comparator =
            Comparator.
                    comparingDouble(Student::getCgpa).reversed().
                    thenComparing(Student::getName).
                    thenComparingInt(Student::getId);

    @Override
    public int compareTo(Student otherStudent) {
        if(otherStudent != null) {
            return comparator.compare(this, otherStudent);
        } else {
            return -1;
        }
    }
}

class Priorities {

    List<Student> students;

    public List<Student> getStudents(List<String> events) {
        students = new ArrayList<>();

        for(String event : events){
            if(event.equals("SERVED")){
                serveStudents();
            } else {
                addNewStudent(event);
            }
        }

        return students;
    }

    private void serveStudents() {
        if(!students.isEmpty()) {
            Collections.sort(students);
            students.remove(0);
        }
    }

    private void addNewStudent(String event){
        String[] enter = event.split(" ");
        students.add(new Student(Integer.parseInt(enter[3]), enter[1], Double.parseDouble(enter[2])));
    }
}
