
package fengras.com.fengran1502l0410;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import fengras.com.fengran1502l0410.view.Myprogress;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_clic;
    private Myprogress myprogress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //找控件
        btn_clic = (Button) findViewById(R.id.btn_clic);
        myprogress = (Myprogress) findViewById(R.id.my);
        myprogress.setprogress();
        btn_clic.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        //点击按钮 重新开启线程
        myprogress.resetprogress();

    }
}
