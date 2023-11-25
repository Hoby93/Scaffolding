package models;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

// import util.StringUtil;

public class FileProcess {
    String packageName;
    String className;
    String path = new File(".").getAbsolutePath();

    public FileProcess(String packageName, String className) {
        this.packageName = packageName;
        this.className = className;
    }

    public void generate(int language) {
        String templatePath = path + "/../templates/java.template";
        System.out.println("PATH: " + path);
        // String classPath = "../" + path + "/templates/java.template";
        try (Scanner scanner = new Scanner(new File(templatePath));
            PrintWriter writer = new PrintWriter(new File(path + "/../res/" + className + ".java"))) {

            StringBuilder newContent = new StringBuilder();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                line = line.replace("?package?", this.packageName)
                           .replace("?import?", this.getNeededImport())
                           .replace("?classname?", className)
                           .replace("?attributs?", this.getAttributes())
                           .replace("?getterssetters?", this.generateGetterAndSetter());

                newContent.append(line).append("\n");
            }

            writer.write(newContent.toString());
            System.out.println("Le fichier a ete traite avec succes.");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String getNeededImport() {
        String imports = "import java.util.*;";
        return imports;
    }

    public String getAttributes() {
        String attributes = "private int age;\nprivate String nom;";
        return attributes;
    }

    public String generateGetterAndSetter() {
        String gettersSetters = "public int getAge() {\n    return age;\n}\n\npublic void setAge(int age) {\n    this.age = age;\n}\n\npublic String getNom() {\n    return nom;\n}\n\npublic void setNom(String nom) {\n    this.nom = nom;\n}";
        return gettersSetters;
    }
}
