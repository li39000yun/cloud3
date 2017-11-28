package com.lyq.redis;


import com.lyq.lock.CacheLock;
import com.lyq.lock.LockedObject;

public interface SeckillInterface {
	@CacheLock(lockedPrefix="TEST_PREFIX")
	public void secKill(String arg1, @LockedObject Long arg2);
}
