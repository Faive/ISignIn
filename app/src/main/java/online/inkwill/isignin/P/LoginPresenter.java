package online.inkwill.isignin.P;

import android.os.Bundle;

import online.inkwill.isignin.M.ILoginModel;
import online.inkwill.isignin.M.LoginModel;
import online.inkwill.isignin.V.ILoginView;


/**
 * Created by Y on 2018/4/25 0025.
 */

public class LoginPresenter implements ILoginPresenter{

    private ILoginModel loginModel;

    private ILoginView loginView;

    public LoginPresenter(ILoginView loginView) {
        this.loginView = loginView;
        this.loginModel = new LoginModel(this);
    }

    @Override
    public void loginToServer(String userName, String password) {
        loginView.showProgress(true);
        loginModel.login(userName,password);
    }

    @Override
    public void loginResult(boolean result, Bundle info) {
        loginView.showProgress(false);

        loginView.showLoginView(result,info);


    }

}