package Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import Controller.TrainAdptor;
import Model.Practice;

public class Training extends AppCompatActivity {

    List<Practice> practices;
    RecyclerView recyclerView;
    RecyclerView.Adapter Adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);
        inti();
    }

    private void inti()
    {
        practices=new ArrayList<>();
        practices.add(new Practice(R.drawable.a1,"Ez bar curl \n X15","An EZ-bar curl is, well, easy. Stand with your feet shoulder-width apart, knees slightly bent. Hold an EZ-bar in an underhand grip with your arms extended and then curl the bar up towards your chest, keeping your elbows in to your sides. But it’s also easy to get the finer points wrong – nail your form with these tips."));
        practices.add(new Practice(R.drawable.a2,"DB Curl \n X15","Hold a dumbbell in each hand and stand with your feet as wide apart as your hips. Let your arms hang down at your sides with your palms forward. Pull your abdominals in, stand tall, and keep your knees slightly bent. Curl both arms upward until they're in front of your shoulders. Slowly lower the dumbbells back down."));
        practices.add(new Practice(R.drawable.a3,"Hammer curl \n X15","The Hammer Curl is a quintessential weightlifting exercise that targets the biceps and forearms. The exercise is performed with dumbbells, and it strengthens the three largest muscles along the front of your upper arms. To gain all the benefits of the exercise, make sure not to lean back or swing the weights."));
        practices.add(new Practice(R.drawable.a4,"Push Downs \n X15","The rope triceps pushdown exercise uses a rope to target the triceps muscle for better definition and bigger arms. Steps : 1.) Start off standing in front of a cable machine, attaching a rope to the high pulley and grabbing the attachment with an overhand (palms down) grip."));
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        Adapter=new TrainAdptor(this,practices);
        recyclerView.setAdapter(Adapter);



    }
}