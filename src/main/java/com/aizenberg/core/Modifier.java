package com.aizenberg.core;

import com.aizenberg.model.ModifyModel;
import com.aizenberg.model.RequestModel;
import com.aizenberg.utils.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yuriy Aizenberg
 */
public class Modifier {


    public static final String DEFAULT_HEADER = "#";
    public static final char DEFAULT_HEADER_CHAR = '#';
    public static final String ALT_1_HEADER = "=";
    public static final String ALT_2_HEADER = "-";

    private static DecimalFormat df2 = new DecimalFormat(".##");


    private List<ModifyModel> rootModels = new ArrayList<>();


    public List<ModifyModel> start(RequestModel requestModel) throws IOException {
        BufferedReader br = null;
        InputStream inputStream = null;
        InputStreamReader in = null;
        try {
            inputStream = requestModel.getFile().getInputStream();

            in = new InputStreamReader(inputStream);
            br = new BufferedReader(in);

            String line;
            String previousLine = null;


            while ((line = br.readLine()) != null) {
                if (line.startsWith(DEFAULT_HEADER)) {
                    String trim = line.trim();

                    int count = getCount(trim);
                    if (count < 1 || count > requestModel.getDepth()) {
                        previousLine = line;
                        continue;
                    }
                    String headerName = line.substring(count);
                    rootModels.add(new ModifyModel(count, headerName, Utils.normalize(headerName)));
                } else if (line.startsWith(ALT_1_HEADER) && !Utils.isEmpty(previousLine) && !requestModel.getH1()) {
                    if (line.replaceAll(ALT_1_HEADER, "").isEmpty()) {
                        rootModels.add(new ModifyModel(1, previousLine, Utils.normalize(previousLine)));
                    }
                } else if (line.startsWith(ALT_2_HEADER) && !Utils.isEmpty(previousLine) && !requestModel.getH2()) {
                    if (line.replaceAll(ALT_2_HEADER, "").isEmpty()) {
                        rootModels.add(new ModifyModel(2, previousLine, Utils.normalize(previousLine)));
                    }
                }
                previousLine = line;
            }


        } finally {
            Utils.closeStream(br, in, inputStream);
        }

        return rootModels;

    }

  /*  private void saveToFile(List<String> fileContent, int patternLineNumber, String outputPath) throws IOException {
        if (patternLineNumber == -1) {
            System.out.println("Pattern for replace not found!");
            return;
        }
        File file = new File(outputPath);
        FileWriter out = null;
        PrintWriter writer = null;
        try {
            out = new FileWriter(file);
            writer = new PrintWriter(out);
            fileContent.add(patternLineNumber - 1, TOC_HEADER);
            for (ModifyModel modifyModel : rootModels) {
                fileContent.add(patternLineNumber, modifyModel.create());
                patternLineNumber++;
            }
            for (String line : fileContent) {
                writer.append(line).append("\n");
            }
            System.out.println("Done");
        } finally {
            Utils.closeStream(out, writer);
        }
    }*/


    private int getCount(String string) {
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == DEFAULT_HEADER_CHAR) {
                ++count;
            } else {
                break;
            }
        }
        return count;
    }

}
