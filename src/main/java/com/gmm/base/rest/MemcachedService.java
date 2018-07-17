package com.gmm.base.rest;

import org.springframework.stereotype.Service;

//Author: Muthu Mariyappan G

import com.whalin.MemCached.MemCachedClient;
import com.whalin.MemCached.SockIOPool;

@Service
public class MemcachedService {
	
	private SockIOPool pool;
	private MemCachedClient memClient;
	
	public MemcachedService() {
		String[] servers = {"localhost:11211"};
		this.pool = SockIOPool.getInstance("PoolofConnections");
		pool.setServers( servers );
		pool.setFailover( true );
		pool.setInitConn( 2 );
		pool.setMinConn( 1 );
		pool.setMaxConn( 250 );
		pool.setMaintSleep( 30 );
		pool.setNagle( false );
		pool.setSocketTO( 3000 );
		pool.setAliveCheck( true );
		pool.initialize();
		
		this.memClient = new MemCachedClient("PoolofConnections");
		if(this.memClient!=null)
			System.out.println("\nSuccessfully connected to the Memcached server!\n");
		else
			System.out.println("\nNo connection to Memcached server!\n");
	}
	
	public void setValue(String id,String name) {
		memClient.set(id,name);
	}
	
	public String getValue(String id) {
		return (String)memClient.get(id);
	}
	
	public String deleteValue(String id) {
		String name = (String)memClient.get(id);
		memClient.delete(id);	
		return name;
	}
}