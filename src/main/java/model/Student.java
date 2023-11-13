package model;

import com.google.gson.annotations.SerializedName;

public class Student {
    @SerializedName("studentName")
    private String fullName;

    @SerializedName("universityId")
    private String universityId;

    @SerializedName("course")
    private int currentCourseNumber;

    @SerializedName("avgScore")
    private float avgExamScore;

    @SerializedName("gender")
    private String gender;

    @SerializedName("studentAddress")
    private String address;

    @SerializedName("admissionDate")
    private String admissionDate;

    @SerializedName("studentPhoneNumber")
    private String phoneNumber;

     public Student(String universityId, String fullName, int currentCourseNumber, float avgExamScore, String gender, String address, String admissionDate, String phoneNumber) {
        this.universityId = universityId;
        this.fullName = fullName;
        this.currentCourseNumber = currentCourseNumber;
        this.avgExamScore = avgExamScore;
        this.gender = gender;
        this.address = address;
        this.admissionDate = admissionDate;
        this.phoneNumber = phoneNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public Student setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getUniversityId() {
        return universityId;
    }

    public Student setUniversityId(String universityId) {
        this.universityId = universityId;
        return this;
    }

    public int getCurrentCourseNumber() {
        return currentCourseNumber;
    }

    public Student setCurrentCourseNumber(int currentCourseNumber) {
        this.currentCourseNumber = currentCourseNumber;
        return this;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    public Student setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public Student setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Student setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getAdmissionDate() {
        return admissionDate;
    }

    public Student setAdmissionDate(String admissionDate) {
        this.admissionDate = admissionDate;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Student setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    @Override
    public String toString() {
        return String.format("universityId = %s, fullName = %s, currentCourseNumber = %s, avgExamScore = %s, " +
                        "gender = %s, address = %s, admissionDate = %s, phoneNumber = %s",
                this.universityId,
                this.fullName,
                this.currentCourseNumber,
                this.avgExamScore,
                this.gender,
                this.address,
                this.admissionDate,
                this.phoneNumber);
    }
}
