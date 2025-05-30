package jrails;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import books.Book;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

public class ModelTest {

    private Model model;

    @Before
    public void setUp() throws Exception {
        model = new Model(){};
    }

    @Test
    public void id() {
        assertThat(model.id(), notNullValue());
    }

    @Test
    public void testAll() {
        Book book1 = new Book();
        book1.title = "Book One";
        book1.author = "Author One";
        book1.num_copies = 3;
        book1.save();

        Book book2 = new Book();
        book2.title = "Book Two";
        book2.author = "Author Two";
        book2.num_copies = 2;
        book2.save();

        List<Book> allBooks = Model.all(Book.class);
        assert(allBooks.size() == 2);
    }


    @After
    public void tearDown() throws Exception {
    }
}