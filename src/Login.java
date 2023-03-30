public class Login {
    public static boolean checkException(String login, String password, String confirmPassword) {
        try {
            checkLogIn(login, password, confirmPassword);
            return true;
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    private static void checkLogIn(String login, String password, String confirmPassword)
            throws WrongLoginException, WrongPasswordException {
        if (!login.matches("\\w{1,20}")) {
            throw new WrongLoginException("Некорректный логин!");
        }
        if (!password.matches("\\w{1,19}")) {
            throw new WrongPasswordException("Некорректный пароль!");
        }
        if (!confirmPassword.matches("\\w{1,19}")) {
            throw new WrongPasswordException("Некорректный пароль!");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают!");
        }
    }
}
