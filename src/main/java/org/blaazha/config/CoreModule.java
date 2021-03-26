package org.blaazha.config;

import com.google.inject.AbstractModule;
import org.blaazha.application.service.StudentService;
import org.blaazha.application.service.impl.StudentServiceImpl;

public class CoreModule extends AbstractModule {

    @Override
    protected void configure() {

        bind(StudentService.class).to(StudentServiceImpl.class);
    }
}
