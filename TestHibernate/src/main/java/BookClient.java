import org.hibernate.Session;

import com.book.config.HibernateUtil;
import com.book.entity.Book;
import com.book.service.BookService;
import com.book.service.BookServiceImpl;

public class BookClient {
	
	public static void main(String[] args) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		System.out.println("Session: " + s);
		
		BookService bookService = new BookServiceImpl();
		///bookService.createBook(new Book("Angular", "Jimmy", 200));
		//bookService.getBookById(1);
		bookService.updateBookById(2, 223000);
	}
	
}
