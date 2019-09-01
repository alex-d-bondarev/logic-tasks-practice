package org.parctice.app.hackerrank.java.data_structures;

import java.util.*;

public class JavaSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        List<StudentForSort> studentList = new ArrayList<StudentForSort>();
        while (testCases > 0) {
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            StudentForSort st = new StudentForSort(id, fname, cgpa);
            studentList.add(st);

            testCases--;
        }

        Collections.sort(studentList);

        for (StudentForSort st : studentList) {
            System.out.println(st.getFname());
        }
    }
}

class StudentForSort implements Comparable<StudentForSort> {
    private int id;
    private String fname;
    private double cgpa;

    public StudentForSort(int id, String fname, double cgpa) {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public double getCgpa() {
        return cgpa;
    }

    private Comparator<StudentForSort> comparator =
            Comparator.
                    comparingDouble(StudentForSort::getCgpa).reversed().
                    thenComparing(StudentForSort::getFname).
                    thenComparingInt(StudentForSort::getId);

    @Override
    public int compareTo(StudentForSort otherStudent) {
        return comparator.compare(this, otherStudent);
    }
}
