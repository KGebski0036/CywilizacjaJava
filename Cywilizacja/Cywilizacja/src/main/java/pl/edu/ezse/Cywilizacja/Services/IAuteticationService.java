package pl.edu.ezse.Cywilizacja.Services;

public interface IAuteticationService {
    void authenticate(String login, String password);
    void logout();
    void register(String login, String password);
}
