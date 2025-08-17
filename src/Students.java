public class Students {
    private String id;
    private String name;
    private String password;
    private String program;
    private int batch;
    private double cgpa;

    Students(){
    }

    Students(String id, String name, String program, int batch,String password, double cgpa) {
        this.id = id;
        this.name= name;
        this.password = password;
        this.program = program;
        this.batch = batch;
        this.cgpa = cgpa;
    }

    public String toLine(){
        return id + "," +  name + "," + program + "," + batch + "," + password + "," + cgpa;
    }
}
