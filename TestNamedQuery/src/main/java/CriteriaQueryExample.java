import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import com.book.config.HibernateUtil;
import com.book.entity.Book;


public class CriteriaQueryExample {

    public static void main(String[] args) {
    	
    	org.hibernate.Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
        transaction = session.beginTransaction();
        
        CriteriaBuilder builder = session.getCriteriaBuilder();
        
        CriteriaQuery<Integer> criteriaQuery = builder.createQuery(Integer.class);
        Root<Book> root = criteriaQuery.from(Book.class);
        criteriaQuery.select(builder.max(root.get("price"))); 
        Query query = session.createQuery(criteriaQuery);
        int maxPrice = (int) query.getSingleResult();
        System.out.println("Max Salary = " + maxPrice);
         
        transaction.commit();
        } catch (Exception e) {
      	  e.printStackTrace();
      	  if(transaction != null) {
      		  transaction.rollback();
      	  }
    }
    	
//    	org.hibernate.Transaction transaction = null;
//        try(Session session = HibernateUtil.getSessionFactory().openSession()){
//        transaction = session.beginTransaction();
//        
//        CriteriaBuilder builder = session.getCriteriaBuilder();
//        
//        CriteriaQuery<Long> criteriaQuery = builder.createQuery(Long.class);
//        Root<Book> root = criteriaQuery.from(Book.class);
//        criteriaQuery.select(builder.count(root)); 
//        Query query = session.createQuery(criteriaQuery);
//        long count = (long) query.getSingleResult();
//        System.out.println("Count = " + count);
//         
//        transaction.commit();
//        } catch (Exception e) {
//      	  e.printStackTrace();
//      	  if(transaction != null) {
//      		  transaction.rollback();
//      	  }
//    }
    	
    	/*	// Get employee id 1
    	org.hibernate.Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
        System.out.println("Session: " + session);
        transaction = session.beginTransaction();
        
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Book> query = builder.createQuery(Book.class);
        Root<Book> root = query.from(Book.class);
        query.select(root).where(builder.equal(root.get("id"), 5)); 
        
        Query q = session.createQuery(query);
        Book book = (Book) q.getSingleResult();
        
        System.out.println(book.getTitle());
            
        transaction.commit();
        } catch (Exception e) {
      	  e.printStackTrace();
      	  if(transaction != null) {
      		  transaction.rollback();
      	  }
    } */
    	
    	/*
	//      Alternatively, you can use a try-with-resources to open the Session
      org.hibernate.Transaction transaction = null;
      try(Session session = HibernateUtil.getSessionFactory().openSession()){
      System.out.println("Session: " + session);
      transaction = session.beginTransaction();
      
      CriteriaBuilder builder = session.getCriteriaBuilder();
      CriteriaQuery<Book> query = builder.createQuery(Book.class);
      
      Root<Book> root = query.from(Book.class);
      
      query.select(root);
      Query q = session.createQuery(query);
      List<Book> books = q.getResultList();
      for (Book book : books) {
          System.out.println(book.getTitle());
      }
      transaction.commit();
      } catch (Exception e) {
    	  e.printStackTrace();
    	  if(transaction != null) {
    		  transaction.rollback();
    	  }
  }
*/
}
	
}
