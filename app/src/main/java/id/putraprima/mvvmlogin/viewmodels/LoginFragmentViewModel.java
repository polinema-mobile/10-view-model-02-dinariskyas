package id.putraprima.mvvmlogin.viewmodels;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import id.putraprima.mvvmlogin.models.User;

public class LoginFragmentViewModel {
    private MutableLiveData<User> loginFragmentMutableLiveData = new MutableLiveData<>();
    private User user;

    public LoginFragmentViewModel(User user){
        this.loginFragmentMutableLiveData.setValue(user);

    }

    public void Login() {
        Log.d("username", this.loginFragmentMutableLiveData.getValue().getEmail());
        Log.d("password", this.loginFragmentMutableLiveData.getValue().getPassword());
    }
}
