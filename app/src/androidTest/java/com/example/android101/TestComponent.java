package com.example.android101;

/**
 * Created by akramrasikh on 22/11/2017.
 */

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {TestModule.class})
public interface TestComponent extends ApplicationComponent {

}
