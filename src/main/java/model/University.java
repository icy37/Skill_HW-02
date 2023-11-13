package model;

import com.google.gson.annotations.SerializedName;
import enums.StudyProfile;

public class University {
    @SerializedName("universityId")
    private String id;

    @SerializedName("universityName")
    private String fullName;

    @SerializedName("universityShortName")
    private String shortName;

    @SerializedName("universityFoundation")
    private int yearOfFoundation;

    @SerializedName("universityProfile")
    private StudyProfile mainProfile;

    @SerializedName("universityAddress")
    private String address;

    @SerializedName("universityPhoneNumber")
    private String phoneNumber;

    @SerializedName("universityEmail")
    private String email;

    @SerializedName("universityWebsite")
    private String website;


    public University(String id, String fullName, String shortName, int yearOfFoundation, StudyProfile mainProfile, String address, String phoneNumber, String email, String website) {
        this.id = id;
        this.fullName = fullName;
        this.shortName = shortName;
        this.yearOfFoundation = yearOfFoundation;
        this.mainProfile = mainProfile;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.website = website;
    }


    public String getId() {
        return id;
    }

    public University setId(String id) {
        this.id = id;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public University setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getShortName() {
        return shortName;
    }

    public University setShortName(String shortName) {
        this.shortName = shortName;
        return this;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public University setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
        return this;
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    public University setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public University setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public University setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public University setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getWebsite() {
        return website;
    }

    public University setWebsite(String website) {
        this.website = website;
        return this;
    }

    @Override
    public String toString() {
        return String.format("id = %s, fullName = %s, shortName = %s, yearOfFoundation = %s, mainProfile = %s," +
                        " address = %s, phoneNumber = %s, email = %s, website = %s",
                this.id,
                this.fullName,
                this.shortName,
                this.yearOfFoundation,
                this.mainProfile,
                this.address,
                this.phoneNumber,
                this.email,
                this.website);
    }
}
