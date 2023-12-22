package com.simpleform.service;


import com.simpleform.model.LibraryCard;
import com.simpleform.model.Users;
import com.simpleform.repository.UsersRepository;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    private final UsersRepository usersRepository;
    private final LibraryCardService libraryCardService;

    public UsersService(UsersRepository usersRepository, LibraryCardService libraryCardService) {
        this.usersRepository = usersRepository;
        this.libraryCardService = libraryCardService;
    }

    public Users registerUser(String login, String password, String email) {
        if (login == null || password == null) {
            return null;
        } else {
            if (usersRepository.findFirstByLogin(login).isPresent()) {
                System.out.println("Duplicate login");
                return null;
            }

            Users users = new Users();
            users.setLogin(login);
            users.setPassword(password);
            users.setEmail(email);

            // Générer la carte de bibliothèque
            String cardNumber = generateCardNumber();
            LibraryCard libraryCard = libraryCardService.createLibraryCard(cardNumber);

            // Attribuer la carte de bibliothèque à l'utilisateur
            users.setLibraryCard(libraryCard);


            return usersRepository.save(users);
        }
    }

    public Users authenticate(String login, String password) {
        return usersRepository.findByLoginAndPassword(login, password).orElse(null);
    }

    private String generateCardNumber() {
        // Logique pour la génération du numéro de carte de bibliothèque
        return "1234567890";
    }
}







