package Controller;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.List;

import Model.User;
import Views.Profile;
//import Views.profile;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Adaptor extends RecyclerView.Adapter<Adaptor.Holder> {


    private Context context;
    private List<User> Users;

    public Adaptor(Context context, List<User> Users) {
        this.context = context;
        this.Users = Users;
    }

    @Override
    public Adaptor.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row,parent,false);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adaptor.Holder holder, int position) {
        User u=Users.get(position);
        holder.name.setText(u.getFirstname()+" "+u.getLastname());
        holder.age.setText(String.valueOf(u.getAge()));
        holder.gender.setText(u.getGender());
        holder.show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(context, Profile.class);
                i.putExtra("pos",String.valueOf(u.getId()));
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return Users.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        private TextView name,age,gender;
        private FloatingActionButton show;
        public Holder(@NonNull View itemView) {
            super(itemView);
            intiviews();

        }

        private void intiviews()
        {
            name=itemView.findViewById(R.id.Name);
            age=itemView.findViewById(R.id.Age);
            gender=itemView.findViewById(R.id.Gender);
            show=itemView.findViewById(R.id.ShowBtn);
        }
    }
}
