package Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.example.myapplication.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import Controller.DatabaseHandler;
import Model.Msg;
import Model.User;

public class LogIn extends AppCompatActivity  implements View.OnClickListener{

    private FloatingActionButton loginBtn;
    private EditText username,password;
    private DatabaseHandler db ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        intiViews();


    }
    private void intiViews()
    {
        loginBtn=findViewById(R.id.LoginBtn);
        loginBtn.setOnClickListener(this);
        username=findViewById(R.id.loginemail);
        password=findViewById(R.id.loginpass);
        db = new DatabaseHandler(this);
    }


    @Override
    public void onClick(View view) {

        if(username.getText().toString().equals("Admin") && password.getText().toString().equals("Admin"))
        {
            Toast.makeText(getApplicationContext(),"Hello Admin",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(LogIn.this,Admin.class));
        }
        else
        {
            boolean loged=false;
            List<User> users=db.ALL();
            for(User u:users)
            {

                if(username.getText().toString().equals(u.getUsername()))
                    if(password.getText().toString().equals(u.getPassword()))
                    {
                        Toast.makeText(getApplicationContext(),"hello "+ u.getFirstname()+" u logged IN",Toast.LENGTH_SHORT).show();
                        loged=true;

                        Intent i=new Intent(LogIn.this,Container.class);
                        i.putExtra("Username",u.getUsername());
                        i.putExtra("myid",String.valueOf(u.getId()));
                        startActivity(i);
                        finish();
                        List<Msg> ms=db.getUserMsgs(u.getUsername());
                        for(Msg m:ms)
                        {
                            Log.d("hello",String.valueOf(m.getReciver())+"   "+String.valueOf(m.getTime()));
                        }
                        break;
                    }
            }
            if(!loged)
            {
                username.setText("");
                password.setText("");
                Log.d("Loged","NotLogged");
            }
        }
    }
}