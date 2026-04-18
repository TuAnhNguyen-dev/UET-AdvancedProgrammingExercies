public class UserService {
    public void test() {
        UserRepository userRepository = new UserRepository();
        UserEmailService emailService = new UserEmailService();
        UserView userView = new UserView();
        UserExportService exportService = new UserExportService();

        User user = userRepository.findById(1);
        emailService.sendWelcomeEmail(user);
        userView.renderUserProfile(user);
        String csvData = exportService.exportUsertoCsv(user);
        System.out.println(csvData);

        System.out.println("Refactored UserService with Single Responsibility Principle");
    }
}

class User {}

class UserRepository {
    public User findById(int id) {return null;}
}

class UserEmailService {
    public void sendWelcomeEmail(User user) {}
    public void sendPasswordResetEmail(User use) {}
}

class UserView {
    public void renderUserProfile(User user) {}
}

class UserExportService {
    public String exportUsertoCsv(User user) {return null;}
}