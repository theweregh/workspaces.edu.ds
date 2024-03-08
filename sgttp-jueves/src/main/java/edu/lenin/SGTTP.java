package edu.lenin;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.lenin.controller.SGTTPController;
import edu.lenin.model.SGTTPModel;
import edu.lenin.view.SGTTPView;

public class SGTTP {
    public static void main(String[] args) {
        Properties config = new Properties();
        try (FileInputStream fin = new FileInputStream(new File("/home/lestharkin/Projects/Lectures/Datastructures/Java/2025/issues/sgttp-1.0.20240221/server/config.properties"))) {
            config.load(fin);
            SGTTPModel model = new SGTTPModel(
                    (String) config.get("IP"),
                    (String) config.get("PORT"),
                    (String) config.get("SERVICE_NAME"));
            SGTTPController controller = new SGTTPController(model, new SGTTPView());
            controller.start();
        } catch (Exception e) {
            Logger.getLogger("AuthServer").log(Level.WARNING, e.getMessage(), e);
        }
    }
}
