package org.blaazha;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.blaazha.config.DataModule;
import org.flywaydb.core.Flyway;
import javax.sql.DataSource;


public class Main {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new DataModule());

//         Flyway cannot find migrations ...
//        Flyway flyway = new Flyway();
//        flyway.setDataSource(injector.getInstance(DataSource.class));
//        flyway.migrate();

        System.out.println("Program finished successfully");
    }
}
