package demo.magicsw.com.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        button = (Button) findViewById(R.id.Login);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        findViewById(R.id.Login).setOnClickListener(this);
    }


    private void loadActivity() {
        Log.v("Heya", "how are you");
        Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
        startActivity(intent);
    }


   @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Login:
                loadActivity();
                finish();
                break;
        }
    }
}