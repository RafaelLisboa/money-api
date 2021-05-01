package br.com.rafael.moneyapi.event.listener;

import br.com.rafael.moneyapi.event.CreatedResourceEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class CreatedResourceListener implements ApplicationListener<CreatedResourceEvent> {

    @Override
    public void onApplicationEvent(CreatedResourceEvent event) {
        event.addHeaderLocation();
    }


}
