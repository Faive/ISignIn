package online.inkwill.isignin.M;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import online.inkwill.isignin.DB.DBCon;
import online.inkwill.isignin.P.ILoginPresenter;


/**
 * Created by Y on 2018/4/25 0025.
 */

public class LoginModel implements ILoginModel{

    private ILoginPresenter presenter;

    private Handler mHandler ;

    public LoginModel(ILoginPresenter presenter) {
        this.presenter = presenter;

    }

    @Override
    public void login(final String name , final String password){

        mHandler = new Handler(){
          public void handleMessage(Message msg){
              switch (msg.what){
                  case 0:
                      presenter.loginResult(true,msg.getData());
                      System.out.println(msg.getData().toString());
                      break;
                  case 1:
                      presenter.loginResult(false,msg.getData());
                      break;
              }
          }
        };


        ExecutorService mThreadPool = Executors.newCachedThreadPool();
        mThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    DBCon LoginDB = new DBCon();
                    Boolean LoginState = false;
                    Bundle InfoBD = new Bundle();
                    String loginSql = "SELECT *FROM user WHERE username = '"+name+"' and password = '"+password+"'";
                    ResultSet rs = LoginDB.executeQuery(loginSql);

                        while (rs.next()){
                            LoginState = true;
                            InfoBD.putString("name",rs.getString("name"));
                            InfoBD.putString("sex",rs.getString("sex"));
                            InfoBD.putString("username",rs.getString("username"));
                            InfoBD.putString("status",rs.getString("status"));
                            //System.out.println(InfoBD.toString());
                        }

                    Message msg = new Message();

                    if (LoginState){
                        msg.what = 0;
                        msg.setData(InfoBD);
                    }
                    else
                        msg.what = 1;
                    mHandler.sendMessage(msg);
                    Log.d("LoginModel", "run: ");
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        });
    }

}
