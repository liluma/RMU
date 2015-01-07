package Domain;

public class PathController {
    private String path;
    
    public PathController(){
        setPath(null);
    }
    
    public void setPath(String path){
        this.path = path;
    }
    
    public String getPath(){
        return path;
    }
}
