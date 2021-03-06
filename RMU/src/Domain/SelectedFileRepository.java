package Domain;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SelectedFileRepository {
    private List<String> selectedFilesNames;
    private String selectedPath;
    
    public SelectedFileRepository(){
        selectedFilesNames = new ArrayList<String>();
    }
    
    public void initFiles(String path){
        this.selectedPath = path;
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
        int i = 1;
        
        while(toShuffleList.size() > 0){
            int selectedIndex = r.nextInt(toShuffleList.size());
            selectedFilesNames.add(shuffleName(toShuffleList.get(selectedIndex), i));
            toShuffleList.remove(selectedIndex);
            i++;
        }
        return selectedFilesNames;
    }
    
    private String shuffleName(String originalName, int index){
        String fileName = originalName.replace(selectedPath + "\\", "");
        if(fileName.matches("^\\d{1,10}[-]{1}.*?")){
            //System.out.println("editing fileName");
            String[] parts = fileName.split("-");
            fileName = "";
            for(int i = 1; i < parts.length; i++){
                fileName += parts[i];
            }
        }
        fileName = String.format("%d-%s", index, fileName);
        File orignalFile = new File(originalName);
        //System.out.println(orignalFile.renameTo(new File(selectedPath + "\\" + fileName)));
        return selectedPath + "\\" + fileName;
    }
}
