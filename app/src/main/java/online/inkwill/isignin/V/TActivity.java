package online.inkwill.isignin.V;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import online.inkwill.isignin.R;

public class TActivity extends AppCompatActivity {
    private  Bundle info;
    private TextView infoTx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t);

        info = getIntent().getExtras();
        infoTx = (TextView) findViewById(R.id.infoTx);

        initUI();
    }

    private void initUI(){
        infoTx.setText(info.getString("name")+info.getString("username")+info.getString("status")+info.getString("sex"));
    }
}
