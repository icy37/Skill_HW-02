package utils;

import model.XMLModels;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JsonWriter {

    private static final Logger logger = Logger.getLogger(JsonWriter.class.getName());

    private JsonWriter() {
    }

    public static void writeJsonReq(XMLModels xmlModels) {

        logger.log(Level.INFO, "JSON writing started");

        try {
            Files.createDirectory(Paths.get("jsonReqs"));
            logger.log(Level.INFO, "Directory created successfully");
        } catch (IOException ioEx) {
            logger.log(Level.FINE, "Directory already created", ioEx);
        }

        writeStudents(xmlModels);
        writeUniversities(xmlModels);
        writeStatisticsList(xmlModels);

        logger.log(Level.INFO, "JSON writing finished successfully");
    }

    private static void writeStudents(XMLModels xmlModels) {
        String studentsJson = JsonUtil.writeListToJson(xmlModels.getStudentList());
        try {
            FileOutputStream outputStream =
                    new FileOutputStream("jsonReqs/students" + xmlModels.getProcessDate().getTime() + ".json");
            outputStream.write(studentsJson.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Students JSON writing failed", e);
        }
    }

    private static void writeUniversities(XMLModels xmlModels) {
        String universitiesJson = JsonUtil.writeListToJson(xmlModels.getUniversityList());
        try {
            FileOutputStream outputStream =
                    new FileOutputStream("jsonReqs/universities" + xmlModels.getProcessDate().getTime() + ".json");
            outputStream.write(universitiesJson.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Universities JSON writing failed", e);
        }
    }

    private static void writeStatisticsList(XMLModels xmlModels) {
        String studentsJson = JsonUtil.writeListToJson(xmlModels.getStatisticsList());
        try {
            FileOutputStream outputStream =
                    new FileOutputStream("jsonReqs/statistics" + xmlModels.getProcessDate().getTime() + ".json");
            outputStream.write(studentsJson.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Statistics JSON writing failed", e);
        }
    }
}
