import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.book.config.HibernateUtil;
import com.book.entity.Book;
import com.book.service.BookService;
import com.book.service.BookServiceImpl;

public class BookClient {
	
	public static void main(String[] args) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		System.out.println("Session: " + s);
		
		Criteria cr = s.createCriteria(Book.class);
		List<Book> al = cr.list();
		al.forEach(System.out::println);
		
		Criteria cr1 = s.createCriteria(Book.class);
		cr1.add(Restrictions.eq("price", 780));
		
		Criteria cr1X = s.createCriteria(Book.class);
		cr1X.add(Restrictions.between("price", 29, 222000));
		
		Criteria cr1Y = s.createCriteria(Book.class);
		cr1Y.add(Restrictions.isNull("price"));
		
		List results = cr1.list();
		results.forEach(System.out::println);
		
		Criteria cr2 = s.createCriteria(Book.class);
		cr2.add(Restrictions.like("title", "Burb%"));
		
		List results2 = cr2.list();
		results2.forEach(System.out::println);
		
		Criteria cr3 = s.createCriteria(Book.class);
		cr3.addOrder(Order.asc("price"));
		
		List results3 = cr3.list();
		results3.forEach(System.out::println);
		
		//org.hibernate.query.Query query = s.getNamedQuery(Book.GET_Books_By_ID).setInteger("id", 6);
		
		//Book book = (Book) query.uniqueResult();
		//System.out.println(book.getTitle());
		
		//BookService bookService = new BookServiceImpl();
		//bookService.createBook(new Book("Hiberate", "A. Bear", 780));
		//bookService.getBookById(1);
		//bookService.updateBookById(2, 223000);
	}
	
}
