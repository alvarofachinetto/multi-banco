package com.example.multibanco.config;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.example.multibanco.repository.pagamento",
        entityManagerFactoryRef = "pagamentoEntityManager"
)
public class BDPagamento {

    @Bean
    @ConfigurationProperties(prefix = "pagamento.datasource")
    public DataSource pagamentoDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties(prefix = "pagamento.datasource")
    public LocalContainerEntityManagerFactoryBean pagamentoEntityManager(
            EntityManagerFactoryBuilder builder,
            @Qualifier(value = "pagamentoDataSource") DataSource dataSource
    ){
        return builder.dataSource(dataSource)
                        .packages("com.example.multibanco.model.pagamento")
                        .build();
    }
}
