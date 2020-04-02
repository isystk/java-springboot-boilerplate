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

	@SuppressWarnings("unchecked")
	public <T extends Enum<T> & Values> int getValue(String classSimpleName, String valueName)
			throws ClassNotFoundException {
		Class<T> enumType = (Class<T>) Class.forName(this.valuesObjList.get(classSimpleName));
		T val = Enum.valueOf(enumType, valueName);
		return val.getCode();
	}

	public <T extends Enum<T> & Values> int getValue(Class<T> enumType, String valueName) {
		T val = Enum.valueOf(enumType, valueName);
		return val.getCode();
	}

	@SuppressWarnings("unchecked")
	public <T extends Enum<T> & Values> String getText(String classSimpleName, String value)
			throws ClassNotFoundException {
		Class<T> enumType = (Class<T>) Class.forName(this.valuesObjList.get(classSimpleName));
		String result = "";
		for (T val : enumType.getEnumConstants()) {
			if (val.getCode().equals(value)) {
				result = val.getText();
				break;
			}
		}
		return result;
	}

	public <T extends Enum<T> & Values> String getText(Class<T> enumType, String value) {
		String result = "";
		for (T val : enumType.getEnumConstants()) {
			if (val.getCode().equals(value)) {
				result = val.getText();
				break;
			}
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public <T extends Enum<T> & Values> T[] values(String classSimpleName) throws ClassNotFoundException {
		Class<T> enumType = (Class<T>) Class.forName(this.valuesObjList.get(classSimpleName));
		return enumType.getEnumConstants();
	}

}