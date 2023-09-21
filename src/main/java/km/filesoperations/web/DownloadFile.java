package km.filesoperations.web;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author kosta
 */
public class DownloadFile{
    public static void downloadFile(String path, String url) throws IOException
    {
        InputStream in = new URL(url).openStream();
        Files.copy(in, Paths.get(path));
    }
}