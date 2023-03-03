/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Web;
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
    public static void DownloadFile(String path, String url) throws IOException
    {
        InputStream in = new URL(url).openStream();
        Files.copy(in, Paths.get(path));
    }
}
