package carfacts.vindecoder.config;

/*@Configuration
@ComponentScan(basePackages="carfacts.vindecoder.dao")
@EnableTransactionManagement*/
public class DatabaseConfig {

	/*private static final String DATABSE_URL = "jdbc:mysql://localhost:3306/vindecoder";
	private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DATABASE_DIALECT = "org.hibernate.dialect.MySQLDialect";
	private static final String DATABASE_USERNAME = "root";
	private static final String DATABASE_PASSWORD = "ytech-1234";
	
	*//**
	 * Get DataSource
	 * @return dataSource
	 *//*
	@Bean("dataSource")
	public DataSource getDataSource() {
		
		BasicDataSource dataSource = new BasicDataSource();
		
		// providing the database connection details
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABSE_URL);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);
		
		return dataSource;
	}*/
	
	/**
	 * Get SessionFactory
	 * @param dataSource
	 * @return sessionFactory
	 */
	/*public SessionFactory getSessionFactory(DataSource dataSource) {
		
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		return null;
		
		//builder.addProperties(properties)
		
		
	}*/
}
