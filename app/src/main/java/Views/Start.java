package Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

public class Start extends AppCompatActivity  implements View.OnClickListener {
    Button login,reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_start);
        inti();
        login.setOnClickListener(this);
        reg.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.LoginID:
                startActivity(new Intent(this,LogIn.class));
                break;
            case R.id.SignUpID:
                startActivity(new Intent(this,Register.class));
                break;

        }
    }

    private  void inti()
    {
        login=findViewById(R.id.LoginID);
        reg=findViewById(R.id.SignUpID);
    }

}