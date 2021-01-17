package com.ovopark.springdata.elasticsearch.util;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.data.elasticsearch.core.query.IndexQuery;

import java.lang.reflect.Field;

/**
 * Created by akonczak on 02/12/2015.
 */
public class IndexBuilder {

	public static IndexQuery buildIndex(Object object) {
		for (Field f : object.getClass().getDeclaredFields()) {
			if (ArrayUtils.isNotEmpty(f.getAnnotationsByType(org.springframework.data.annotation.Id.class))) {
				try {
					f.setAccessible(true);
					IndexQuery indexQuery = new IndexQuery();
					indexQuery.setId((String) f.get(object));
					indexQuery.setObject(object);
					return indexQuery;
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		throw new RuntimeException("Missing @Id field");
	}
}
