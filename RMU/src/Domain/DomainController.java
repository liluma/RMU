package Domain;

public class DomainController {
    private PathController pathController;
    private SelectedFileRepository selectedFiles;
    
    public DomainController(){
        pathController = new PathController();
        selectedFiles = new SelectedFileRepository();
    }
    
    public void pathSelected(String path){
        pathController.setPath(path);
        selectedFiles.initFiles(path);
    }
}
