package run;

import scaffolding.Scaffold;

public class Generate {
    public static void main(String[] args) {
        try {
            System.out.println("generating...");
            Scaffold.generate(args[0], args[1], args[2],args[3],args[4]);
            // Scaffold.generate(args[0], args[1], args[2],args[3],"csharp");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
