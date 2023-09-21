package km.filesoperations;
import java.io.IOException;
import java.util.List;

public interface FindMultipleFilesInterface {

    /**
     * 
     * @return
     */
    List<String> getExtList();

    /**
     * 
     * @return
     */
    List<String> getPathsList();

    /**
     * 
     * @return
     */
    String getDirectoryName();

    /**
     * 
     * @return
     */
    List<String> getNamesList();

    /**
     * 
     * @return
     */
    int getMaxDepth();

    /**
     * Set max subdiractories which will be included in the search
     * @param MaxDepth int
     */
    void setMaxDepth(int MaxDepth);

    /**
     * Set the files extentions which you want to find
     * @param extList List<String> 
     */
    void setExtList(List<String> extList);

    /**
     * Set the directory as path which is to be searched
     * @param directoryName String
     */
    void setDirectoryName(String directoryName);

    /**
     * Find the files in the setted directory
     * @return List<String>
     * @throws IOException If the set path doesn't exist
     */
    List<String> FindFiles() throws IOException;

    /**
     * 
     * @return
     * @throws IOException
     */
    List<String> GetNames() throws IOException;
    
    /**
     * 
     * @param pathsList List<String>
     * @return
     * @throws IOException
     */
    List<String> GetNames(List<String> pathsList) throws IOException;

    /**
     * 
     * @return
     */
    int PathsSize();

    /**
     * 
     * @return
     */
    int NamesSize();

}