package GUI;

import java.io.File;
import javafx.stage.DirectoryChooser;

public class FolderSelectorHelper {
    private static FolderSelectorHelper instance;
    private final DirectoryChooser  directoryChooser = new DirectoryChooser();
    private File locationFolder;
    
    private FolderSelectorHelper(){
        
    }
    
    public String SelectPath(){
        locationFolder = directoryChooser.showDialog(null);
        return locationFolder.getAbsolutePath();
    }
    
    public static FolderSelectorHelper getInstance(){
        if(instance == null)
            instance = new FolderSelectorHelper();
        
        return instance;
    }
}
