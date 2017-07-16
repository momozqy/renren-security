package io.renren.entity;

/**
 * Class Descripton goes here.
 * 
 * @version [V2013_001, 2013-11-8]
 * @author [xufei]
 */
public class LessonJson {
    String[] picture;
    String[] audio;
    ReadingGuide readingGuide;

    /**
     * @return the picture
     */
    public String[] getPicture() {
        return this.picture;
    }

    /**
     * @param picture
     *        the picture to set
     */
    public void setPicture(String[] picture) {
        this.picture = picture;
    }

    /**
     * @return the audio
     */
    public String[] getAudio() {
        return this.audio;
    }

    /**
     * @param audio
     *        the audio to set
     */
    public void setAudio(String[] audio) {
        this.audio = audio;
    }

    /**
     * @return the readingGuide
     */
    public ReadingGuide getReadingGuide() {
        return this.readingGuide;
    }

    /**
     * @param readingGuide
     *        the readingGuide to set
     */
    public void setReadingGuide(ReadingGuide readingGuide) {
        this.readingGuide = readingGuide;
    }

    /**
     * @param age
     *        年龄
     * @param name
     *        课程名称
     * @param classNameCn
     *        课程名称 中文
     * @param author
     *        作者
     * @param pic
     *        封面
     * @param mainContent
     *        简介
     * @param beforeReading
     * @param reading
     * @param afterReading
     * @param keyWords
     * @param referTranslate
     * @param cultureExpand
     * @param engageLife
     */
    public void genReadingGuide(String age, String name, String classNameCn,
            String author, String pic, String mainContent,
            String beforeReading, String reading, String afterReading,
            String keyWords, String referTranslate, String cultureExpand,
            String engageLife) {
        this.setReadingGuide(new ReadingGuide(age, name, classNameCn, author,
            pic, mainContent, beforeReading, reading, afterReading, keyWords,
            referTranslate, cultureExpand, engageLife));
    }
}
