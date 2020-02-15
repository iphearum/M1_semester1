package edu.itc.gic.m1.semester1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import edu.itc.gic.m1.semester1.db.ContributorDAO;
import edu.itc.gic.m1.semester1.model.Contributor;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        Intent intent = new Intent(MainActivity.this,SplashscreenActivity.class);
        startActivity(intent);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            List<Contributor> contributors = ContributorDAO.listAll();
            if (contributors!=null && contributors.isEmpty()) {
                // Simulate data
                Contributor[] simulatedContributors = new Contributor[][]{
                        new Contributor("phearum"),
                };
                contributors.(simulatedContributors);
            }
        });
    }
}
