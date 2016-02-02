package demo.magicsw.com.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;

public class FirstActivity extends AppCompatActivity {
    private final FirstActivity THIS_CLASS = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        Parse.enableLocalDatastore(this);
        Parse.initialize(this);

        final TextView username = (TextView) findViewById(R.id.username);
        final TextView password = (TextView) findViewById(R.id.password);
        Button loginButton = (Button) findViewById(R.id.Login);
        loginButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                username.setCursorVisible(true);
                username.setFocusableInTouchMode(true);
                username.requestFocus();
                ParseUser.logInInBackground(username.getText().toString(), password.getText().toString(), new LogInCallback() {
                    public void done(ParseUser user, ParseException e) {
                        if (user != null) {

                                Intent intent=new Intent(FirstActivity.this,SecondActivity.class);
                                //intent.putExtra("Details", (Serializable) ParseUser.getCurrentUser());
                            Toast.makeText(getApplicationContext(), "Welcome to Second Activity!", Toast.LENGTH_LONG).show();
                                startActivity(intent);


                        } else {
                            Toast.makeText(getApplicationContext(), "Login failed, Try again!", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
    }
}