package com.pbsi2.crazymusicalinstruments;

public class MyInstruments {
    private int imageResId = HAS_IMAGE ;
    private int soundResId;
    private static final int HAS_IMAGE = -1;
    private String mPluckDescription;
    private String mPluckCountry;

    public MyInstruments(int image, int sound, String country, String description) {
        imageResId = image;
        soundResId = sound;
        mPluckDescription = country;
        mPluckCountry = description;
    }

    public int getImageId() {
        return imageResId;
    }

    public int getSoundId() {
        return soundResId;
    }

    public String getDescription() {
        return mPluckDescription;
    }

    public String getCountry() {
        return mPluckCountry;
    }


    public boolean hasImage() {
        return imageResId != HAS_IMAGE;
    }
}
