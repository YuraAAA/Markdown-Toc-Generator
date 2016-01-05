package com.aizenberg;

import com.aizenberg.model.ModifyModel;
import com.aizenberg.utils.Utils;

import java.io.*;
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

    public static final String TOC_HEADER = "**Table of Contents**  *generated with [MarkdownTocGenerator](https://github.com/YuraAAA/Markdown-Toc-Generator/)";

    private static DecimalFormat df2 = new DecimalFormat(".##");


    private Configuration configuration;
    private List<ModifyModel> rootModels = new ArrayList<ModifyModel>();


    public Modifier(Configuration configuration) {
        this.configuration = configuration;
    }

    public void start() throws IOException {
        FileInputStream fileInputStream = null;
        BufferedReader br = null;
        int patternLineNumber = -1;
        try {
            int currentLine = 0;
            String source = configuration.getSource();
            int linesCount = Utils.getFileLines(source, -1);

            File inputFile = new File(source);
            fileInputStream = new FileInputStream(inputFile);

            br = new BufferedReader(new InputStreamReader(fileInputStream));

            List<String> fileContent = new ArrayList<String>();

            String line;
            String previousLine = null;


            while ((line = br.readLine()) != null) {
                ++currentLine;
                boolean skipLine = false;
                if (line.startsWith(DEFAULT_HEADER)) {
                    String trim = line.trim();

                    int count = getCount(trim);
                    printProgress(currentLine, linesCount);
                    if (count < 1 || count > configuration.getDeepLevel()) {
                        previousLine = line;
                        continue;
                    }
                    String headerName = line.substring(count);
                    rootModels.add(new ModifyModel(count, headerName, Utils.normalize(headerName)));
                } else if (line.startsWith(ALT_1_HEADER) && !Utils.isEmpty(previousLine) && !configuration.isSkipAltH1()) {
                    if (line.replaceAll(ALT_1_HEADER, "").isEmpty()) {
                        rootModels.add(new ModifyModel(1, previousLine, Utils.normalize(previousLine)));
                    }
                } else if (line.startsWith(ALT_2_HEADER) && !Utils.isEmpty(previousLine) && !configuration.isSkipAltH2()) {
                    if (line.replaceAll(ALT_2_HEADER, "").isEmpty()) {
                        rootModels.add(new ModifyModel(2, previousLine, Utils.normalize(previousLine)));
                    }
                } else if (line.trim().equals(configuration.getReplaceAt())) {
                    patternLineNumber = currentLine;
                    skipLine = true;
                }
                if (!skipLine) fileContent.add(line);
                previousLine = line;
            }

            System.out.println("\n\nStructure: ");
            for (ModifyModel modifyModel : rootModels) {
                System.out.println(modifyModel.create());
            }

            saveToFile(fileContent, patternLineNumber, configuration.getDest());

        } finally {
            Utils.closeStream(fileInputStream, br);
        }


    }

    private void saveToFile(List<String> fileContent, int patternLineNumber, String outputPath) throws IOException {
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
    }

    private void printProgress(int currentLine, int linesCount) {
        if (linesCount < 1) return;
        float progress = (currentLine * 1f / linesCount * 1f) * 100f;
        System.out.print(String.format("\rProgress %s %%", df2.format(progress)));
    }

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
