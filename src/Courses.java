import java.util.Arrays;

public class Courses {
    private String id;
    private String[] courses;

    Courses(){
    }

    Courses(String id, String[] courses){
        this.id = id;
        this.courses = courses;
    }

    public String toLine(){
        int i;
        StringBuilder courseLine = new StringBuilder();
        for(i=0; i<courses.length-1; i++){
            courseLine.append(courses[i]).append(",");
        };

        return id + "," + courseLine + courses[i];
    }

    public String toLineExtra(){
        int i;
        StringBuilder courseLine = new StringBuilder();
        for(i=0; i<courses.length-1; i++){
            courseLine.append(courses[i]).append(",");
        };

        return courseLine + courses[i];
    }

}
