package nl.gblokict.firebasetest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {
    Button button1, button2, button3, button4;
    TextView tvOutput;
    ImageView ivData;
    Spinner spWoorden;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.btn1);
        button2 = findViewById(R.id.btn2);
        button3 = findViewById(R.id.btn3);
        button4 = findViewById(R.id.btn4);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        tvOutput = findViewById(R.id.textView);
        ivData = findViewById(R.id.imgData);
        spWoorden = findViewById(R.id.spWoorden);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                make_hello_world();
                break;
            case R.id.btn2:
                show_hello_world();
                break;
            case R.id.btn3:
                //create;
                break;
            case R.id.btn4:
                //
                break;
        }
    }

    private void make_hello_world() {
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://fir-test-c1b38-default-rtdb.europe-west1.firebasedatabase.app/");
        DatabaseReference myRef = database.getReference("message");

        Date currentTime = Calendar.getInstance().getTime();
        String m ="Hallo wereld!..de tijd is:"+currentTime.toString();
        myRef.setValue(m);

        Toast.makeText(getApplicationContext(), "Melding: "+m,
                Toast.LENGTH_SHORT).show();
    }

    private void show_hello_world() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");
        ValueEventListener mListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String m = dataSnapshot.getValue().toString();
                Toast.makeText(getApplicationContext(), "Opgeslagen: "+m,
                        Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        };
        myRef.addValueEventListener(mListener);
    }





}