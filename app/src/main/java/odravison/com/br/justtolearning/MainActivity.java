package odravison.com.br.justtolearning;

import android.media.RemoteController;
import android.preference.EditTextPreference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button saveButton;
    private EditText meuEditText;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saveButton = (Button) findViewById(R.id.save_button);
        meuEditText = (EditText) findViewById(R.id.meu_nome_text);

        saveButton.setEnabled(false);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        meuEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkEditText(charSequence, saveButton);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkEditText(charSequence, saveButton);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });




    }

    public void checkEditText(CharSequence charSequence, Button button){
        if (charSequence.length() > 0){
            button.setEnabled(true);
        }else{
            button.setEnabled(false);
        }
    };
}
