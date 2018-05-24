package hibernate.training.programs;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import hibernate.training.entity.Brand;
import hibernate.training.entity.Product;
import hibernate.training.util.HibernateUtil;

public class P13_HQLDemos {
	private static Session session;

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		session = factory.openSession();
		try {

			printAllBrands();
			printProductsByPriceRange(100.0, 150.0);
			printProductsByPage(5); // pageNo = 5, pageSize = 10
			printProductsByBrand("Zespri");
			printFruitNames(); // only names
			printVegitableNamesAndPrices();
			increaseProductPriceBy(5); // 5%
			printBrandwiseProductPriceAggregates();
			
			session.close();
		} finally {
			factory.close();
		}
	}

	static void printBrandwiseProductPriceAggregates() {
		String hql = "select p.brand.name, avg(p.unitPrice), max(p.unitPrice), min(p.unitPrice) from Product p group by p.brand.name";
		
		Query<Object[]> qry = session.createQuery(hql, Object[].class);
		List<Object[]> list = qry.getResultList();
		for (Object[] d : list) {
			System.out.printf("%s - Avg = %.2f, Max = %.2f, Min = %.2f\n",
					d[0], d[1], d[2], d[3]);
		}
		System.out.println("--------------------------------------------------");
	}

	static void increaseProductPriceBy(double byPercent) {
		String hql = "update Product set unitPrice = unitPrice + unitPrice * :BY_PERCENT / 100";
		Query<?> qry = session.createQuery(hql);
		qry.setParameter("BY_PERCENT", byPercent);
		session.beginTransaction();
		int count = qry.executeUpdate();
		session.getTransaction().commit();
		System.out.printf("Total %d products updated\n", count);

	}

	static void printVegitableNamesAndPrices() {
		String hql = "select name, unitPrice from Product where category.name = 'Vegitables'";
		Query<Object[]> qry = session.createQuery(hql, Object[].class);
		List<Object[]> list = qry.getResultList();
		for (Object[] d : list) {
			System.out.println(d[0] + "-->Rs." + d[1]);
		}
		System.out.println("--------------------------------------------------");

	}

	static void printFruitNames() {
		String hql = "select name from Product where category.name = 'Fruits'";
		Query<String> qry = session.createQuery(hql, String.class);
		List<String> list = qry.getResultList();
		System.out.println("Fruit names: ");
		for (String f : list) {
			System.out.println(f);
		}
		System.out.println("--------------------------------------------------");

	}

	static void printProductsByBrand(String brandName) {
		String hql = "from Product where brand.name = :BRAND_NAME";
		Query<Product> qry = session.createQuery(hql, Product.class);
		qry.setParameter("BRAND_NAME", brandName);
		List<Product> list = qry.getResultList();

		System.out.printf("Products by brand '%s'\n", brandName);
		for (Product p : list) {
			System.out.printf("%3d %-30s --> Rs.%6.2f\n", p.getId(), p.getName(), p.getUnitPrice());
		}
		System.out.println("--------------------------------------------------");

	}

	static void printProductsByPage(int pageNum) {
		int pageSize = 10;
		int offset = (pageNum - 1) * pageSize;
		String hql = "from Product";
		Query<Product> qry = session.createQuery(hql, Product.class);
		qry.setFirstResult(offset);
		qry.setMaxResults(pageSize);
		List<Product> list = qry.getResultList();

		System.out.printf("Products in page %d\n", pageNum);
		for (Product p : list) {
			System.out.printf("%3d %-30s --> Rs.%6.2f\n", p.getId(), p.getName(), p.getUnitPrice());
		}
		System.out.println("--------------------------------------------------");

	}

	static void printProductsByPriceRange(double min, double max) {
		String hql = "from Product where unitPrice between :MIN_PRICE and :MAX_PRICE order by unitPrice desc";
		Query<Product> qry = session.createQuery(hql, Product.class);
		qry.setParameter("MIN_PRICE", min);
		qry.setParameter("MAX_PRICE", max);
		List<Product> list = qry.getResultList();

		System.out.printf("Products in the price range of Rs.%.2f and Rs.%.2f\n", min, max);
		for (Product p : list) {
			System.out.printf("%-30s --> Rs.%6.2f\n", p.getName(), p.getUnitPrice());
		}
		System.out.println("--------------------------------------------------");

	}

	static void printAllBrands() {
		// sql -> select * from brands;
		// hql -> select b from Brand b;
		// hql -> from Brand;

		Query<Brand> qry = session.createQuery("from Brand", Brand.class);
		List<Brand> list = qry.getResultList();
		for (Brand b : list) {
			System.out.printf("%s has %d products\n", b.getName(), b.getProducts().size());
		}
		System.out.println("--------------------------------------------------");

	}

}
