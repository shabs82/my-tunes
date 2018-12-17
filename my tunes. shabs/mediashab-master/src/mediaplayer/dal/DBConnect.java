package mediaplayer.dal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author a
 */
public class DBConnect {
    
    public List<String> getDatabaseInfo() throws IOException {
        List<String> info = new ArrayList();
        String source = "src/mediaplayer/dal/loginInfo.txt";
        //String source = "loginInfo.txt";
        File file = new File(source);

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) 
        {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty()) {
                    try {
                        info.add(line);
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                }
            }
        }
        return info;
    }
    
    //delet this. it's for testing purposes only
    public void getItemsFromList() throws IOException {
        List<String> info = getDatabaseInfo();
        for (String string : info) {
                System.out.println(string);
            }
    }
            
}
