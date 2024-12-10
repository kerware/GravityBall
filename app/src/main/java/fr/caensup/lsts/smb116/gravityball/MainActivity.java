package fr.caensup.lsts.smb116.gravityball;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


        private GameView gameView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            gameView = new GameView(this);
            setContentView(gameView);
        }


}