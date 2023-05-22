package com.example.hom_thu_dien_tu.model;

public class EmailContainer {
    private String language;
    private Integer pages;
    private boolean spamFilter;
    private String signature;

    public EmailContainer() {
    }

    public EmailContainer(String language, Integer pages, boolean spamFilter, String signature) {
        this.language = language;
        this.pages = pages;
        this.spamFilter = spamFilter;
        this.signature = signature;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public boolean isSpamFilter() {
        return spamFilter;
    }

    public void setSpamFilter(boolean spamFilter) {
        this.spamFilter = spamFilter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
