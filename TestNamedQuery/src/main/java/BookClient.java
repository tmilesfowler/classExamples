import org.hibernate.Session;

import com.book.config.HibernateUtil;
import com.book.entity.Book;

public class BookClient {
	
	public static void main(String[] args) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		System.out.println("Session: " + s);
		
		org.hibernate.query.Query query = s.getNamedQuery(Book.GET_Books_By_ID).setInteger("id", 6);
		
		Book book = (Book) query.uniqueResult();
		System.out.println(book.getTitle());
		
		//BookService bookService = new BookServiceImpl();
		//bookService.createBook(new Book("Burbina", "LaHergie", 780));
		//bookService.getBookById(1);
		//bookService.updateBookById(2, 223000);
	}
	
}
