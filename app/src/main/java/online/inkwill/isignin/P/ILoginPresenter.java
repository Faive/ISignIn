package online.inkwill.isignin.P;

import android.os.Bundle;

/**
 * Created by Y on 2018/4/25 0025.
 */
public interface ILoginPresenter {

    void loginToServer(String userName,String password);

    void loginResult(boolean result, Bundle info);
}