package dam.androidjavier_juan_uceda.u3t5menusactivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.ContextMenu;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private TextView tvMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        tvMessage = findViewById(R.id.tvMessage);
        registerForContextMenu(tvMessage);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        int color=Color.BLACK;
        boolean return_value=true;

        switch (id) {
            case R.id.context_menu_option_red: color= Color.RED; break;
            case R.id.context_menu_option_blue: color=Color.BLUE; break;
            case R.id.context_menu_option_green: color=Color.GREEN; break;
            default: return_value=super.onOptionsItemSelected(item); break;

        }

        if (return_value) {
            tvMessage.setTextColor(color);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if (v.getId() == R.id.tvMessage) {
            getMenuInflater().inflate(R.menu.context_menu,menu);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @SuppressLint("ShowToast")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        String toast_message="";
        boolean return_value=true;

        switch (id) {
            case R.id.options_welcome: toast_message=getString(R.string.options_welcome_selected); break;
            case R.id.option_about: toast_message=getString(R.string.option_about_selected); break;
            case R.id.option_options: toast_message=getString(R.string.option_options_selected); break;

            case R.id.option_options_theme: toast_message=getString(R.string.option_options_theme_selected); break;
            case R.id.option_options_sound: toast_message=getString(R.string.option_options_sound_selected); break;

            case R.id.option_exit: toast_message=getString(R.string.option_exit_selected); break;
            default: return_value=super.onOptionsItemSelected(item); break;

        }

        if (return_value) {
            Toast.makeText(this,toast_message, Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
