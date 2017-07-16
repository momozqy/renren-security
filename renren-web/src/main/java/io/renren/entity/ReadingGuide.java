package io.renren.entity;

/**
 * Class Descripton goes here.
 * 
 * @version [V2013_001, 2013-12-6]
 * @author [xufei]
 */
public class ReadingGuide {
    String age;
    String name;
    String nameCn;
    String author;
    String pic;
    String mainContent;
    String beforeReading;
    String reading;
    String afterReading;
    String keyWords;
    /**
     * @Fields referTranslate : 参考译文
     */
    private String referTranslate;

    /**
     * @Fields cultureExpand : 文化拓展
     */
    private String cultureExpand;

    /**
     * @Fields engageLife : 融入生活
     */
    private String engageLife;

    public ReadingGuide(String age, String name, String nameCn, String author,
            String pic, String mainContent, String beforeReading,
            String reading, String afterReading, String keyWords,
            String referTranslate, String cultureExpand, String engageLife) {
        super();
        this.age = age;
        this.nameCn = nameCn;
        this.name = name;
        this.author = author;
        this.pic = pic;
        this.mainContent = mainContent;
        this.beforeReading = beforeReading;
        this.reading = reading;
        this.afterReading = afterReading;
        this.keyWords = keyWords;
        this.referTranslate = referTranslate;
        this.cultureExpand = cultureExpand;
        this.engageLife = engageLife;
    }

    /**
     * @return the age
     */
    public String getAge() {
        return this.age;
    }

    /**
     * @param age
     *        the age to set
     */
    public void setAge(String age) {
        this.age = age;
    }

    /**
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @param name
     *        the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return this.author;
    }

    /**
     * @param author
     *        the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return the pic
     */
    public String getPic() {
        return this.pic;
    }

    /**
     * @param pic
     *        the pic to set
     */
    public void setPic(String pic) {
        this.pic = pic;
    }

    /**
     * @return the mainContent
     */
    public String getMainContent() {
        return this.mainContent;
    }

    /**
     * @param mainContent
     *        the mainContent to set
     */
    public void setMainContent(String mainContent) {
        this.mainContent = mainContent;
    }

    /**
     * @return the beforeReading
     */
    public String getBeforeReading() {
        return this.beforeReading;
    }

    /**
     * @param beforeReading
     *        the beforeReading to set
     */
    public void setBeforeReading(String beforeReading) {
        this.beforeReading = beforeReading;
    }

    /**
     * @return the reading
     */
    public String getReading() {
        return this.reading;
    }

    /**
     * @param reading
     *        the reading to set
     */
    public void setReading(String reading) {
        this.reading = reading;
    }

    /**
     * @return the afterReading
     */
    public String getAfterReading() {
        return this.afterReading;
    }

    /**
     * @param afterReading
     *        the afterReading to set
     */
    public void setAfterReading(String afterReading) {
        this.afterReading = afterReading;
    }

    /**
     * @return the keyWords
     */
    public String getKeyWords() {
        return this.keyWords;
    }

    /**
     * @param keyWords
     *        the keyWords to set
     */
    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    public String getReferTranslate() {
        return this.referTranslate;
    }

    public void setReferTranslate(String referTranslate) {
        this.referTranslate = referTranslate;
    }

    public String getCultureExpand() {
        return this.cultureExpand;
    }

    public void setCultureExpand(String cultureExpand) {
        this.cultureExpand = cultureExpand;
    }

    public String getEngageLife() {
        return this.engageLife;
    }

    public void setEngageLife(String engageLife) {
        this.engageLife = engageLife;
    }

}
