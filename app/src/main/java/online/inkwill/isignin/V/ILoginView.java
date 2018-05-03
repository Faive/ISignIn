package online.inkwill.isignin.V;

import android.os.Bundle;

/**
 * Created by Y on 2018/4/25 0025.
 */

public interface ILoginView {

    void showProgress(boolean enable);

    void showLoginView(boolean result, Bundle info);
}