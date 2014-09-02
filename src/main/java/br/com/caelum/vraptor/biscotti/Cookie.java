package br.com.caelum.vraptor.biscotti;

import static java.util.Arrays.stream;

import java.util.Optional;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestScoped
public class Cookie implements LanguageScope {

	private static final String KEY = "br.com.caelum.vraptor.i18n.language";
	@Inject
	private HttpServletRequest request;
	@Inject
	private HttpServletResponse response;
	private String language;

	@Override
	public void set(String language) {
		this.language = language;
		javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie(KEY,
				language);
		response.addCookie(cookie);
	}

	public Optional<String> get() {
		if (language != null)
			return Optional.of(language);
		javax.servlet.http.Cookie[] cookies = request.getCookies();
		if (cookies == null)
			return Optional.empty();
		return stream(cookies)
				.filter(c -> c.getName().equals(KEY))
				.map(c -> c.getValue())
				.findFirst();
	}

}
