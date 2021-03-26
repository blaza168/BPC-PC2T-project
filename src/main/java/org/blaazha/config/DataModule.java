package org.blaazha.config;

import com.blaazha.database.config.PersistenceConfig;
import com.blaazha.database.repository.StudentMarksRepository;
import com.blaazha.database.repository.StudentRepository;
import com.blaazha.database.repository.StudentTeacherJoinRepository;
import com.blaazha.database.repository.TeacherRepository;
import com.blaazha.database.repository.impl.JdbcStudentMarksRepository;
import com.blaazha.database.repository.impl.JdbcStudentRepository;
import com.blaazha.database.repository.impl.JdbcStudentTeacherJoinRepository;
import com.blaazha.database.repository.impl.JdbcTeacherRepository;
import com.google.inject.AbstractModule;
import org.aeonbits.owner.ConfigFactory;
import org.apache.commons.dbcp2.BasicDataSource;
import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.sql.DataSource;


public class DataModule extends AbstractModule {

    private static final Logger log = LoggerFactory.getLogger(DataModule.class);

    @Override
    protected void configure() {
        PersistenceConfig persistenceConfig = ConfigFactory.create(PersistenceConfig.class);

        DataSource dataSource = buildDataSource(persistenceConfig);
        bind(DataSource.class).toInstance(dataSource);

        DBI dbi = new DBI(dataSource);
        bind(DBI.class).toInstance(dbi);

        // Repositories
        bind(StudentRepository.class).to(JdbcStudentRepository.class);
        bind(TeacherRepository.class).to(JdbcTeacherRepository.class);
        bind(StudentTeacherJoinRepository.class).to(JdbcStudentTeacherJoinRepository.class);
        bind(StudentMarksRepository.class).to(JdbcStudentMarksRepository.class);
    }

    private DataSource buildDataSource(PersistenceConfig config) {
        log.info("Establishing connection pool to {} as user {}", config.url(), config.username());

        BasicDataSource ds = new BasicDataSource();

        ds.setDriverClassLoader(com.mysql.jdbc.Driver.class.getClassLoader());
        ds.setUrl(config.url());
        ds.setUsername(config.username());
        ds.setPassword(config.password());

        ds.setTestOnBorrow(true);
        ds.setTestWhileIdle(true);
        ds.setNumTestsPerEvictionRun(config.poolSize());
        ds.setTimeBetweenEvictionRunsMillis(1000);
        ds.setMinEvictableIdleTimeMillis(config.poolExpiration());
        ds.setMaxConnLifetimeMillis(300000);
        ds.setMinIdle(0);
        ds.setMaxIdle(config.poolSize());
        ds.setMaxTotal(config.poolSize());
        ds.setLogExpiredConnections(false);

        return ds;
    }
}
