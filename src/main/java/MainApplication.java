public class MainApplication {
    public static void main(String[] args) {

        University university = new University(
                "1", "Университет Примера", "УП", 1990,
                StudyProfile.COMPUTER_SCIENCE, "Улица Примера, 123", "+1234567890",
                "info@example.com", "https://example.com"
        );


        Student student = new Student(
                "Иван Петров", "1", 3, 87.5f,
                "Мужской", "Улица Студента, 456", "2023-09-01", "+9876543210"
        );

        System.out.println(university);
        System.out.println(student);
    }
}
