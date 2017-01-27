package br.com.jonathan.util;

import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.regex.Matcher;

public class RegexMatcherIterator extends Spliterators.AbstractSpliterator<String> {
	private final Matcher matcher;

	public RegexMatcherIterator(Matcher matcher) {
		super(Long.MAX_VALUE, ORDERED | NONNULL);
		this.matcher = matcher;
	}

	@Override
	public boolean tryAdvance(Consumer<? super String> action) {
		if (matcher.find()) {
			action.accept(matcher.group());
			return true;
		}
		return false;
	}
}