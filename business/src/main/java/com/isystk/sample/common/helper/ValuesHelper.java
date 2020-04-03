package com.isystk.sample.common.helper;

import com.google.common.reflect.ClassPath;
import com.isystk.sample.common.values.Values;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

@Component("vh")
public class ValuesHelper {

	private final Map<String, String> valuesObjList;

	private ValuesHelper() throws IOException {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		valuesObjList = ClassPath.from(loader).getTopLevelClassesRecursive("com.isystk.sample.common.values").stream()
				.filter(classInfo -> {
					try {
						Class<?> clazz = Class.forName(classInfo.getName());
						return !clazz.equals(Values.class) && Values.class.isAssignableFrom(clazz);
					} catch (ClassNotFoundException e) {
						throw new RuntimeException(e);
					}
				}).collect(Collectors.toMap(ClassPath.ClassInfo::getSimpleName, ClassPath.ClassInfo::getName));
	}

	/** JSPからアクセス用*/
	@SuppressWarnings("unchecked")
	public <T extends Enum<T> & Values> T[] values(String classSimpleName) throws ClassNotFoundException {
		Class<T> enumType = (Class<T>) Class.forName(this.valuesObjList.get(classSimpleName));
		return enumType.getEnumConstants();
	}

}