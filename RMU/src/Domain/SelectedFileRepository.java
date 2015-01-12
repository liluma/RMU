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
        
        while(toShuffleList.size() > 0){
            int selectedIndex = r.nextInt(toShuffleList.size());
            selectedFilesNames.add(toShuffleList.get(selectedIndex));
            toShuffleList.remove(selectedIndex);
        }
        
        for(int i =0; i < selectedFilesNames.size(); i++){
            String FullPath = selectedFilesNames.get(i);
            String fileName = FullPath.replace(selectedPath + "\\", "");
            //file hernoemen           
            if(!fileName.matches("^[0-9]*-")){
                //nummertoevoegen aan naam
                fileName = String.format("%d-%s", i + 1, fileName);
                File orignalFile = new File(FullPath);
                System.out.println(orignalFile.renameTo(new File(selectedPath + "\\" + fileName)));
            }else{
                System.out.println("TODO");
            }
        }
        return selectedFilesNames;
    }
}
