package km.filesoperations;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author kosta
 */
public class FindMultipleFiles implements FindMultipleFilesInterface {

    private List<String> extList = new ArrayList<>();
    private List<String> pathsList = new ArrayList<>();
    private List<String> NamesList = new ArrayList<>();
    private String directoryName;
    private int MaxDepth = 10;
    private String pathSeperator = "\\";

    public void setPathSeperator(String pathSeperator) {
        this.pathSeperator = pathSeperator;
    }

    public String getPathSeperator() {
        return pathSeperator;
    }

    public FindMultipleFiles(String directory) {
        if (System.getProperty("os.name").equals("Linux"))
            pathSeperator = "/";
        this.directoryName = directory;
    }

    public FindMultipleFiles(String directory, List<String> exts) {
        this(directory);
        this.extList = exts;
    }

    public FindMultipleFiles(String directory, int MaxDepth) {
        this(directory);
        this.MaxDepth = MaxDepth;
    }

    public FindMultipleFiles(String directory, List<String> exts, int MaxDepth) {
        // this.directoryName = directory;
        // this.extList = exts;
        this(directory, exts);
        this.MaxDepth = MaxDepth;
    }

    @Override
    public List<String> getExtList() {
        return extList;
    }

    @Override
    public List<String> getPathsList() {
        return pathsList;
    }

    @Override
    public String getDirectoryName() {
        return directoryName;
    }

    @Override
    public List<String> getNamesList() {
        return NamesList;
    }

    @Override
    public int getMaxDepth() {
        return this.MaxDepth;
    }

    @Override
    public void setMaxDepth(int MaxDepth) {
        System.gc();
        this.MaxDepth = MaxDepth;
    }

    @Override
    public void setExtList(List<String> extList) {
        System.gc();
        this.extList = extList;
    }

    @Override
    public void setDirectoryName(String directoryName) {
        this.directoryName = directoryName;
    }

    @Override
    public List<String> FindFiles() throws IOException {
        pathsList = new ArrayList<>();
        try (Stream<Path> paths = Files.walk(Path.of(this.directoryName), this.MaxDepth)) {
            List<String> pathlist = paths
                    .map(path -> Files.isDirectory(path) ? path.toString() + '/' : path.toString())
                    .collect(Collectors.toList());

            for (String path : pathlist) {
                if (this.extList.size() == 0 || this.pathsList.contains("*"))
                    this.pathsList.add(path);
                else {
                    if (path.contains(".") && this.extList.contains(path.substring(path.length() - 3))) {
                        this.pathsList.add(path);
                    }
                }
            }
        }
        return pathsList;
    }

    @Override
    public List<String> GetNames() throws IOException {
        NamesList = new ArrayList<>();
        if (pathsList.size() == 0 || pathsList == null)
            this.pathsList = FindFiles();
        for (String path : pathsList) {
            String final_name = Utils.GetName(path, this.pathSeperator);
            NamesList.add(final_name);
        }

        return NamesList;
    }

    @Override
    public List<String> GetNames(List<String> pathsList) throws IOException {
        this.pathsList = pathsList;
        return GetNames();
    }

    @Override
    public int PathsSize() {
        return this.pathsList.size();
    }

    @Override
    public int NamesSize() {
        return this.NamesList.size();
    }
}