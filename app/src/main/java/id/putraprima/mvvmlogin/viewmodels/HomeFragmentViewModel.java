package id.putraprima.mvvmlogin.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import id.putraprima.mvvmlogin.models.User;

public class HomeFragmentViewModel extends ViewModel {
    private MutableLiveData<User> homeFragmentMutableLiveData = new MutableLiveData<>();
    private User user;

    public HomeFragmentViewModel(User user){
        this.user = user;
        this.homeFragmentMutableLiveData.setValue(user);
    }

    public void buttonClick(){
        user.getEmail();
        user.getPassword();
        homeFragmentMutableLiveData.setValue(user);
    }
    public LiveData<User> homeLoginLiveData(){
        return homeFragmentMutableLiveData;
    }
}
