package servises;

import forms.LoginForm;
import forms.SignUpForm;

public interface UsersService {
    void signUp(SignUpForm signUpForm);

    void signIn(LoginForm loginForm);
}
