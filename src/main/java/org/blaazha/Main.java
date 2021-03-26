package org.blaazha;

import com.blaazha.database.config.PersistenceConfig;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.aeonbits.owner.ConfigFactory;
import org.blaazha.application.TestService;

public class Main {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector();

        TestService testService = injector.getInstance(TestService.class);

        PersistenceConfig persistenceConfig = ConfigFactory.create(PersistenceConfig.class);

        System.out.println(persistenceConfig.url());

        System.out.println(testService.test());
    }
}
