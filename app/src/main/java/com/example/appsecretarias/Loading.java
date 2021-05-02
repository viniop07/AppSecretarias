package com.example.appsecretarias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

public class Loading extends AppCompatActivity {
    ProgressBar pb1;
    int progress=0;
    Handler h = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

            setContentView(R.layout.activity_main);
            pb1=(ProgressBar)findViewById(R.id.progressBar1);

            new Thread(new Runnable()
            {
                @Override
                public void run()
                {
                    for(int i=0; i<5; i++)
                    {
                        progress +=20;
                        h.post(new Runnable()
                        {
                            @Override
                            public void run()
                            {
                                pb1.setProgress(progress);
                                if(progress == pb1.getMax())
                                {
                                    //Intent i = new Intent(Loading.this, MainActivity.class);
                                    //startActivity(i);
                                }
                            }
                        });
                        try
                        {
                            Thread.sleep(3000);
                        }
                        catch (InterruptedException e)
                        {

                        }
                    }
                }
            }).start();

    }
}