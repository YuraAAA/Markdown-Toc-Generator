package com.aizenberg;

/**
 * Created by Yuriy Aizenberg
 */
public class Configuration {

    private String source;
    private String dest;
    private String replaceAt;
    private int deepLevel;
    private boolean skipAltH1;
    private boolean skipAltH2;

    public Configuration(String source, String dest, String replaceAt, int deepLevel, boolean skipAltH1, boolean skipAltH2) {
        this.source = source;
        this.dest = dest;
        this.replaceAt = replaceAt;
        this.deepLevel = deepLevel;
        this.skipAltH1 = skipAltH1;
        this.skipAltH2 = skipAltH2;
    }


    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public String getReplaceAt() {
        return replaceAt;
    }

    public void setReplaceAt(String replaceAt) {
        this.replaceAt = replaceAt;
    }

    public int getDeepLevel() {
        return deepLevel;
    }

    public void setDeepLevel(int deepLevel) {
        this.deepLevel = deepLevel;
    }

    public boolean isSkipAltH1() {
        return skipAltH1;
    }

    public void setSkipAltH1(boolean skipAltH1) {
        this.skipAltH1 = skipAltH1;
    }

    public boolean isSkipAltH2() {
        return skipAltH2;
    }

    public void setSkipAltH2(boolean skipAltH2) {
        this.skipAltH2 = skipAltH2;
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "source='" + source + '\'' +
                ", dest='" + dest + '\'' +
                ", replaceAt='" + replaceAt + '\'' +
                ", deepLevel=" + deepLevel +
                ", skipAltH1=" + skipAltH1 +
                ", skipAltH2=" + skipAltH2 +
                '}';
    }
}
