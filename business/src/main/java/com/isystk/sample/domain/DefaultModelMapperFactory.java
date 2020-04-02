package com.isystk.sample.domain;

import org.modelmapper.AbstractConverter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.PropertyInfo;

import com.isystk.sample.common.dto.DomaDto;
import com.isystk.sample.common.dto.ID;

import lombok.val;

/**
 * ModelMapperのファクトリ
 */
public class DefaultModelMapperFactory {

	/**
	 * ModelMapperを返します。
	 *
	 * @return
	 */
	public static ModelMapper create() {
		// ObjectMappingのためのマッパー
		val modelMapper = new ModelMapper();
		val configuration = modelMapper.getConfiguration();

		configuration.setPropertyCondition(
				// IDフィールド以外をマッピングする
				context -> {
					// DomaDtoのIDカラムは上書きしないようにする
					PropertyInfo propertyInfo = context.getMapping().getLastDestinationProperty();
					return !(context.getParent().getDestination() instanceof DomaDto
							&& propertyInfo.getName().equals("id"));
				});

		// 厳格にマッピングする
		configuration.setMatchingStrategy(MatchingStrategies.STRICT);

		// コンバーター
		val idToInt = new AbstractConverter<ID<?>, Integer>() {
			@Override
			protected Integer convert(ID<?> source) {
				return source == null ? null : source.getValue();
			}
		};

		modelMapper.addConverter(idToInt);

		return modelMapper;
	}
}
