package com.sunway.ws.core.cache;

import java.util.ArrayList;
import java.util.List;

import com.sunway.ws.core.utils.SpringUtils;
import com.sunway.ws.core.utils.StringUtils;

import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

public class CacheManager {
	
	private static net.sf.ehcache.CacheManager manager = SpringUtils.getBean("ehcache");

	/**
	 * 通过缓存的配置名称获取{@link Ehcache}<br>
	 * 请查看根目录下{@code ehcache.xml}配置文件
	 * 
	 * @param cacheName 缓存的配置名称
	 * @return 缓存
	 */
	public static final Ehcache getCache(final String cacheName) {
		return manager.getCache(cacheName);
	}
	
	/**
	 * 通过缓存的配置名称和缓存的钥匙获取缓存里的值
	 * 
	 * @param cacheName 缓存的配置名称
	 * @param key 缓存里的钥匙
	 * @return 缓存里对应的值
	 */
	public static final Object getObject(final String cacheName, final String key) {
		final Element element = getCache(cacheName).get(key);
		
		if (element == null) {
			return null;
		} else {
			return element.getObjectValue();
		}
	}
	
	/**
	 * 缓存钥匙和对应的值到指定的缓存下，如果该钥匙存在，就更新
	 * 
	 * @param cacheName 缓存的配置名称
	 * @param key 钥匙
	 * @param value 值
	 */
	public static final void putObject(final String cacheName, final String key, final Object value) {
		Element element = getCache(cacheName).get(key);
		
		if (element == null) {
			element = new Element(key, value);
			
			getCache(cacheName).put(element);
		} else {
			getCache(cacheName).replace(element, new Element(key, value));
		}
	}
	
	/**
	 * 在指定的缓存下，删除钥匙对应的缓存
	 * 
	 * @param cacheName 缓存的配置名称
	 * @param key 钥匙
	 */
	public static final void removeObject(final String cacheName, final String key) {
		getCache(cacheName).remove(key);
	}
	
	/**
	 * 在指定的缓存下，删除所有缓存
	 * 
	 * @param cacheName 缓存的配置名称
	 */
	public static final void removeAll(final String cacheName) {
		getCache(cacheName).removeAll();
	}
	
	/**
	 * 在指定的缓存下，取出所有缓存
	 * 
	 * @param cacheName 缓存的配置名称
	 * @param prefix 前缀
	 * @param suffix 后缀
	 * @return 缓存内值的 List
	 */
	public static final List<Object> getAll(final String cacheName, final String prefix, final String suffix) {
		List<Object> valueList = new ArrayList<Object>();
		List<?> keys = getCache(cacheName).getKeys();
		
		final String vPrefix = ((StringUtils.isBlank(prefix))? "" : prefix);
		final String vSuffix = ((StringUtils.isBlank(suffix))? "" : suffix);
		
		for (Object key : keys) {
			if (!StringUtils.startsWithIgnoreCase((String)key, vPrefix) || !StringUtils.endsWithIgnoreCase((String)key, vSuffix)) {
				continue;
			}
			
			Object value = getObject(cacheName, (String)key);
			valueList.add(value);
		}
		return valueList;
	}
	
}
