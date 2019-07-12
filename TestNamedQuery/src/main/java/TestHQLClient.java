import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.book.config.HibernateUtil;
import com.book.entity.Book;

public class TestHQLClient {

	public static void main(String[] args) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		System.out.println("Session: " + s);
		
		String HQL = "From Book";
		Query query = s.createQuery(HQL,Book.class);
		List<Book> al = query.getResultList();
		
		al.forEach(System.out::println);
		
		int bookId = 2;
		String HQL1 = "From Book where id = ?";
		Query query1 = s.createQuery(HQL1,Book.class);
		
		query1.setParameter(0, bookId);
		Book b1 = (Book) query1.getSingleResult();
		System.out.println(b1);
		
		int bId = 2;
		int bprice=223000;
		String HQL2 = "From Book where id = :bookId and price = :bookprice";
		Query query3 = s.createQuery(HQL2, Book.class);
		query3.setParameter("bookId", bId);
		query3.setParameter("bookprice", bprice);
		Book b2 = (Book) query3.getSingleResult();
		System.out.println(b2);
		
		String authorX = "Jimmy";
		int bpriceX=223000;
		String HQL2X = "From Book where author = :author and price = :bookprice";
		Query query3X = s.createQuery(HQL2X, Book.class);
		query3X.setParameter("author", authorX);
		query3X.setParameter("bookprice", bpriceX);
		Book b2X = (Book) query3X.getSingleResult();
		System.out.println(b2X);
		
		String HQL4 = "Select id, title From Book ";
		Query query5 = s.createQuery(HQL4);
		List<Object[]> list = query5.getResultList();
		for(Object[] obj: list) {
			Integer bid = (Integer) obj[0];
			String btitle = (String)obj[1];
			System.out.println(bid + "\t" + btitle);
		}
	}
	
}
