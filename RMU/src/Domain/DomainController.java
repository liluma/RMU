package Domain;

import java.util.List;

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

    public String getSelectedPath() {
        return pathController.getPath();
    }
    
    public List<String> getSelectedFiles(){
        return selectedFiles.getSelectedFiles();
    }

    public List<String> shuffleSelectedFiles() {
        return selectedFiles.shuffleList();
    }
}
