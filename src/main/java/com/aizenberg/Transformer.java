package com.aizenberg;

import com.aizenberg.utils.ParameterUtils;
import com.aizenberg.utils.Utils;

import java.io.File;
import java.io.IOException;

/**
 * Created by Yuriy Aizenberg
 */
public class Transformer {

    public static final int MAX_DEEP_LEVEL = 6;


    public static void main(String[] args) {
        String fileSource = System.getProperty("src");
        if (!Utils.checkSourceFile(fileSource)) {
            System.out.println("Source file doesn't exists or can't be read. Make sure -Dsrc= param set");
            return;
        }

        String fileTarget = System.getProperty("target");
        if (Utils.isEmpty(fileTarget)) {
            System.out.println("Destination file doesn't exists or can't be read. Make sure -Dtarget= param set");
            return;
        }

        File targetFile = new File(fileTarget);
        if (targetFile.exists() || targetFile.isDirectory()) {
            System.out.println("Target file already exists or it's directory");
            return;
        }

        String replacePattern = System.getProperty("replaceAt", "{toc.placeholder}");


        String deepLevelProperty = System.getProperty("deepLevel");
        Integer deepLevel = ParameterUtils.extractInteger(deepLevelProperty, 4);

        if (deepLevel == null) {
            System.out.println(String.format("Invalid deepLevel %s", deepLevelProperty != null ? deepLevelProperty : "null"));
            return;
        }


        if (deepLevel < 1 || deepLevel > MAX_DEEP_LEVEL) {
            throw new NumberFormatException("Can't use this deep level, must be between 1 and 10");
        }

        boolean skipAltH1 = ParameterUtils.extractBoolean(System.getProperty("skipAltH1", "false"), false);
        boolean skipAltH2 = ParameterUtils.extractBoolean(System.getProperty("skipAltH2", "false"), false);


        Configuration configuration = new Configuration(fileSource, fileTarget, replacePattern, deepLevel, skipAltH1, skipAltH2);

        System.out.println("Configuration successfully created.\n" + configuration.toString());

        try {
            new Modifier(configuration).start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
