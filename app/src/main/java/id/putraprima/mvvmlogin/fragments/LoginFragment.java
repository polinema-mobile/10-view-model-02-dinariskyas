package id.putraprima.mvvmlogin.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.putraprima.mvvmlogin.R;
import id.putraprima.mvvmlogin.databinding.FragmentLoginBinding;
import id.putraprima.mvvmlogin.models.User;
import id.putraprima.mvvmlogin.viewmodels.LoginFragmentViewModel;
import id.putraprima.mvvmlogin.viewmodels.LoginFragmentViewModelFactory;


public class LoginFragment extends Fragment {
    private LoginFragmentViewModel loginFragmentViewModel;
    Bundle bundle = new Bundle();
    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentLoginBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false);
        LoginFragmentViewModelFactory loginFragmentViewModelFactory = new LoginFragmentViewModelFactory(new User("dinarisky04@gmail.com","dinarisky"));
        loginFragmentViewModel = new ViewModelProvider(this, loginFragmentViewModelFactory).get(LoginFragmentViewModel.class);
        binding.setViewModel(loginFragmentViewModel);
        binding.setLifecycleOwner(this);
        return binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loginFragmentViewModel.loggedInLiveData().observe(this.getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (loginFragmentViewModel.loggedInLiveData().getValue() == true){
                    bundle.putString("email", loginFragmentViewModel.getLoginLiveData().getValue().getEmail());
                    Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_homeFragment,bundle);
                }
            }
        });
    }
}