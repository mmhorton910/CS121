package jrails;

import org.junit.Before;
import org.junit.Test;

import books.BookController;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class JRouterTest {

    private JRouter jRouter;

    @Before
    public void setUp() throws Exception {
        jRouter = new JRouter();
    }

    @Test
    public void addRoute() {
        jRouter.addRoute("GET", "/", String.class, "index");
        assertThat(jRouter.getRoute("GET", "/"), is("java.lang.String#index"));
    }

    @Test
    public void addTwoRoutes() {
        JRouter jRouter = new JRouter();
        jRouter.addRoute("GET", "/", BookController.class, "index");
        jRouter.addRoute("GET", "/show", BookController.class, "show");
        assertThat(jRouter.getRoute("GET", "/"), is("books.BookController#index"));
        assertThat(jRouter.getRoute("GET", "/show"), is("books.BookController#show"));
        assert(jRouter.getRoute("GET", "/dne") == null);
    }
}