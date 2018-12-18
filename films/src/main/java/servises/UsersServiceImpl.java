package servises;

import forms.LoginForm;
import forms.SignUpForm;
import models.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import repositories.UsersRepository;

import java.util.Optional;
import java.util.UUID;

public class UsersServiceImpl implements UsersService {
    private UsersRepository usersRepository;
    private PasswordEncoder encoder;

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
        this.encoder = new BCryptPasswordEncoder();
    }

    @Override
    public void signUp(SignUpForm signUpForm) {
        User user = User.builder()
                .name(signUpForm.getName())
                .hashPassword(encoder.encode(signUpForm.getPassword()))
                .session_id(signUpForm.getUuid())
                .build();
        usersRepository.save(user);
    }

    @Override
    public void signIn(LoginForm loginForm) {
        Optional<User> userOptional = usersRepository.findOneByName(loginForm.getName());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (!encoder.matches(loginForm.getPassword(), user.getHashPassword())) {
                throw new IllegalArgumentException("Wrong password or email");
            } else {
                usersRepository.updateSession(loginForm.getName(), loginForm.getUuid());
            }
        } else throw new IllegalArgumentException("Wrong password or email");
    }
}