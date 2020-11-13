package com.example.leet.mki;

public class EnumDemo {
    public static void main(String[] args) {
        String report = args[0];
        if (report.equals(Report.EMPRPT.getName()))
            System.out.println("Id: " + Report.EMPRPT.getId() + " Name: " + Report.EMPRPT.getName());
        if (report.equals(Report.EMPRPT))
            System.out.println("Id: " + Report.EMPRPT.getId() + " Name: " + Report.EMPRPT.getName());
        if (report.equals(Report.MNGRPT.toString()))
            System.out.println("Id: " + Report.MNGRPT.getId() + " Name: " + Report.MNGRPT.getName());
        if (report.equals(Report.MNGRPT.getName()))
            System.out.println("Id: " + Report.MNGRPT.getId() + " Name: " + Report.MNGRPT.getName());
    }

    public enum Report {
        EMPRPT(1, "EMPLOYEE_REPORT"), MNGRPT(2, "MANAGER_REPORT");

        private int id;
        private String name;

        Report(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
