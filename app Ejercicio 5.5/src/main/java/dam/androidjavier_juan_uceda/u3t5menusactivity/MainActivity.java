package dam.androidjavier_juan_uceda.u3t5menusactivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import static android.graphics.Typeface.*;

public class MainActivity extends AppCompatActivity implements MenuItem.OnMenuItemClickListener, PopupMenu.OnMenuItemClickListener {

    private TextView tvMessage;
    private TextView pop_up;
    private PopupMenu popup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);

        tvMessage = findViewById(R.id.tvMessage);
        pop_up=findViewById(R.id.pop_up);
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
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.pop_up_22:
                pop_up.setTextSize(popup.getMenu().findItem(R.id.pop_up_22).isChecked() ? (float) 10.0  :(float) 22.0);
                return true;
            case R.id.pop_up_26:
                pop_up.setTextSize(popup.getMenu().findItem(R.id.pop_up_26).isChecked() ? (float) 10.0  :(float) 26.0);
                return true;
            case R.id.pop_up_30:
                pop_up.setTextSize(popup.getMenu().findItem(R.id.pop_up_30).isChecked() ? (float) 10.0  :(float) 30.0);
                return true;
            case R.id.pop_up_bold:
                pop_up.setTypeface((popup.getMenu().findItem(R.id.pop_up_bold).isChecked() && !(popup.getMenu().findItem(R.id.pop_up_italic).isChecked()) ? Typeface.defaultFromStyle(NORMAL) : (pop_up.getTypeface().getStyle()== ITALIC) ? Typeface.defaultFromStyle(BOLD_ITALIC) : Typeface.defaultFromStyle(BOLD)));
                return true;
            case R.id.pop_up_italic:
                pop_up.setTypeface((popup.getMenu().findItem(R.id.pop_up_italic).isChecked() && !(popup.getMenu().findItem(R.id.pop_up_bold).isChecked()) ? Typeface.defaultFromStyle(NORMAL) : (pop_up.getTypeface().getStyle() == BOLD) ? Typeface.defaultFromStyle(BOLD_ITALIC) : Typeface.defaultFromStyle(ITALIC)));
                return true;
            default: return false;

        }
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
            crear_toast(toast_message);
        }
        return super.onOptionsItemSelected(item);
    }

    public void showMenu(View v) {
        popup = new PopupMenu(this, v);

        // This activity implements OnMenuItemClickListener

        popup.inflate(R.menu.pop_up_menu);
        popup.getMenu().findItem(R.id.pop_up_26).setChecked((pop_up.getTextSize() == 91.0));
        popup.getMenu().findItem(R.id.pop_up_22).setChecked((pop_up.getTextSize() == 77.0));
        popup.getMenu().findItem(R.id.pop_up_30).setChecked((pop_up.getTextSize() == 105.0));
        popup.getMenu().findItem(R.id.pop_up_bold).setChecked((pop_up.getTypeface().getStyle()== BOLD));
        popup.getMenu().findItem(R.id.pop_up_italic).setChecked((pop_up.getTypeface().getStyle()== ITALIC));
        if ((pop_up.getTypeface().getStyle()== BOLD_ITALIC)) {
            popup.getMenu().findItem(R.id.pop_up_bold).setChecked(true);
            popup.getMenu().findItem(R.id.pop_up_italic).setChecked(true);
        }
        popup.setOnMenuItemClickListener(this);
        popup.show();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    private void crear_toast(String text_to_print){
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_personalizado, (ViewGroup) findViewById(R.id.toast_personalizado));

        TextView text = layout.findViewById(R.id.textView);
        text.setText(text_to_print);

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }

    public void styleSnackbar(View view) {
        Snackbar snackbar = Snackbar.make(view, "Exit application?", Snackbar.LENGTH_LONG).setAction("YES", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        finish();
                    }
                });

        //ACTION
        snackbar.setActionTextColor(getResources().getColor(R.color.colortext2));

        View snackBarView = snackbar.getView();
        //BACKGROUND
        snackBarView.setBackgroundColor(getResources().getColor(R.color.colorbackground));

        TextView tv = snackbar.getView().findViewById(R.id.snackbar_text);
        tv.setTextColor(Color.RED);

        snackbar.show();
    }


}
