package com.example.aura;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Chatbot extends AppCompatActivity {

    LinearLayout linearLayout;
    TextoTree tt;
    Usuario us = new Usuario();
    Context context;
    int count;
    Intent a;
    Intent b;
    Intent[] iList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatbot);

        linearLayout = (LinearLayout) findViewById(R.id.linearLayoutChat);

        context = this;
        us = new Usuario();
        count = 0;

        a = new Intent(this, Estadistica.class);
        b = new Intent(this, RedPsicologos.class);
        iList = new Intent[]{a, b};

        preguntasIniciales();



    }

    private void preguntasIniciales() {
        createText("¡Hola! ¿Cómo te llamas?");
        Pair<EditText, Button> els = readValue();
        els.second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                us.setNombre(els.first.getText().toString());
                createText("Es un gusto conocerte" + us.getNombre());
                createText("Me gustaría conocer tu género para saber cómo puedo referirme a ti");
                Button[] buttons = createInput(new String[]{"masculino", "femenino", "otro", "prefiero no decirlo"});
                for (Button b : buttons) {
                    b.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            us.setGenero(b.getText().toString());
                            createText("¿Cuál es tu meta principal?");
                            Button[] buttons = createInput(new String[]{"Reducir el estrés", "Enfrentar la ansiedad", "Superar la depresión", "Sentirme más feliz"});
                            for (Button b : buttons) {
                                b.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        us.setObjetivo(b.getText().toString());
                                        configurarPIN();
                                    }
                                });
                            }
                        }
                    });
                }
            }
        });
    }

    private void configurarPIN() {
        createText("Es posible que registres en tu diario información personal. ¿Te gustaría configurar un PIN en la app para mantener tu privacidad?");
        Button[] buttons = createInput(new String[]{"Sí", "No"});
        for (Button b : buttons) {
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (b.getText().toString() == "Sí") {
                        createText("Ingresa tu PIN");
                        Pair<EditText, Button> els = readValue();
                        els.second.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                us.setPin(Integer.parseInt(els.first.getText().toString()));
                                configurarContactosConfianza();
                            }
                        });
                    } else {
                        configurarContactosConfianza();
                    }
                }
            });
        }
    }

    private void configurarContactosConfianza() {
        createText("Nos gustaría ayudarte a generar una red de apoyo que pueda ayudarte en caso de una emergencia. Registra tres contactos en quienes tengas confianza");
        createText("Ingresa el nombre seguido del número de teléfono");
        for (int i = 0; i < 3; i++) {
            LinearLayout layout2 = new LinearLayout(context);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            layout2.setLayoutParams(params);
            layout2.setOrientation(LinearLayout.HORIZONTAL);

            EditText input = new EditText(context);
            params.setMargins(20, 20, 0, 0);
            input.setLayoutParams(params);
            input.setPadding(20, 20, 20, 20);
            params.gravity = Gravity.RIGHT;

            layout2.addView(input);

            EditText input2 = new EditText(context);
            params.setMargins(20, 20, 0, 0);
            input2.setLayoutParams(params);
            input2.setPadding(20, 20, 20, 20);
            layout2.addView(input2);
            params.gravity = Gravity.RIGHT;

            linearLayout.addView(layout2);
        }
        LinearLayout layout2 = new LinearLayout(context);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        layout2.setLayoutParams(params);
        layout2.setOrientation(LinearLayout.HORIZONTAL);

        Button b = new Button(this);
        b.setLayoutParams(params);
        b.setText("Continuar");
        b.setAllCaps(false);
        b.setBackgroundColor(getResources().getColor(R.color.accent_color));
        b.setTextColor(getResources().getColor(R.color.white));
        params.gravity = Gravity.RIGHT;
        b.setPadding(10, 10, 10, 10);
        layout2.addView(b);
        linearLayout.addView(layout2);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createText("¿Nos darías autorización para enviar un mensaje a estos contactos en caso de detectar una emergencia?");
                Button[] buttons = createInput(new String[]{"Sí", "No"});
                for (Button b : buttons) {
                    b.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (b.getText().toString() == "Sí") {
                                createText("De acuerdo, muchas gracias");
                            } else {
                                createText("Comprendo. Recuerda que puedes cambiar esto más tarde si cambias de opinión");
                            }
                            preguntarEmociones();
                        }
                    });
                }
            }
        });


    }

    private void preguntarEmociones() {
        createText("¿Qué tal estuvo tu día?");
        Button[] buttons = createInput(new String[]{":)", ":("});
        for (Button b : buttons) {
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Button[] buttons = createInput(new String[]{"Estrés", "Preocupación", "Enfado", "Miedo", "Tristeza", "Amor", "Alegría", "Sorpresa", "Entusiasmo", "Calma"});
                    for (int i = 0; i < buttons.length; i++) {
                        int finalI = i;
                        buttons[i].setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                view.setBackgroundColor(getResources().getColor(R.color.dark_primary_color));
                                if (finalI < 4) {
                                    count -= 3;
                                } else {
                                    count += 3;
                                }
                            }
                        });

                    }

                    LinearLayout layout2 = new LinearLayout(context);
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT);
                    layout2.setLayoutParams(params);
                    layout2.setOrientation(LinearLayout.HORIZONTAL);

                    Button b = new Button(context);
                    params.setMargins(20, 20, 0, 0);
                    b.setLayoutParams(params);
                    b.setText("Continuar");
                    b.setAllCaps(false);
                    b.setBackgroundColor(getResources().getColor(R.color.accent_color));
                    b.setTextColor(getResources().getColor(R.color.white));
                    params.gravity = Gravity.RIGHT;
                    b.setPadding(10, 10, 10, 10);
                    layout2.addView(b);
                    linearLayout.addView(layout2);

                    b.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            darRecomendaciones(count);
                        }
                    });
                }
            });

        }


    }

    private void darRecomendaciones(int puntos) {
        Log.i("MyActivity", Integer.toString(puntos));

        tt = new TextoTree();
        tt.crearArbol();

        Nodo n = tt.root;
        createText(n.getText());
        int level;
        if (puntos >= 0) {
            level = (int) Math.ceil(puntos / 6);
        } else {
            level = (int) Math.floor(puntos / 6);
        }

        int index = level + 3;

        Nodo[] categoria = n.getChild(index).getChildren();
        int consejo = (int) (Math.random() * ((3) + 1));
        createText(categoria[consejo].getText());
        crearMenu();

    }

    private void crearMenu(){
        LinearLayout layout2 = new LinearLayout(this);
        layout2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        layout2.setOrientation(LinearLayout.VERTICAL);

        Button[] buttons = new Button[3];

        String[] str = new String[]{"Estadísticas", "Red de psicólogos"};

        for (int i = 0; i < 2; i++) {
            Button b = new Button(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(20, 20, 0, 0);
            b.setLayoutParams(params);
            b.setText(str[i]);
            b.setAllCaps(false);
            b.setBackgroundColor(getResources().getColor(R.color.accent_color));
            params.gravity = Gravity.RIGHT;
            b.setTextColor(getResources().getColor(R.color.white));;
            b.setPadding(10, 10, 10, 10);
            int finalI = i;
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(iList[finalI]);
                }
            });
            layout2.addView(b);

        }

        linearLayout.addView(layout2);
    }


    private void createText(String text) {
        TextView textView = new TextView(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(20, 20, 0, 10);
        textView.setLayoutParams(params);
        textView.setText(text);
        textView.setTextColor(getResources().getColor(R.color.white));
        textView.setBackgroundColor(getResources().getColor(R.color.dark_primary_color));
        textView.setPadding(20, 20, 20, 20);
        linearLayout.addView(textView);
    }

    private Button[] createInput(String[] options) {
        LinearLayout layout2 = new LinearLayout(this);
        layout2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        layout2.setOrientation(LinearLayout.VERTICAL);

        Button[] buttons = new Button[options.length];

        for (int i = 0; i < options.length; i++) {
            Button b = new Button(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(20, 20, 0, 0);
            b.setLayoutParams(params);
            b.setText(options[i]);
            b.setAllCaps(false);
            b.setBackgroundColor(getResources().getColor(R.color.accent_color));
            params.gravity = Gravity.RIGHT;
            b.setTextColor(getResources().getColor(R.color.white));;
            b.setPadding(10, 10, 10, 10);
            layout2.addView(b);
            buttons[i] = b;
        }

        linearLayout.addView(layout2);
        return buttons;
    }

    private Pair<EditText, Button> readValue() {

        LinearLayout layout2 = new LinearLayout(this);
        layout2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        layout2.setOrientation(LinearLayout.HORIZONTAL);


        EditText name = new EditText(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(10, 10, 0, 0);
        name.setLayoutParams(params);
        name.setPadding(20, 20, 20, 20);
        params.gravity = Gravity.RIGHT;
        layout2.addView(name);

        Button b = new Button(this);
        params.setMargins(20, 20, 0, 0);
        b.setLayoutParams(params);
        b.setText("Continuar");
        b.setAllCaps(false);
        b.setBackgroundColor(getResources().getColor(R.color.accent_color));
        b.setPadding(10, 10, 10, 10);
        b.setTextColor(getResources().getColor(R.color.white));
        params.gravity = Gravity.RIGHT;

        layout2.addView(b);

        linearLayout.addView(layout2);
        return new Pair<>(name, b);
    }
}





