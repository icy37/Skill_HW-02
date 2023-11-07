package enums;

public enum StudyProfile {
    UNKNOWN("Не найден"),
    MEDICINE("Медицина"),
    ENGINEERING("Инженерия"),
    COMPUTER_SCIENCE("Информатика"),
    PHYSICS("Физика"),
    LINGUISTICS("Лингвистика"),
    MATHEMATICS("Математика"),
    BUSINESS("Бизнес"),
    LITERATURE("Литература");

    private String profileName;

    private StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return profileName;
    }
}
