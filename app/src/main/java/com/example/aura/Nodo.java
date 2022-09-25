package com.example.aura;

public class Nodo {
    String text;
    Nodo[] children;

    public Nodo(String text, int nchildren) {
        this.text = text;
        this.children = new Nodo[nchildren];
    }


    public String getText() {
        return text;
    }

    public Nodo getChild(int i) {
        return children[i];
    }

    public int getNumChildren() {
        return children.length;
    }

    public void setChildren(Nodo[] children) {
        this.children = children;
    }

    public String[] childrenToText() {
        String[] strChildren = new String[children.length];
        for(int i=0; i<children.length; i++){
            strChildren[i] = children[i].getText();
        }
        return strChildren;
    }

    public Nodo[] getChildren() {
        return children;
    }
}
