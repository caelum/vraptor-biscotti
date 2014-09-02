package br.com.caelum.vraptor.biscotti;

import java.util.Optional;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

@RequestScoped
public class Request implements LanguageScope {

	private static final String KEY = "br.com.caelum.vraptor.i18n.language";
	private HttpServletRequest request;

	/** @deprecated cdi */
	Request() {
	}

	@Inject
	public Request(HttpServletRequest request) {
		this.request = request;
	}

	public void set(String language) {
		request.setAttribute(KEY, language);
	}

	public Optional<String> get() {
		return Optional.ofNullable((String) request.getAttribute(KEY));
	}

}
