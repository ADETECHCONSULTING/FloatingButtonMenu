package adama.traore.fr.androidfloatingbutton;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fab_main;
    private FloatingActionButton fab2;
    private FloatingActionButton fab3;

    private Animation fab_open;
    private Animation fab_close;

    private TextView textViewFab2;
    private TextView textViewFab3;

    Boolean isOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab_main = findViewById(R.id.fab);
        fab2 = findViewById(R.id.fab2);
        fab3 = findViewById(R.id.fab3);

        //charge l'animation
        fab_close = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_closed);
        fab_open = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_opened);


        textViewFab2 = (TextView) findViewById(R.id.textview_fab2);
        textViewFab3 = (TextView) findViewById(R.id.textview_fab3);

        //gestion du floatingActionButton
        fab_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOpen) {

                    //Setter la visibilite a invisible
                    //View.INVISIBLE ne desactive pas la fab donc on doit desactiver l'event de click
                    textViewFab2.setVisibility(View.INVISIBLE);
                    textViewFab3.setVisibility(View.INVISIBLE);
                    fab2.startAnimation(fab_close);
                    fab3.startAnimation(fab_close);
                    fab2.setClickable(false);
                    fab3.setClickable(false);
                    isOpen = false;

                } else {

                    //Inversement
                    textViewFab2.setVisibility(View.VISIBLE);
                    textViewFab3.setVisibility(View.VISIBLE);
                    fab2.startAnimation(fab_open);
                    fab3.startAnimation(fab_open);
                    fab2.setClickable(true);
                    fab3.setClickable(true);
                    isOpen = true;
                }
            }
        });


        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //remplacer par l'action
                Toast.makeText(getApplicationContext(), "FAB2", Toast.LENGTH_SHORT).show();

            }
        });

        fab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //remplacer par l'action
                Toast.makeText(getApplicationContext(), "FAB3", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
