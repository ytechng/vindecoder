package carfacts.vindecoder.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages={"carfacts.vindecoder.dto"})
@EnableTransactionManagement
public class DatabaseConfig {
	 
	// H2 Connection String
	/*private static final String DATABASE_URL = "jdbc:h2:tcp://localhost/~/vindecoder";
	private static final String DATABASE_DRIVER = "org.h2.Driver";
	private static final String DATABASE_DIALECT = "org.hibernate.dialect.H2Dialect";
	private static final String DATABASE_USERNAME = "sa";
	private static final String DATABASE_PASSWORD = "";*/
	
	// MySQL Connection String
	/*private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/vindecoder";
	private static final String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver"; //"com.mysql.jdbc.Driver";
	private static final String DATABASE_DIALECT = "org.hibernate.dialect.MySQLDialect";
	private static final String DATABASE_USERNAME = "root";
	private static final String DATABASE_PASSWORD = "ytech-1234";*/
	
	// Microsoft SQL Connection String (DESKTOP-L4BVT38\CarFacts)
	private static final String DATABASE_URL = "jdbc:sqlserver://localhost;databaseName=CARFACTS";
	private static final String DATABASE_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String DATABASE_DIALECT = "org.hibernate.dialect.SQLServer2012Dialect";
	private static final String DATABASE_USERNAME = "sa";
	private static final String DATABASE_PASSWORD = "Ytech@12345#";
	
	// dataSource bean will be available
	// dataSource will be used inside spring-security.xml file
	@Bean("dataSource")
	public DataSource getDataSource() {
		
		BasicDataSource dataSource = new BasicDataSource();
		
		// Providing the database connection information
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);
		
		return dataSource;
	}
	
	
	// sessionFactory bean will be available
	@Bean
	public SessionFactory getSessionFactory(DataSource ds) {
		
		// Note the hibernate version used
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(ds);
		
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("carfacts.vindecoder.dto");
		
		return builder.buildSessionFactory();
		
	}


	// All hibernate properties will be returned in this method
	private Properties getHibernateProperties() {

		Properties properties = new Properties();
		
		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql", "true"); 
		properties.put("hibernate.format_sql", "true");
		
		// create table for my database if not exist
		properties.put("hibernate.hbm2ddl.auto", "create");
		
		// update database table if exist
		//properties.put("hibernate.hbm2ddl.auto", "update");
		
		return properties;
	}
	
	
	// transactionManagement bean will be available
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sf) {
		
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sf);
		
		return transactionManager;
	}

}
