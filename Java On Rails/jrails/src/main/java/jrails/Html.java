package jrails;

import javax.swing.text.html.HTML;

public class Html {

    public String text;

    public Html(){
        this.text = "";
    }

    public Html(String text){
        this.text = text;
    }

    public String toString() {
        return text;
    }

    public Html seq(Html h) {
        return new Html(text + h.toString());
    }

    public Html br() {
        return seq(View.br());
    }

    public Html t(Object o) {
        // Use o.toString() to get the text for this
        return seq(View.t(o));
    }

    public Html p(Html child) {
        return seq(View.p(child));
    }

    public Html div(Html child) {
        return seq(View.div(child));
    }

    public Html strong(Html child) {
        return seq(View.strong(child));
    }

    public Html h1(Html child) {
        return seq(View.h1(child));
    }

    public Html tr(Html child) {
        return seq(View.tr(child));
    }

    public Html th(Html child) {
        return seq(View.th(child));
    }

    public Html td(Html child) {
        return seq(View.td(child));
    }

    public Html table(Html child) {
        return seq(View.table(child));
    }

    public Html thead(Html child) {
        return seq(View.thead(child));
    }

    public Html tbody(Html child) {
        return seq(View.tbody(child));
    }

    public Html textarea(String name, Html child) {
        return seq(View.textarea(name, child));
    }

    public Html link_to(String text, String url) {
        return seq(View.link_to(text, url));
    }

    public Html form(String action, Html child) {
        return seq(View.form(action, child));
    }

    public Html submit(String value) {
        return seq(View.submit(value));
    }
}