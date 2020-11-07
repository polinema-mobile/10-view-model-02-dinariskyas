package id.putraprima.mvvmlogin.viewmodels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import id.putraprima.mvvmlogin.models.User;

public class LoginFragmentViewModel extends ViewModel {
    private MutableLiveData<User> loginFragmentMutableLiveData = new MutableLiveData<>();
    private MutableLiveData<Boolean> isLoggedIn = new MutableLiveData<>();
    private MutableLiveData<String> errorMessageEmail = new MutableLiveData<>();
    private MutableLiveData<String> errorMessagePassword = new MutableLiveData<>();
    private User user;
    private String email = "dinarisky04@gmail.com";
    private String password = "dinarisky";

    public LoginFragmentViewModel(User user){
        this.user = user;
        this.loginFragmentMutableLiveData.setValue(user);

    }

    public void isLogin() {
        Log.d("Email", user.email);
        Log.d("Password", user.password);
        isLoggedIn.setValue(false);

        if (user.email.equals(email) && user.password.equals(password)) {
            loginFragmentMutableLiveData.setValue(user);
            isLoggedIn.setValue(true);
            return;
        } else if (user.isEmailValid()) {
            errorMessageEmail.setValue("Isikan email yang sesuai"); // set pesan
            isLoggedIn.setValue(false);
            return;
        } else if (user.email.isEmpty() && user.password.isEmpty()) {
            errorMessageEmail.setValue("Isikan email yang sesuai"); // set pesan
            errorMessagePassword.setValue("Isikan password yang sesuai"); // set pesan
            isLoggedIn.setValue(false);
            return;
        } else if (user.email.equals(email) && user.password.isEmpty() || user.password == null || !user.password.equals(password)){
            errorMessagePassword.setValue("Isikan password yang sesuai");
            isLoggedIn.setValue(false);
            return;
        } else if (user.email.isEmpty() || user.email == null && user.password.equals(password)) {
            errorMessagePassword.setValue("Isikan alamat yang sesuai");
            isLoggedIn.setValue(false);
            return;
        } else if (!user.email.equals(email) || !user.password.equals(password)) {
            errorMessageEmail.setValue("Isikan alamat email yang sesuai");
            errorMessagePassword.setValue("Isikan password yang sesuai");
            isLoggedIn.setValue(false);
            return;
        }
    }

    public LiveData<String> getErrorEmail(){
        return this.errorMessageEmail;
    }

    public LiveData<String> getErrorPassword(){
        return this.errorMessagePassword;
    }

    public LiveData<Boolean> loggedInLiveData() {
        return this.isLoggedIn;
    }

    public LiveData<User> getLoginLiveData(){
        return this.loginFragmentMutableLiveData;
    }
}
