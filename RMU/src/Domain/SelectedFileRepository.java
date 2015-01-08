package Domain;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SelectedFileRepository {
    private List<String> selectedFilesNames;
    
    public SelectedFileRepository(){
        selectedFilesNames = new ArrayList<String>();
    }
    
    public void initFiles(String path){
        try{
            Files.walk(Paths.get(path)).forEach(filePath -> {
                if (Files.isRegularFile(filePath)) {
                    //selectedFilesNames.add(filePath.toString());
                    String filePathString = filePath.toString();
                    if(ExtensionCollection.getInstance().inFilterList(getFileExtension(filePathString))){
                        selectedFilesNames.add(filePathString);
                    }
                }
            });
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
    
    private String getFileExtension(String file) {
        if(file.lastIndexOf(".") != -1 && file.lastIndexOf(".") != 0)
        return file.substring(file.lastIndexOf("."));
        else return "";
    }

    List<String> getSelectedFiles() {
        return selectedFilesNames;
    }

    List<String> shuffleList() {
        List<String> toShuffleList = new ArrayList(selectedFilesNames);
        selectedFilesNames.clear();
        Random r = new Random();
        
        while(toShuffleList.size() > 0){
            int selectedIndex = r.nextInt(toShuffleList.size());
            selectedFilesNames.add(toShuffleList.get(selectedIndex));
            toShuffleList.remove(selectedIndex);
        }
        return selectedFilesNames;
    }
}
