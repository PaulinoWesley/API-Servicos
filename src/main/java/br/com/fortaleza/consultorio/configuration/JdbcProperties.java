package br.com.fortaleza.consultorio.configuration;

import lombok.Getter;
import lombok.Setter;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "jdbc")
public class JdbcProperties {
    private String username;
    private String password;
    private String initSql;
    private String jdbcDriverName;
    private JdbcDataSourceProperties dtProperties;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getInitSql() {
        return initSql;
    }

    public void setInitSql(String initSql) {
        this.initSql = initSql;
    }

    public String getJdbcDriverName() {
        return jdbcDriverName;
    }

    public void setJdbcDriverName(String jdbcDriverName) {
        this.jdbcDriverName = jdbcDriverName;
    }

    public JdbcDataSourceProperties getDtProperties() {
        return dtProperties;
    }

    public void setDtProperties(JdbcDataSourceProperties dtProperties) {
        this.dtProperties = dtProperties;
    }

    public static class JdbcDataSourceProperties {
        private String url;
        private Integer maxPoolSize;
        private Long maxLifetimeInMinutes;
        private Long leakDetectionThresholdInMilliseconds;
        private Long connectionTimeoutInMilliseconds;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Integer getMaxPoolSize() {
            return maxPoolSize;
        }

        public void setMaxPoolSize(Integer maxPoolSize) {
            this.maxPoolSize = maxPoolSize;
        }

        public Long getMaxLifetimeInMinutes() {
            return maxLifetimeInMinutes;
        }

        public void setMaxLifetimeInMinutes(Long maxLifetimeInMinutes) {
            this.maxLifetimeInMinutes = maxLifetimeInMinutes;
        }

        public Long getLeakDetectionThresholdInMilliseconds() {
            return leakDetectionThresholdInMilliseconds;
        }

        public void setLeakDetectionThresholdInMilliseconds(Long leakDetectionThresholdInMilliseconds) {
            this.leakDetectionThresholdInMilliseconds = leakDetectionThresholdInMilliseconds;
        }

        public Long getConnectionTimeoutInMilliseconds() {
            return connectionTimeoutInMilliseconds;
        }

        public void setConnectionTimeoutInMilliseconds(Long connectionTimeoutInMilliseconds) {
            this.connectionTimeoutInMilliseconds = connectionTimeoutInMilliseconds;
        }
    }


}
