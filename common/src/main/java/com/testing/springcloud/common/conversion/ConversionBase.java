package com.testing.springcloud.common.conversion;

import org.mapstruct.IterableMapping;
import org.mapstruct.Named;

import java.util.stream.Stream;

public interface ConversionBase<LEFT, RIGHT> {
	@Named("leftToRight")
	RIGHT leftToRight(LEFT left);

	@Named("rightToLeft")
	LEFT rightToLeft(RIGHT right);

	@IterableMapping(qualifiedByName = "leftToRight")
	Stream<RIGHT> leftToRight(Iterable<LEFT> left);

	@IterableMapping(qualifiedByName = "rightToLeft")
	Stream<LEFT> rightToLeft(Iterable<RIGHT> right);
}
