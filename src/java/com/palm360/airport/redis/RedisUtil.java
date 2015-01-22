package com.palm360.airport.redis;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;
import redis.clients.jedis.Transaction;

/**
 * 
 * @author zhangtong
 *
 */
@Service("redis")
public class RedisUtil {
	
	/**
	 * 必须static否者注入为null 
	 * 不知道为什呢
	 */
	//@Resource(name="shardedJedisPool")
	private ShardedJedisPool shardedJedisPool;//JedisPool jedisPool;
	@Resource(name="jedisPool")
	private JedisPool jedisPool;
	@PostConstruct
	public void initJedisPool(){
		this.setJedisPool(jedisPool);
		this.setShardedJedisPool(shardedJedisPool);
	}
	
	public RedisUtil(){
		
	}
	   
	public ShardedJedis getConnectionEx(){
		ShardedJedis jedis=null;          
		try {
//			shardedJedisPool = new ShardedJedisPool(null, shards);
			//JedisShardInfo js;
			jedis=shardedJedisPool.getResource();
		} catch (Exception e) {              
			e.printStackTrace();          
		}          
		return jedis;    
	}
	public Jedis getConnection() {
		Jedis jedis=null;          
		try {
			jedis=jedisPool.getResource();   
			
		} catch (Exception e) {              
			e.printStackTrace();          
		}          
		return jedis;      
	}   
	
	public void closeConnectionEx(ShardedJedis jedis) {          
		if (null != jedis) {              
			try {                  
				shardedJedisPool.returnResource(jedis);              
			} catch (Exception e) {
					e.printStackTrace();              
			}          
		}      
	}  
	public void closeConnection(Jedis jedis) {          
		if (null != jedis) {              
			try {                  
				jedisPool.returnResource(jedis);              
			} catch (Exception e) {
					e.printStackTrace();              
			}          
		}      
	}  
	
	    
	public boolean setData(String key,String value) {
		try {                  
			ShardedJedis jedis=getConnectionEx();                  
			jedis.set(key,value);                  
			returnResource(jedis);                  
			return true;              
		} catch (Exception e) {
			e.printStackTrace();                                
		}          
		return false;      
	}
	public void returnResource(ShardedJedis redis){
		if(jedisPool != null)
			shardedJedisPool.returnResource(redis);
	}
	public void returnResource(Jedis redis){
		if(jedisPool != null)
			jedisPool.returnResource(redis);
	}
	
	public String getData(String key) {
		String value=null;              
		try {
			ShardedJedis jedis=getConnectionEx();
			value=jedis.get(key);
			returnResource(jedis);                  
			return value;              
		} catch (Exception e) {
			e.printStackTrace();                                
		}          
		return value;      
	}

	public void setJedisPool(JedisPool JedisPool) {
		this.jedisPool = JedisPool;      
	}       
	
	   
	public JedisPool getJedisPool() {
		return jedisPool;      
	}

	public void setShardedJedisPool(ShardedJedisPool shardedJedisPool) {
		this.shardedJedisPool = shardedJedisPool;
	}

	public ShardedJedisPool getShardedJedisPool() {
		return shardedJedisPool;
	}     
} 

