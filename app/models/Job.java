package models;

import java.util.ArrayList;

public class Job {
    private int id;
    private String link;
    private String lang;
    private String title;
    private String caption;
    private ArrayList<String> duties;
    private ArrayList<String> skills;
    private ArrayList<String> benefits;
    private String note;
    private String education_id;
    private String salary_min;
    private String salary_max;
    private ArrayList<Integer> sectors;
    private boolean location_anywhere;
    private ArrayList<Integer> flags;
    private int contact_id;

    public Job() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public ArrayList<String> getDuties() {
        return duties;
    }

    public void setDuties(ArrayList<String> duties) {
        this.duties = duties;
    }

    public ArrayList<String> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<String> skills) {
        this.skills = skills;
    }

    public ArrayList<String> getBenefits() {
        return benefits;
    }

    public void setBenefits(ArrayList<String> benefits) {
        this.benefits = benefits;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getEducation_id() {
        return education_id;
    }

    public void setEducation_id(String education_id) {
        this.education_id = education_id;
    }

    public String getSalary_min() {
        return salary_min;
    }

    public void setSalary_min(String salary_min) {
        this.salary_min = salary_min;
    }

    public String getSalary_max() {
        return salary_max;
    }

    public void setSalary_max(String salary_max) {
        this.salary_max = salary_max;
    }

    public ArrayList<Integer> getSectors() {
        return sectors;
    }

    public void setSectors(ArrayList<Integer> sectors) {
        this.sectors = sectors;
    }

    public boolean isLocation_anywhere() {
        return location_anywhere;
    }

    public void setLocation_anywhere(boolean location_anywhere) {
        this.location_anywhere = location_anywhere;
    }

    public ArrayList<Integer> getFlags() {
        return flags;
    }

    public void setFlags(ArrayList<Integer> flags) {
        this.flags = flags;
    }

    public int getContact_id() {
        return contact_id;
    }

    public void setContact_id(int contact_id) {
        this.contact_id = contact_id;
    }
}
