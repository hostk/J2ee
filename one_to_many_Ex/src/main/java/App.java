import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.one_to_one.*;
public class App {
	static Session session;
	public static SessionFactory factory;
	
	public static SessionFactory Sfactoy() {
		try {
				StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
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
		Transaction tx = null;
		//System.out.println("*****Insert is Successful******");
		try {
		tx=session.beginTransaction();
		
			/*
			 * Author author=new Author("Min Ko Ko","09977264873"); Book book = new
			 * Book("Flying Birds","133849440404"); Book book2 =new
			 * Book("Rasing To Top","238899837897789"); book.setAuthor(author);
			 * book2.setAuthor(author); Set<Book> bookList = new HashSet<Book>();
			 * 
			 * bookList.add(book); bookList.add(book2);
			 * 
			 * author.setBookList(bookList);
			 * 
			 * session.save(author);
			 */
		
		System.out.println("Hiber Query Language");
		String sql ="FROM Author";
		List query = session.createQuery(sql).list();
		System.out.println("ALL List");
		for (@SuppressWarnings("rawtypes")
		Iterator iterator = query.iterator(); 
				iterator.hasNext();){
            Author employee = (Author) iterator.next(); 
            System.out.print("  ID: " + employee.getId()); 
            System.out.print("Name: " + employee.getName()); 
            System.out.println("Phone : " + employee.getPhone()); 
         }
		
		System.out.println();
		System.out.println();
		System.out.println("ORDER BY");
		String check="FROM Author As A WHERE A.id>60 ORDER BY A.name ASC";
		@SuppressWarnings("rawtypes")
		List checkList=session.createQuery(check).list();
		for(@SuppressWarnings("rawtypes")
		Iterator iterator = checkList.iterator();
		iterator.hasNext();) {
			Author a = (Author) iterator.next();
			System.out.print("  ID: " + a.getId()); 
            System.out.print("Name: " + a.getName()); 
            System.out.println("Phone : " + a.getPhone());
		}
		System.out.println();
		System.out.println();
		System.out.println("Find List");
		String find = "FROM Author AS A WHERE A.id=:a_id";
		Query q = session.createQuery(find);
		q.setParameter("a_id", 76);
		List ff = q.list();
		for(@SuppressWarnings("rawtypes")
		Iterator iterator = ff.iterator();
		iterator.hasNext();) {
			Author a = (Author) iterator.next();
			System.out.print("  ID: " + a.getId()); 
            System.out.print("Name: " + a.getName()); 
            System.out.println("Phone : " + a.getPhone());
		}
		
		System.out.println();
		System.out.println();
		System.out.println("UPDATE");
		String update ="UPDATE Author SET name =:a_name"+" WHERE id=:a_id";
		
		@SuppressWarnings("rawtypes")
		Query up = session.createQuery(update);
		up.setParameter("a_name", "AG MYo");
		up.setParameter("a_id", 76);
		int uu = up.executeUpdate();
		System.out.println("Updated "+uu);
		
			/*
			 * System.out.println(); System.out.println();
			 * System.out.println("INSERT TEST"); String ii
			 * ="INSERT INTO Author(id,name,phone)"+" SELECT name,isbn FROM Book";
			 * 
			 * @SuppressWarnings("rawtypes") Query insert = session.createQuery(ii);
			 * 
			 * int in = insert.executeUpdate(); System.out.println("Delete "+in);
			 */
		
		System.out.println("ALL List Pagination");
		String sq ="FROM Author";
		Query limit= session.createQuery(sq);
		limit.setFirstResult(1);
		limit.setMaxResults(5);
		List result = limit.list();
		for (@SuppressWarnings("rawtypes")
		Iterator iterator = result.iterator(); 
				iterator.hasNext();){
            Author employee = (Author) iterator.next(); 
            System.out.print("  ID: " + employee.getId()); 
            System.out.print("Name: " + employee.getName()); 
            System.out.println("Phone : " + employee.getPhone()); 
         }
		
		
		System.out.println();
		System.out.println();
		System.out.println("Criteria Query Test");
		
		System.out.println();
		System.out.println("Select Query Test");
		Criteria cr  = session.createCriteria(Author.class);
		List rr = cr.list();
		for(Iterator iterator = rr.iterator();iterator.hasNext();) {
			Author employee = (Author) iterator.next(); 
            System.out.print("  ID: " + employee.getId()); 
            System.out.print("Name: " + employee.getName()); 
            System.out.println("Phone : " + employee.getPhone());
		}
		
		System.out.println();
		System.out.println("Criteria Add() Query Test");
		Criteria cc  = session.createCriteria(Author.class);
		cc.add(Restrictions.eq("name", "AG MYo"));
		List clist = cc.list();
		for(Iterator iterator = clist.iterator();iterator.hasNext();) {
			Author employee = (Author) iterator.next(); 
            System.out.print("  ID: " + employee.getId()); 
            System.out.print("Name: " + employee.getName()); 
            System.out.println("Phone : " + employee.getPhone());
		}
		System.out.println();
		System.out.println("Criteria Add(Restriction.like) Query Test");
		Criteria c  = session.createCriteria(Author.class);
		c.add(Restrictions.like("name", "M%"));
		List cclist = c.list();
		for(Iterator iterator = cclist.iterator();iterator.hasNext();) {
			Author employee = (Author) iterator.next(); 
            System.out.print("  ID: " + employee.getId()); 
            System.out.print("Name: " + employee.getName()); 
            System.out.println("Phone : " + employee.getPhone());
		}
		
		System.out.println();
		System.out.println("Select add(Restriction.isNull) Query Test");
		Criteria ccc=session.createCriteria(Author.class);
		ccc.add(Restrictions.isNotNull("name"));
		List rrr = ccc.list();
		for(Iterator iterator = rrr.iterator();iterator.hasNext();) {
			Author employee = (Author) iterator.next(); 
            System.out.print("  ID: " + employee.getId()); 
            System.out.print("Name: " + employee.getName()); 
            System.out.println("Phone : " + employee.getPhone());
		}
			/*
			 * ccc.add(Restrictions.isEmpty("name")); List rrrr = ccc.list(); for(Iterator
			 * iterator = rrrr.iterator();iterator.hasNext();) { Author employee = (Author)
			 * iterator.next(); System.out.print("  ID: " + employee.getId());
			 * System.out.print("Name: " + employee.getName());
			 * System.out.println("Phone : " + employee.getPhone()); }
			 */
		System.out.println();
		System.out.println("Select add(Restriction.and) Query Test");
		Criterion nam =Restrictions.like("name","Min%");
		Criterion phon = Restrictions.like("phone","09969%");
		//LogicalExpression orExp = Restrictions.or(nam,phon);
		LogicalExpression orExp = Restrictions.and(nam,phon);

		
		ccc.add(orExp);
		List or = ccc.list();
		for(Iterator iterator = or.iterator();iterator.hasNext();) {
			Author employee = (Author) iterator.next(); 
            System.out.print("  ID: " + employee.getId()); 
            System.out.print("  Name: " + employee.getName()); 
            System.out.println("  Phone : " + employee.getPhone());
		}
		
		System.out.println();
		System.out.println("Select Criteria Pagination Query Test");
		cr.setFirstResult(1);
		cr.setMaxResults(3);
		List cPagination = cr.list();
		for(Iterator iterator = cPagination.iterator();iterator.hasNext();) {
			Author employee = (Author) iterator.next(); 
            System.out.print("  ID: " + employee.getId()); 
            System.out.print("  Name: " + employee.getName()); 
            System.out.println("  Phone : " + employee.getPhone());
		}
		
		System.out.println();
		System.out.println("Select Criteria Order Query Test");
		Criteria crr  = session.createCriteria(Author.class);
		crr.addOrder(Order.asc("name"));
		
		List cOrder = crr.list();
		for(Iterator iterator = cOrder.iterator();iterator.hasNext();) {
			Author employee = (Author) iterator.next(); 
            System.out.print("  ID: " + employee.getId()); 
            System.out.print("  Name: " + employee.getName()); 
            System.out.println("  Phone : " + employee.getPhone());
		}
		System.out.println();
		System.out.println("Select Criteria Projection Query Test");
		Criteria crrr = session.createCriteria(Author.class);
		crrr.setProjection(Projections.countDistinct("name"));
		
		List cCountDistinct = crrr.list();
		for(Iterator iterator = cCountDistinct.iterator();iterator.hasNext();) {
			Author employee = (Author) iterator.next(); 
            System.out.print("  ID: " + employee.getId()); 
            System.out.print("  Name: " + employee.getName()); 
            System.out.println("  Phone : " + employee.getPhone());
		}
		
		tx.commit();
		}catch(Exception e) {
			if(tx != null) {
				System.out.print("Failed");
				tx.rollback();
				e.printStackTrace();
			}
		}finally {
			if(session!=null) {
			session.close();
			}
		}
	}
}
