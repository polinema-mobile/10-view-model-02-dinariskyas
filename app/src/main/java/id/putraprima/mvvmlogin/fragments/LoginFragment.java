package id.putraprima.mvvmlogin.fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
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
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (loginFragmentViewModel.isLogin()){
                    Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_homeFragment);
                }else {
                    binding.editTextEmail.setError("Email tidak sesuai");
                    binding.editTextPassword.setError("Password tidak sesuai");
                }
            }
        });
        return binding.getRoot();
    }
}