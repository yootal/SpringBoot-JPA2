package jpabook.jpashop.service;

import jakarta.persistence.EntityManager;
import jpabook.jpashop.domain.item.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
public class ItemUpdateTest {

    @Autowired
    EntityManager em;

    @Test
    public void updateTest() throws Exception {
        Book book = new Book();
        book.setName("JPA");
        book.setAuthor("유경헌");
        book.setIsbn("123");
        book.setPrice(1000);
        book.setStockQuantity(3);

        em.persist(book);

        book = em.find(Book.class, book.getId());

        //TX
        book.setName("asdfasdf");

        //변경감지 == dirty checking
        //TX commit
    }
}
