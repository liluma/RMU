package Domain;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SelectedFileRepository {
    private List<String> selectedFilesNames;
    
    public SelectedFileRepository(){
        selectedFilesNames = new ArrayList<String>();
    }
    
    public void initFiles(String path){
        try{
            Files.walk(Paths.get(path)).forEach(filePath -> {
                if (Files.isRegularFile(filePath)) {
                    
                    selectedFilesNames.add(filePath.toString());
                }
            });
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
}
