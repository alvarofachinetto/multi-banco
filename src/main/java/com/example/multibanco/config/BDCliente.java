package com.example.multibanco.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.example.multibanco.repository.cliente",
        entityManagerFactoryRef = "clienteEntityManager"
)
public class BDCliente {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "cliente.datasource")
    public DataSource clienteDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "cliente.datasource")
    public LocalContainerEntityManagerFactoryBean clienteEntityManager(
            EntityManagerFactoryBuilder builder,
            @Qualifier(value = "clienteDataSource") DataSource dataSource
    ){
        return builder.dataSource(dataSource)
                .packages("com.example.multibanco.model.cliente")
                .build();
    }

}
