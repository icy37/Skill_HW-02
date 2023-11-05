public class Student {
    private String fullName;
    private String universityId;
    private int currentCourseNumber;
    private float avgExamScore;
    private String gender;
    private String address;
    private String admissionDate;
    private String phoneNumber;

     public Student(String fullName, String universityId, int currentCourseNumber, float avgExamScore, String gender, String address, String admissionDate, String phoneNumber) {
        this.fullName = fullName;
        this.universityId = universityId;
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
        return "Student{" +
                "fullName='" + fullName + '\'' +
                ", universityId='" + universityId + '\'' +
                ", currentCourseNumber=" + currentCourseNumber +
                ", avgExamScore=" + avgExamScore +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", admissionDate='" + admissionDate + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
