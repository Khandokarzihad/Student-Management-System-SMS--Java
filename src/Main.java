import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n. . . . . . . . . . . . . . . . . . . . . . . . . . .\n" +
                ". . . . . . . . . . . . . . . . . . . . . . . . . . .\n" +
                ". . . . . . . . . . . . . . . . . . . . . . . . . . .\n" +
                ". . . . . . . STUDENT MANAGEMENT SYSTEM . . . . . . .\n" +
                ". . . . . . . . . . . .  SMS !! . . . . . . . . . . .\n" +
                ". . . . . . . . . . . . . . . . . . . . . . . . . . .\n" +
                ". . . . . . . .  Enter 0 to continue  . . . . . . . .\n" +
                ". . . . . . . . . . . . . . . . . . . . . . . . . . .\n" +
                ". . . . . . . . . . . . . . . . . . . . . . . . . . .\n" +
                ". . . . . . . . . . . . . . . . . . . . . . . . . . .\n");

        sc.nextLine();
        authentication(sc);
    }


    //Menu
    public static void menu(Scanner sc, LogInInfo l1){
        while(true){
            System.out.println("============ MENU ============\n");
            System.out.println("1. Add Student\n" +
                    "2. View all students\n" +
                    "3. Search Students\n" +
                    "4. Assign courses\n" +
                    "5. Search Assigned Courses\n" +
                    "6. Admin section\n" +
                    "0. Exit\n");
            System.out.print("Choose an option: ");
            String option = sc.nextLine();

            switch(option){
                case "1": {
                    addStudents(sc, l1);
                    break;
                }
                case "2": {
                    viewStudents(sc, l1);
                    break;
                }
                case "3":{
                    searchStudents(sc, l1);
                    break;
                }
                case "4":{
                    addCourse(sc, l1);
                    break;
                }
                case "5":{
                    searchCourse(sc, l1);
                    break;
                }
                case "6": {
                    adminSection(sc, l1);
                    break;
                }
                case "0":{
                    System.out.println("\nShutting down... All changes have been saved.");
                    System.exit(0);
                }
                default: {
                    System.err.println("Invalid Input!");
                }
            }
        }
    }


    //Add New Students
    public static void addStudents(Scanner sc, LogInInfo l1){
        System.out.println("============ ADD NEW STUDENT ============\n");
        boolean flag = false;
        //ID, name, program, batch, password and CGPA



        try {
            RandomAccessFile raf = new RandomAccessFile("Students.txt", "rw");
            String line;
            while(true){
                System.out.println("Enter Student ID: ");
                String id = sc.nextLine();
                // Checking if id already exists
                raf.seek(0);
                while((line = raf.readLine()) != null){
                    String[] info = line.split(",");
                    if(id.equals(info[0])){
                        flag = true;
                    }
                }
                if(!flag){
                    System.out.println("Enter Student Name: ");
                    String name = sc.nextLine();
                    System.out.println("Enter Student Program: ");
                    String program = sc.nextLine();
                    System.out.println("Enter Student Batch: ");
                    int batch = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Student Password: ");
                    String password = sc.nextLine();
                    System.out.println("Enter Student CGPA: ");
                    double cgpa = sc.nextDouble();
                    sc.nextLine();

                    Students s1 = new Students(id, name,program,batch,password,cgpa);

                    raf.seek(raf.length());
                    raf.writeBytes(s1.toLine() + "\n");
                    System.out.println("New Student added successfully!");
                    break;
                }
                else{
                    System.err.println("ID already taken. Try again!");
                    flag = false;
                }
            }
            }
        catch(FileNotFoundException e){
                System.err.println("File Not Found!!");
            }
        catch(IOException e){
            System.err.println("An error occurred while accessing the file!");
            }
        catch(Exception e){
            System.err.println("Something Went Wrong!!");
        }

        System.out.println("Do you want to: \n" +
                "0. Go back\n" +
                "1. Add another Student");
        String choice = sc.nextLine();
        switch(choice){
            case "0": {
                menu(sc, l1);
                break;
            }
            case "1": {
                addStudents(sc, l1);
                break;
            }
        }

    }


    //View All Students
    public static void viewStudents(Scanner sc, LogInInfo l1){
        System.out.println("============ STUDENT DETAILS ============\n");
        try{
            RandomAccessFile raf = new  RandomAccessFile("Students.txt", "r");
            String line;
            while((line = raf.readLine()) != null) {
                String[] info = line.split(",");
                System.out.printf("ID: %s   NAME: %s    PROGRAM: %s    BATCH: %s    CGPA: %s\n", info[0], info[1], info[2], info[3], info[5]);


            }
        }
        catch(FileNotFoundException e){
            System.err.println("File Not Found!!");
        }
        catch(IOException e){
            System.err.println("An error occurred while accessing the file!");
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.err.println("No Students found!");
        }
        catch(Exception e){
            System.err.println("Something Went Wrong!!");
        }
        System.out.println("\nEnter any input to go back: ");
        sc.nextLine();
        menu(sc, l1);
    }


    //Search Students
    public static void searchStudents(Scanner sc, LogInInfo l1){
        System.out.println("============ SEARCH STUDENTS ============\n");
        boolean flag = false;
        try{
            RandomAccessFile raf = new  RandomAccessFile("Students.txt", "r");
            System.out.println("Enter Student ID: ");
            String id = sc.nextLine();
            String line;
            while((line = raf.readLine()) != null) {
                String[] info = line.split(",");
                if(id.equals(info[0])){
                    System.out.printf("\nID: %s   NAME: %s    PROGRAM: %s    BATCH: %s    CGPA: %s\n", info[0], info[1], info[2], info[3], info[5]);
                    flag = true;
                }

            }
            if(!flag){
                System.err.println("No Students found!");
            }
        }
        catch(FileNotFoundException e){
            System.err.println("File Not Found!!");
        }
        catch(IOException e){
            System.err.println("An error occurred while accessing the file!");
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.err.println("No Students found!");
        }
        catch(Exception e){
            System.err.println("Something Went Wrong!!");
        }

        System.out.println("\nDo you want to: \n" +
                "0. Go back\n" +
                "1. Search another Student");
        String choice = sc.nextLine();
        switch(choice) {
            case "0": {
                menu(sc, l1);
                break;
            }
            case "1": {
                searchStudents(sc, l1);
                break;
            }
        }

    }


    //Add Courses
    public static void addCourse(Scanner sc, LogInInfo l1){
        System.out.println("============ ADD NEW COURSE ============\n");
        boolean flag = false;
        System.out.println("Enter Student ID: ");
        String id = sc.nextLine();
        System.out.println("How many courses do you want to add?");
        int n = sc.nextInt();
        sc.nextLine();
        String[] courses = new String[n];

        for(int i=0; i<n; i++){
            System.out.print("Course"+(i+1)+": " );
            courses[i] = sc.nextLine();
        }

        Courses c1 = new Courses(id, courses);
        try{
            RandomAccessFile raf = new  RandomAccessFile("Courses.txt", "rw");
            String line;
            long start;
            while((start = raf.getFilePointer()) >=0 && (line = raf.readLine()) != null ) {
                String[] courseInfo = line.split(",");
                if(id.equals(courseInfo[0])){
                    raf.seek(start);
                    raf.writeBytes(line + "," +c1.toLineExtra() + "\n");
                    System.out.println("Courses Added Successfully !");
                    flag = true;
                }

            }
            if(!flag){
                raf.seek(raf.length());
                raf.writeBytes(c1.toLine() + "\n");
                System.out.println("Courses Added Successfully !");
            }
        }
        catch(FileNotFoundException e){
            System.err.println("File Not Found!!");
        }
        catch(IOException e){
            System.err.println("An error occurred while accessing the file!");
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.err.println("No Students found!");
        }
        catch(Exception e){
            System.err.println("Something Went Wrong!!");
        }

        System.out.println("\nDo you want to: \n" +
                "0. Go back\n" +
                "1. Add more courses");
        String choice = sc.nextLine();
        switch(choice) {
            case "0": {
                menu(sc, l1);
                break;
            }
            case "1": {
                addCourse(sc, l1);
                break;
            }
        }

    }


    //Search Courses
    public static void searchCourse(Scanner sc, LogInInfo l1){
        System.out.println("============ SEARCH COURSE ============\n");
        boolean flag = false;
        try{
            RandomAccessFile raf = new  RandomAccessFile("Courses.txt", "r");
            System.out.println("Enter Student ID: ");
            String id = sc.nextLine();
            String line;
            while((line = raf.readLine()) != null) {
                String[] info = line.split(",");
                if(id.equals(info[0])){
                    System.out.print("Courses: ");
                    for(int i = 1; i < info.length-1; i++){
                        System.out.print(info[i] + ",");
                    }
                    System.out.println(info[info.length-1]);
                    flag = true;
                }

            }
            if(!flag){
                System.err.println("No Courses found!");
            }
        }
        catch(FileNotFoundException e){
            System.err.println("File Not Found!!");
        }
        catch(IOException e){
            System.err.println("An error occurred while accessing the file!");
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.err.println("No Students found!");
        }
        catch(Exception e){
            System.err.println("Something Went Wrong!!");
        }

        System.out.println("\nDo you want to: \n" +
                "0. Go back\n" +
                "1. Search Again");
        String choice = sc.nextLine();
        switch(choice) {
            case "0": {
                menu(sc, l1);
                break;
            }
            case "1":{
                searchCourse(sc, l1);
                break;
                }
        }

    }

    ////////////////////////////// ADMIN AND AUTHENTICATION //////////////////////////////////////

    //User Section
    public static void adminSection(Scanner sc, LogInInfo l1){
        System.out.println("============ ADMIN SECTION ============\n");
        System.out.println("1. Add new admin\n" +
                "2. Change Password\n" +
                "3. Sign out\n" +
                "0. Main Menu\n");
        System.out.print("Choose an option: ");
        String option = sc.nextLine();
        switch(option){
            case "1": {
                newAdmin(sc, l1);
                break;
            }
            case "2": {
                changePassword(sc, l1);
                break;
            }
            case "3": {
                System.out.println("===== LOG IN =====");
                authentication(sc);
                break;
            }
            case "0": {
                menu(sc, l1);
                break;
            }
        }
    }


    //Add New Admins
    public static void newAdmin(Scanner sc, LogInInfo l1){
        System.out.println("============ ADD NEW ADMIN ============\n");
        boolean flag = false;
        boolean flag1 = false;
        String id = l1.getId();
        System.out.println("Enter your Password: ");
        String password = sc.nextLine();


        try{
            RandomAccessFile raf = new  RandomAccessFile("Authentication.txt", "rw");
            String line;
            while((line = raf.readLine()) != null){
                String[] secureInfo = line.split(",");
                if(id.equals(secureInfo[0]) && password.equals(secureInfo[1])){
                    System.out.println(".   .   .   .   .   .   .   .");
                    System.out.println("\nEnter New Admin Name: ");
                    String newAdminName = sc.nextLine();
                    flag1 = true;
                    while(true){
                        System.out.println("Enter new ID: ");
                        String newId = sc.nextLine();

                        // Checking if id already exists
                        raf.seek(0);
                        while((line = raf.readLine()) != null){
                            String[] idPass = line.split(",");
                            if(newId.equals(idPass[0])){
                                flag = true;
                            }
                        }
                        if(!flag){
                            while(true){
                                System.out.println("Enter Password: ");
                                System.err.println("(The password must be of 8 characters!)");
                                String newPassword = sc.nextLine();
                                if(newPassword.length() == 8){
                                    LogInInfo l2 = new LogInInfo(newAdminName,newId,newPassword);
                                    raf.seek(raf.length());
                                    raf.writeBytes(l2.toLine() + "\n");
                                    System.out.println("New Admin added successfully!");
                                    break;
                                }
                                else{
                                    System.err.println("Password cannot be more or less than 8 characters, try again!");
                                }
                            }
                            break;
                        }
                        else{
                            System.err.println("ID already taken. Try again!");
                            flag = false;
                        }
                    }
                }

            }
            if(!flag1){
                System.err.println("ID and Password do not match. Try again.");
                newAdmin(sc, l1);
            }
        }
        catch(FileNotFoundException e){
            System.err.println("File Not Found!!");
        }
        catch(IOException e){
            System.err.println("An error occurred while accessing the file!");
        }
        catch(Exception e){
            System.err.println("Something Went Wrong!!");
        }

        System.out.println("Do you want to: \n" +
                "0. Go back\n" +
                "1. Add another Admin");
        String choice = sc.nextLine();
        switch(choice) {
            case "0": {
                adminSection(sc, l1);
                break;
            }
            case "1": {
                newAdmin(sc, l1);
                break;
            }
        }
    }


    //Change Password
    public static void changePassword(Scanner sc, LogInInfo l1){
        boolean flag = false;
        long start;
        System.out.println("============ CHANGE PASSWORD ============\n");
        String id = l1.getId();
        String name = l1.getName();
        System.out.println("Enter your Password:   (enter 0 to go back)");
        String password = sc.nextLine();

        try{
            RandomAccessFile raf = new  RandomAccessFile("Authentication.txt", "rw");
            String line;
            while((start = raf.getFilePointer()) >=0 && (line = raf.readLine()) != null){
                String[] secureInfo = line.split(",");
                if(id.equals(secureInfo[0]) && password.equals(secureInfo[1])){
                    flag = true;
                    while(true){
                        System.out.println("Enter new Password: ");
                        System.err.println("(The password must be of 8 characters!)");
                        String newPassword = sc.nextLine();
                        if(newPassword.equals(secureInfo[1])){
                            System.err.println("New password cannot be the same as the old password! ");
                            continue;
                        }
                        else{
                            if(newPassword.length() == 8){
                                raf.seek(start);
                                raf.writeBytes(id + "," + newPassword + "," + name + "\n");
                                System.out.println("Password changed successfully!");
                                adminSection(sc, l1);
                            }
                            else{
                                System.err.println("Password cannot be more or less than 8 characters, try again!");
                            }
                        }
                    }
                }
                else if(password.equals("0")){
                    adminSection(sc, l1);
                }
            }
            if(!flag){
                System.err.println("ID and Password do not match. Try again.");
                changePassword(sc, l1);
            }
        }
        catch(FileNotFoundException e){
            System.err.println("File Not Found!!");
        }
        catch(IOException e){
            System.err.println("An error occurred while accessing the file!");
        }
        catch(Exception e){
            System.err.println("Something Went Wrong!!");
        }

    }


    //Authentication
    public static void authentication(Scanner sc){
        boolean flag = true;
        System.out.println("\nEnter Admin ID: ");
        String id = sc.nextLine();
        System.out.println("Enter Admin Password: ");
        String password = sc.nextLine();

        try{
            RandomAccessFile raf = new  RandomAccessFile("Authentication.txt", "r");
            String line;
            while((line = raf.readLine()) != null){
                String[] secureInfo = line.split(",");
                if(id.equals(secureInfo[0]) && password.equals(secureInfo[1])){
                    LogInInfo l1 = new LogInInfo(secureInfo[2], id, password);
                    System.out.println("\n\nWELCOME BACK, " + l1.getName() + "!!\n");
                    flag = false;
                    menu(sc, l1);
                }
            }
        }
        catch(FileNotFoundException e){
            System.err.println("File Not Found!!");
        }
        catch(IOException e){
            System.err.println("An error occurred while accessing the file!");
        }
        catch(Exception e){
            System.err.println("Something Went Wrong!!");
        }

        if(flag){
            System.err.println("ID and Password do not match. Try again.");
            authentication(sc);
        }

    }
}