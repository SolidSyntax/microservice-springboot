package be.solidsyntax.microservices.productfactory;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.context.scope.refresh.RefreshScopeRefreshedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@RefreshScope
@Service
@AllArgsConstructor
public class ProductFactory implements ApplicationListener<RefreshScopeRefreshedEvent> {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductFactory.class);
    private ProductStorage productStorage;

    @Scheduled(fixedRateString = "${configuration.interval}")
    public void createProduct() {
        Product product = new Product();
        LOGGER.info("Product created {}", product.getId());
        //productStorage.store(product);
    }

    @Override
    public void onApplicationEvent(RefreshScopeRefreshedEvent event) {
        LOGGER.info("ProductFactory reconfigured");
    }
}
