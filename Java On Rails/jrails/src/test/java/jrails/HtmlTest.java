package jrails;

import org.junit.Before;
import org.junit.Test;

import books.Book;

import static org.hamcrest.Matchers.isEmptyString;
import static org.junit.Assert.*;

import java.util.List;

public class HtmlTest {

    private Html html;

    @Before
    public void setUp() throws Exception {
        html = new Html();
    }

    @Test
    public void empty() {
        assertThat(View.empty().toString(), isEmptyString());
    }

    @Test
    public void hello() {
        html = new Html();
        html = html.p(html.t("Hello World"));
        assertEquals(html.toString(), "<p>Hello World</p>");
    }

}
