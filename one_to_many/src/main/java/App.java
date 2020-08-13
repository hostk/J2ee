import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

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
			
			throw new ExceptionInInitializerError();
		}
		return factory;
	}
	public static void main(String[] args) {
		
		session = Sfactoy().openSession();
		session.beginTransaction();
		
		Book book = new Book("Flying Birds","133849440404")
		
	}
}
