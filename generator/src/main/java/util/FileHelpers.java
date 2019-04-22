package util;

import util.types.FileTypes;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class FileHelpers {

    public static List<File> getAllFilesInDirectory(Path directoryPath, FileTypes fileType) {


        try {
            return Files.walk(directoryPath)
                    .filter(s -> s.toString().endsWith(fileType.getEndsWith()))
                    .map(Path::toFile)
                    .sorted()
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

    public static List<File> getAllFilesInDirectory(File directoryPath, FileTypes fileType) {
        return getAllFilesInDirectory(directoryPath.toPath(),fileType);
    }

    public static List<File> getAllFilesInDirectory(String directoryPath, FileTypes fileType) {
        return getAllFilesInDirectory(new File(directoryPath),fileType);
    }

    public static void replaceInFile(File file, String s, String s1) {

        String fileData = readFile(file);
        if (fileData.contains(s)) {
            System.out.println(file.getName());
        }
        fileData = fileData.replace(s, s1);
        writeInFile(file,fileData);
    }

    public static void replaceInFileIfContains(File file, String s, String s1, String contain) {
        if (readFile(file).contains(contain)) replaceInFile(file, s, s1);
    }

    public static void appendInFirstLine(File file, String s) {

        String fileData = readFile(file);
        String splitData[] = fileData.split("\n");
        StringBuilder fileStringBuilder = new StringBuilder();
        for (int i = 0; i < splitData.length; i++) {
            if (i == 0) {
                fileStringBuilder.append(splitData[i] + " " + s);
            } else {
                fileStringBuilder.append(splitData[i]);
            }
            fileStringBuilder.append("\n");
        }
        writeInFile(file,fileStringBuilder.toString());
    }

    public static void appendInFirstLine(List<File> files, String s) {
        files.forEach(f -> appendInFirstLine(f,s));
    }

    public static void replaceInFiles(List<File> files, String s, String s1) {
        files.forEach(f -> replaceInFile(f,s,s1));
    }

    public static void replaceInFileIfContains(List<File> files, String s, String s1, String contain) {
        files.forEach(f -> replaceInFileIfContains(f,s,s1,contain));
    }


    public static String readFile(File file) {
        StringBuilder content = new StringBuilder();
        try {
            new BufferedReader(new FileReader(file)).lines().forEach(e -> {
                content.append(e);
                System.out.println(e);
                content.append("\n");
            });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    public static void writeInFile(File file, String content) {
        try {
            BufferedWriter bf = new BufferedWriter(new FileWriter(file));
            bf.write(content);
            bf.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
