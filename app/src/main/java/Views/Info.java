package Views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

public class Info extends AppCompatActivity {

    private Bundle b;
    private ImageView img;
    private TextView title,info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        inti();
        img.setImageResource(b.getInt("img"));
        title.setText(b.getString("title"));
        info.setText(b.getString("info"));
    }

    private void inti()
    {
        b=getIntent().getExtras();
        img=findViewById(R.id.TrainImage);
        title=findViewById(R.id.textname);
        info=findViewById(R.id.textdesc);
    }



}