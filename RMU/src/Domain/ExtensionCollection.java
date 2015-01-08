package Domain;

import java.util.ArrayList;
import java.util.List;

public class ExtensionCollection {
    private List<String> searchableExtension;
    private List<String> activeFilters;
    private static ExtensionCollection instance;
    
    private ExtensionCollection(){
        searchableExtension = new ArrayList();        
        searchableExtension.add(".wav");
        searchableExtension.add(".flac");
        searchableExtension.add(".mp3");
        searchableExtension.add(".jpg");
        
        activeFilters = new ArrayList(searchableExtension);
    }
    
    public static ExtensionCollection getInstance(){
        if(instance == null)
            instance = new ExtensionCollection();
        
        return instance;
    }
    
    public Boolean inFilterList(String extension){
        if(activeFilters.contains(extension))
            return true;
        
        return false;
    }
    
    public List<String> getSearchableExtensions(){
        return searchableExtension;
    }
}
