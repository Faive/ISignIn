package online.inkwill.isignin.V;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import online.inkwill.isignin.P.LoginPresenter;
import online.inkwill.isignin.R;

public class LoginActivity extends AppCompatActivity implements ILoginView{
    private Button mLogin;
    private Button mReg;
    private EditText mUsername;
    private EditText mPassword;

    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mLogin = (Button) findViewById(R.id.BtnLogin);
        mReg = (Button) findViewById(R.id.BtnReg);
        mUsername = (EditText) findViewById(R.id.UserEdt);
        mPassword = (EditText) findViewById(R.id.PasswordEdt);

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mReg.setOnClickListener(new onclick());
        mLogin.setOnClickListener(new onclick());

        loginPresenter = new LoginPresenter(this);
    }

    @Override
    public void showProgress(boolean enable) {

    }

    @Override
    public void showLoginView(boolean result, Bundle info) {
        if(result) {
            Toast.makeText(LoginActivity.this, info.getString("name") + " 登陆成功" + info.getString("status"), Toast.LENGTH_SHORT).show();




            if(info.getString("status").equals("t")){
                Intent toTActivity = new Intent(LoginActivity.this,TActivity.class);
                toTActivity.putExtras(info);
                startActivity(toTActivity);
            }
            else {
                Intent toSActivity = new Intent(LoginActivity.this,SActivity.class);
                toSActivity.putExtras(info);
                startActivity(toSActivity);
            }
        }
        else {
            Toast.makeText(LoginActivity.this, "账户名或密码错误", Toast.LENGTH_SHORT).show();
        }
    }

    private class onclick implements View.OnClickListener{
        public void onClick (View v){

            int id = v.getId();
            String userName = mUsername.getText().toString();
            String password = mPassword.getText().toString();

            switch (id){
                case R.id.BtnLogin:{
                    loginPresenter.loginToServer(userName, password);
                    break;

                }
                case R.id.BtnReg:{
                    //注册内容

                    break;
                }
            }
        }

    }


}
