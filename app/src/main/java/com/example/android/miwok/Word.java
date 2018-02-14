package com.example.android.miwok;

/**
 * a new Word object to hold default and miwok translation
 */

public class Word {
    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mMiwokImageId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     +     * Create a new Word object.
     +     *
     +     * @param defaultTranslation is the word in a language that the user is already familiar with
     +     *                           (such as English)
     +     * @param miwokTranslation is the word in the Miwok language
     +     *
     +     */
    public Word(String defaultTranslation, String miwokTranslation) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
    }

    /**
     +     * Create a new Word object.
     +     *
     +     * @param defaultTranslation is the word in a language that the user is already familiar with
     +     *                           (such as English)
     +     * @param miwokTranslation is the word in the Miwok language
     +     * @param miwokImageId is the drawable resource ID for the image associated with the word
     +     *
     +     */
    public Word(String defaultTranslation, String miwokTranslation, int miwokImageId) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mMiwokImageId = miwokImageId;
    }

//  get the default value of the word
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }
//get the Miwok translation of the word
    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }
    //get the Miwok image resource id
    public int getmImageResourceId() {
        return mMiwokImageId;
    }

    /* return wether this work has an image or not
     *
     */
    public boolean hasImage(){
        return mMiwokImageId != NO_IMAGE_PROVIDED;
    }
}
