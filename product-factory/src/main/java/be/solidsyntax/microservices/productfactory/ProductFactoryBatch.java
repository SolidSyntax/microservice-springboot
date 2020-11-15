package be.solidsyntax.microservices.productfactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.context.scope.refresh.RefreshScopeRefreshedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@RefreshScope
@Service
public class ProductFactoryBatch implements ApplicationListener<RefreshScopeRefreshedEvent> {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductFactoryBatch.class);

    @Scheduled(fixedRateString = "${configuration.interval:10000}")
    public void someSortOfBatch() {
        LOGGER.info("I'm doing important stuff");
    }

    @Override
    public void onApplicationEvent(RefreshScopeRefreshedEvent event) {
        LOGGER.info("Batch service reconfigured");
    }
}
