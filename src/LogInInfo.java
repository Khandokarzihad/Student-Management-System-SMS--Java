public class LogInInfo {
    private String name;
    private String id;
    private String password;

    LogInInfo(){
    }


    LogInInfo(String name, String id, String password){
        this.name = name;
        this.id = id;
        this.password = password;
    }

    public String getName(){
        return name;
    }
    public String getId(){
        return id;
    }
    public String getPassword(){
        return password;
     }

    public String toLine(){
        return id + "," + password + "," + name;
    }

}
