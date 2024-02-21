package javabascis;

public class RoleConditionProgram {

    public static void main(String[] args) {

        String role = "manager";
        int noOfWorkingDays = 15 ;

        if(role.equals("manager")){

            System.out.println(noOfWorkingDays * 500);
        }
        else if( role.equals("staff")){

            System.out.println( noOfWorkingDays * 350);
        }
        else{

        }
    }
}
