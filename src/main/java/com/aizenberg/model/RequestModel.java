package com.aizenberg.model;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Yuriy Aizenberg
 */
public class RequestModel {

    private MultipartFile file;
    private Boolean h1;
    private Boolean h2;
    private int depth;

    public void init() {
        if (h1 == null) h1 = false;
        if (h2 == null) h2 = false;
    }



    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public Boolean getH1() {
        return h1;
    }

    public void setH1(Boolean h1) {
        this.h1 = h1;
    }

    public Boolean getH2() {
        return h2;
    }

    public void setH2(Boolean h2) {
        this.h2 = h2;
    }
}
