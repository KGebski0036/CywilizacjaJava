package pl.edu.ezse.Cywilizacja.Services;

public interface IAuteticationService {
    void authenticate(String login, String password);
    void logout();
    Boolean register(String login, String password);
}
