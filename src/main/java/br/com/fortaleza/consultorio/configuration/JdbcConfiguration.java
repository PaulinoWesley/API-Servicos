package br.com.fortaleza.consultorio.configuration;

import com.zaxxer.hikari.HikariDataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class JdbcConfiguration {

    private final JdbcProperties properties;

    public JdbcConfiguration(JdbcProperties properties) {
        this.properties = properties;
    }

    @Bean
    @Primary
    public DataSource dataSource() {
        return createDataSource(this.properties.getDtProperties());
    }

    @Bean
    @Primary
    public NamedParameterJdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }


    private HikariDataSource createDataSource(final JdbcProperties.JdbcDataSourceProperties dataSourceProperties) {
        final HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(this.properties.getJdbcDriverName());
        dataSource.setJdbcUrl(dataSourceProperties.getUrl());
        dataSource.setUsername(this.properties.getUsername());
        dataSource.setPassword(this.properties.getPassword());
        dataSource.setMaximumPoolSize(dataSourceProperties.getMaxPoolSize());
        dataSource.setMaxLifetime(dataSourceProperties.getMaxLifetimeInMinutes());
        dataSource.setLeakDetectionThreshold(dataSourceProperties.getLeakDetectionThresholdInMilliseconds());
        dataSource.setConnectionTimeout(dataSourceProperties.getConnectionTimeoutInMilliseconds());
        dataSource.setConnectionInitSql(this.properties.getInitSql());

        return dataSource;
    }

}
