package br.com.rafael.moneyapi.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;

public class CreatedResourceEvent extends ApplicationEvent {

    private static final long serialVersionUID = 1L;
    private Long id;
    private HttpServletResponse response;

    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public CreatedResourceEvent(Object source, HttpServletResponse response, Long id) {
        super(source);
        this.id = id;
        this.response = response;
    }

    public void addHeaderLocation() {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(id).toUri();
        response.setHeader("Location", uri.toASCIIString());
    }
}
