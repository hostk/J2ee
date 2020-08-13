import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import com.one_to_one.*;
public class App {
	static Session session;
	public static SessionFactory factory;
	
	public static SessionFactory Sfactoy() {
		try {
				StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
				Metadata metaData=new MetadataSources(registry).getMetadataBuilder().build();
				factory = metaData.buildSessionFactory();
				
			}catch(Throwable th) {
			System.err.println("Initialze Session Factory failed "+ th);
			
			throw new ExceptionInInitializerError(th);
		}
		return factory;
	}
	public static void main(String[] args) {
		
		System.out.println("*****Insert is Successful******");
		try {
		session = Sfactoy().openSession();
		session.beginTransaction();
		
		Author author=new Author("Min Ko Ko","09977264873");
		Book book = new Book("Flying Birds","133849440404");
		Book book2 =new Book("Rasing To Top","238899837897789");
		book.setAuthor(author);
		book2.setAuthor(author);
		Set<Book> bookList = new HashSet<Book>();
		
		bookList.add(book);
		bookList.add(book2);
		
		author.setBookList(bookList);
		
		session.save(author);
		session.getTransaction().commit();
		}catch(Exception e) {
			if(null!=session.getTransaction()) {
				System.out.print("Failed");
				session.getTransaction().rollback();
				e.printStackTrace();
			}
		}finally {
			if(session!=null) {
			session.close();
			}
		}
	}
}
