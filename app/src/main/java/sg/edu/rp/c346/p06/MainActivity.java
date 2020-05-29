package sg.edu.rp.c346.p06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button add;
    ListView lv;
    ArrayList<Task> tasks;
    TaskAdapter aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add = findViewById(R.id.btnAdd);
        lv = findViewById(R.id.lvTask);

        tasks = new ArrayList<>();
        DBHelper db = new DBHelper(MainActivity.this);
        tasks.clear();
        tasks.addAll(db.getTask());
        db.close();

        aa = new TaskAdapter(this, R.layout.row,tasks);
        lv.setAdapter(aa);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, AddActivity.class);
                startActivityForResult(i, 9);

            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Only handle when 2nd activity closed normally
        //  and data contains something
        if (resultCode == RESULT_OK && requestCode == 9) {
            DBHelper db = new DBHelper(MainActivity.this);
            tasks.clear();
            tasks.addAll(db.getTask());
            db.close();
            aa.notifyDataSetChanged();
        }

    }
}
