package com.example.aura;

public class TextoTree {

    Nodo root;

    public void crearArbol() {
        Nodo q1 = new Nodo("Comprendo. En base a lo que he analizado te daré mis recomendaciones", 7);
        Nodo[] q1a = this.creaNodos(new String[]{"3", "2", "1", "0", "-1", "-2", "-3"}, 3);
        q1.setChildren(q1a);

        Nodo[] qp3 = this.creaNodos(new String[]{"¡Hoy ha sido un día extraordinario! ;)", "¡Ojalá mañana sea un día aún mejor! :)", "Te animo a contagiar tu energía positiva con las personas que te rodean :)"}, 0);
        q1a[0].setChildren(qp3);

        Nodo[] qp2 = this.creaNodos(new String[]{"¡Hoy tuviste un día excelente! Me da mucha alegría escuchar eso de ti.",
                "Entiendo, fue un día bueno. Aunque en momentos sientas emociones que te frustren. Te invito a realizar un ejercicio de meditación conmigo: Siéntate en un sofá, en una cama, o en la silla donde trabajas. Colócate en una posición cómoda con la cabeza recargada, pon las manos sobre tus muslos sin tensión y no cruces tus piernas. Cierra los ojos sin apretarlos, sólo relájalos. Ahora la respiración hará de las suyas.",
                "Fue un día raro, ¿verdad? Es normal experimentar varios tipos de sensaciones y emociones a la vez. Descansa por hoy, te recomiendo realizar un ejercicio de relajación: Cierra los ojos, pon atención en tu respiración, respira lentamente por la nariz, intentando llenar de aire el estómago, como si fuera un globo y seguidamente llene el pecho de aire. Retén el aire en sus pulmones unos segundos, saca el aire lentamente por la boca o la nariz, haz una pausa de unos pocos segundos y vuelve a comenzar de nuevo."}, 0);
        q1a[1].setChildren(qp2);

        Nodo[] qp1 = this.creaNodos(new String[]{"¡Hola!, es probable que hayas tenido alguna emoción negativa durante el día. Sin embargo, lo más importante es la perspectiva con la que ves los sucesos que hayan ocurrido y cómo te sientes al respecto. ;)",
                "Mañana será un nuevo día en el cual tendrás la oportunidad de continuar aprendiendo y mejorando como persona. ;)",
                "Puedes pasar unos minutos con el siguiente minijuego para relajarte un poco."}, 0);
        q1a[2].setChildren(qp1);

        Nodo[] q0 = this.creaNodos(new String[]{"Has sentido emociones contradictorias a lo largo del día. Es posible que te sientas muy cansado y tu día haya tenido algunos problemas. Te comprendo, a veces me pasa igual. Descansa, lo mereces. ;)",
                                "¡No te preocupes!, a todas y todos nos pasa así alguna vez, es normal sentirse abrumado de emociones. Si necesitas ayuda puedes dirigirte a nuestra red de psicólogos. :)"}, 0);
        q1a[3].setChildren(q0);

        Nodo[] qm1 = this.creaNodos(new String[]{"Ha sido un día pesado, te sugiero jugar el siguiente minijuego para que entres en un estado de relajación.",
                "Mañana será un día mucho mejor. ¡Descansa! ;)",
                "Entiendo que el día no haya ido del todo bien, pero lo llevaste con éxito. Te felicito. : )"}, 0);
        q1a[4].setChildren(qm1);

        Nodo[] qm2 = this.creaNodos(new String[]{"Este día has tenido muchas dificultades. A veces la vida nos pone muchos retos y obstáculos. Sin embargo, no significa que todos los días serán como hoy. ;)",
                "¡Te recomiendo dedicarle unos minutos al siguiente minijuego para entrar en un mejor estado anímico!",
                "Mañana será un día mucho mejor. ¡Que descanses! :)"}, 0);
        q1a[5].setChildren(qm2);

        Nodo[] qm3 = this.creaNodos(new String[]{"Fue un mal día, te comunicaré con alguno de tus contactos de confianza.",
                "Algunos días son como estos, existen situaciones que no podemos controlar. Si deseas pedir ayuda puedes contactar a alguna persona de confianza y contarle. ;)",
                "Te animo a realizar la siguiente meditación durante los próximos días para retomar fuerza: Siéntate en un sofá, en una cama, o en la silla donde trabajas. Colócate en una posición cómoda con la cabeza recargada, pon las manos sobre tus muslos sin tensión y no cruces tus piernas. Cierra los ojos sin apretarlos, sólo relájalos. Ahora la respiración hará de las suyas."}, 0);
        q1a[6].setChildren(qm3);

        root=q1;
    }

    public Nodo[] creaNodos(String[] strs, int nchildren){
        Nodo[] nodos = new Nodo[strs.length];
        for(int i = 0; i<strs.length; i++){
            nodos[i] = new Nodo(strs[i], nchildren);
        }
        return nodos;
    }

}
