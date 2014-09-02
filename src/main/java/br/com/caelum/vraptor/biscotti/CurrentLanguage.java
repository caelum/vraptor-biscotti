package br.com.caelum.vraptor.biscotti;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class CurrentLanguage {

	private Application app;
	private Cookie cookie;
	private Request request;

	/** @deprecated cdi */
	CurrentLanguage() {
	}

	@Inject
	public CurrentLanguage(Application app, Cookie cookie, Request request) {
		this.app = app;
		this.cookie = cookie;
		this.request = request;
	}

	/**
	 * Override to define another order
	 */
	public String get() {
		return request.get().orElseGet(() -> cookie.get().orElse(app.get()));
	}

}
