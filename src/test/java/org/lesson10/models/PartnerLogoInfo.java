package org.lesson10.models;

public class PartnerLogoInfo {
    private final boolean displayed;
    private String altText;
    private String src;

    public PartnerLogoInfo(boolean displayed, String altText) {
        this.displayed = displayed;
        this.altText = altText;
    }
    public PartnerLogoInfo(String src, boolean displayed) {
        this.displayed = displayed;
        this.src = src;
    }
    public boolean isDisplayed() { return displayed; }
    public String getAltText() { return altText; }
    public String getSrc() { return src; }
}