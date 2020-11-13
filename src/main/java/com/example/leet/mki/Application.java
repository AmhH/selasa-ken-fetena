package com.example.leet.mki;

import java.math.BigDecimal;

class Company{
    private int employeeCount = 10;
    class HeadBranch{
        public int getEmployeeCount(){
            return employeeCount;
            //return Company.this.employeeCount;
        }
    }
}

public class Application {

    public static void main(String[] args) {
        Company.HeadBranch company = new Company().new HeadBranch();
        //Company company = new Company.HeadBranch();
        System.out.println(company.getEmployeeCount());
    }
    //volatile BigDecimal findRoot(BigDecimal number) =>  not possible
    //transient BigDecimal findRoot(BigDecimal number) =>  not possible

}
