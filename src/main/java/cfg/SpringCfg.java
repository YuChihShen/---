package cfg;

import java.util.Properties;


import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;


import model.bean.MemberBean;


@Configuration
@ComponentScan(basePackages = "model")
public class SpringCfg {
	
	@Bean
	public SessionFactory sessionFactory() {
		
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource());
		

		builder.addAnnotatedClass(MemberBean.class);
		
		Properties props = new Properties();
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		props.setProperty("hibernate.show_sql", "true");
		props.setProperty("hibernate.current_session_context_class", "thread");
		builder.addProperties(props);
		
		return builder.buildSessionFactory();
	}
	
	
	@Bean
	public DataSource dataSource() {
		
		HikariConfig config = new HikariConfig();
		config.setDriverClassName("com.mysql.jdbc.Driver");
		config.setJdbcUrl("jdbc:mysql://localhost:3306/skoob?");
		config.setUsername("root");
		config.setPassword("root");
		config.addDataSourceProperty("cachePrepStmts", "true");
		config.addDataSourceProperty("prepStmtCacheSize", "250");
		config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

		return new HikariDataSource(config);
	}
}
