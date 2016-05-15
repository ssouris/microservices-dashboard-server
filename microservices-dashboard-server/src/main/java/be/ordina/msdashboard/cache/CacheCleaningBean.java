package be.ordina.msdashboard.cache;

import be.ordina.msdashboard.store.NodeStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CacheCleaningBean {

	private static final Logger LOG = LoggerFactory.getLogger(CacheCleaningBean.class);

	private NodeCache nodeCache;
	private boolean evict;

	public CacheCleaningBean(NodeCache nodeCache, boolean evict) {
		this.nodeCache = nodeCache;
		this.evict = evict;
	}

	public void clean() {
		LOG.info("Cleaning cache: " + evict);
		if (evict) {
			nodeCache.evictHealthsCache();
			nodeCache.evictIndexesCache();
			nodeCache.evictPactsCache();
		}
	}
}