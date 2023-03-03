package Find;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface FindMultipleFilesInterface {

    List<String> getExtList();

    List<String> getPathsList();

    String getDirectoryName();

    List<String> getNamesList();

    int getMaxDepth();

    void setMaxDepth(int MaxDepth);

    void setExtList(List<String> extList);

    void setDirectoryName(String directoryName);

    List<String> FindFiles() throws IOException;

    List<String> GetNames() throws IOException;
    
    List<String> GetNames(List<String> pathsList) throws IOException;

    int PathsSize();

    int NamesSize();

}