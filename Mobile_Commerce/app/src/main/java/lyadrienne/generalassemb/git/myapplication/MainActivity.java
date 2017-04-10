package lyadrienne.generalassemb.git.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import lyadrienne.generalassemb.git.myapplication.setup.DBAssetHelper;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBAssetHelper dbSetup = new DBAssetHelper(MainActivity.this);
        dbSetup.getReadableDatabase();

        DollSQLiteOpenHelper helper = DollSQLiteOpenHelper.getInstance(this);
        List<Doll> dolls = helper.getAllDolls();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(new DollRecyclerViewAdapter(dolls));

        //Todo search bar

        //TODO on click for 12/ 30/ clearance/ barbie / ethnic

    }
}
