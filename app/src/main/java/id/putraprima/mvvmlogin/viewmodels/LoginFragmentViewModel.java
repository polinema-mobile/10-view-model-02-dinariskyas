package id.putraprima.mvvmlogin.viewmodels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import id.putraprima.mvvmlogin.models.User;

public class LoginFragmentViewModel extends ViewModel {
    private MutableLiveData<User> loginFragmentMutableLiveData = new MutableLiveData<>();
    private User user;
    public String email, password;

    public LoginFragmentViewModel(User user){
        this.user = user;
        this.loginFragmentMutableLiveData.setValue(user);

    }

    public boolean isLogin() {
        if(email.equals(user.getEmail()) && password.equals(user.getPassword())){
            return true;
        }else{
            return false;
        }
    }
    public LiveData<User> userLiveData(){
        return loginFragmentMutableLiveData;
    }
}
