package com.tandong.iknowbox.common.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

/**
 * 
 * RedisClient 提供redis 数据访问操作 yzs 2015年12月10日 下午2:47:29
 * 
 * @version 1.0.0
 * 
 */
public class RedisClient {

	private JedisPool jedisPool;

	public String set(String key, Serializable value) {
		return setObject(key, value);
	}

	public String setIncrable(String key, Number value) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			String setObjectRet = jedis.set(key, value.toString());
			return setObjectRet;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return null;

	}
	public String setIncrableEx(String key,  Number value,int second) {
	    Jedis jedis = null;
	    try {
	        jedis = jedisPool.getResource();
	        String setObjectRet = jedis.setex(key, second,value.toString());
	        return setObjectRet;
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        returnResource(jedis);
	    }
	    return null;
	    
	}

	/**
	 * @Title: setex
	 * @Description: 将值 value 关联到 key ，并将 key 的生存时间设为 seconds (以秒为单位)。
	 * @param key
	 * @param value
	 * @param seconds
	 * @returnString
	 * @throws
	 * @author yangzongshan
	 * @date 2014年8月21日 上午9:04:23
	 */
	public String setex(String key, Serializable value, int seconds) {
		return setObjectEx(key, value, seconds);
	}

	/************* 取对象 ****************/
	public Object get(String key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			byte[] bs = jedis.get(key.getBytes());
			Object obj = byteToObject(bs);
			return obj;
		} catch (Exception e2) {
			e2.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return null;
	}

	public Integer getInteger(String key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			String string = jedis.get(key);
			if (string == null) {
				return null;
			}
			Integer number = Integer.parseInt(string);
			return number;
		} catch (Exception e2) {
			e2.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return null;
	}

	public String getString(String key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			String string = jedis.get(key);
			return string;
		} catch (Exception e2) {
			e2.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return null;
	}

	/**
	 * 释放资源
	 * 
	 * @param jedis
	 *
	 */
	public void returnResource(Jedis jedis) {
		if (jedis != null)
			jedisPool.returnResource(jedis);
	}

	private byte[] objectToByte(Serializable obj) {
		byte[] bs = null;
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(obj);
			bs = bos.toByteArray();
			oos.close();
			bos.close();
			return bs;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bs;
	}

	private Map<byte[], byte[]> objectToByteForMapKey(Map<String, Serializable> map) {
		Iterator<Entry<String, Serializable>> iterator = map.entrySet().iterator();
		HashMap<byte[], byte[]> hashMap = new HashMap<byte[], byte[]>();
		while (iterator.hasNext()) {
			Entry<String, Serializable> next = iterator.next();
			hashMap.put(next.getKey().getBytes(), objectToByte(next.getValue()));
		}
		return hashMap;
	}

	private Serializable byteToObject(byte[] bs) {
		Serializable obj = null;
		try {
			if (bs != null) {
				ByteArrayInputStream bis = new ByteArrayInputStream(bs);
				ObjectInputStream inputStream = new ObjectInputStream(bis);
				obj = (Serializable) inputStream.readObject();
				inputStream.close();
				bis.close();
			}
			return obj;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		return obj;
	}

	/**
	 * @Title: lindex
	 * @Description: 返回列表 key 中，下标为 index 的元素。
	 * @param key
	 * @param index
	 * @returnObject
	 * @throws
	 * @author yangzongshan
	 * @date 2014年8月21日 上午9:06:25
	 */
	public Object lindex(String key, int index) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			byte[] lindex = jedis.lindex(key.getBytes(), index);
			return byteToObject(lindex);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}

		return null;
	}

	private String setObject(String key, Serializable value) {

		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			byte[] byteArray = objectToByte(value);
			String setObjectRet = jedis.set(key.getBytes(), byteArray);
			return setObjectRet;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return null;

	}

	private String setObjectEx(String key, Serializable value, int seconds) {

		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			byte[] byteArray = objectToByte(value);
			String setObjectRet = jedis.setex(key.getBytes(), seconds, byteArray);
			return setObjectRet;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return null;

	}

	public long llen(String key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.llen(key.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return 0;
	}

	public Object lpop(String key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.lpop(key.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return null;
	}

	public Object lrpop(String key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.rpop(key.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return null;
	}

	public long lpush(String key, Serializable value) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			byte[] objectToByte = objectToByte(value);
			return jedis.lpush(key.getBytes(), objectToByte);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return 0;
	}

	public long lpush(String key, List<? extends Serializable> value) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			long size = 0;
			for (Serializable s : value) {
				byte[] objectToByte = objectToByte(s);
				size = jedis.lpush(key.getBytes(), objectToByte);
			}
			return size;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}

		return 0;

	}

	public long rpush(String key, Serializable value) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			byte[] objectToByte = objectToByte(value);
			return jedis.rpush(key.getBytes(), objectToByte);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return 0;
	}

	public long rpush(String key, List<? extends Serializable> value) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			long size = 0;
			for (Serializable s : value) {
				byte[] objectToByte = objectToByte(s);
				size = jedis.rpush(key.getBytes(), objectToByte);
			}
			return size;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return 0;

	}

	public long lpushx(String key, Serializable value) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			byte[] objectToByte = objectToByte(value);
			return jedis.lpushx(key.getBytes(), objectToByte);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return 0;
	}

	public long lpushx(String key, List<? extends Serializable> value) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			long size = 0;
			for (Serializable s : value) {
				byte[] objectToByte = objectToByte(s);
				size = jedis.lpushx(key.getBytes(), objectToByte);
			}
			return size;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return 0;

	}

	public long rpushx(String key, Serializable value) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			byte[] objectToByte = objectToByte(value);
			return jedis.rpushx(key.getBytes(), objectToByte);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return 0;
	}

	public long rpushx(String key, List<? extends Serializable> value) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			long size = 0;
			for (Serializable s : value) {
				byte[] objectToByte = objectToByte(s);
				size = jedis.rpushx(key.getBytes(), objectToByte);
			}
			return size;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return 0;

	}

	public List<? extends Serializable> lrange(String key, int start, int end) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			List<byte[]> lrange = jedis.lrange(key.getBytes(), start, end);
			List<Serializable> lt = byteToObjectForList(lrange);
			return lt;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return null;
	}

	private List<Serializable> byteToObjectForList(List<byte[]> lrange) {
		List<Serializable> lt = new ArrayList<Serializable>();
		for (byte[] bs : lrange) {
			Serializable byteToObject = byteToObject(bs);
			lt.add(byteToObject);
		}
		return lt;
	}

	private Map<String, Serializable> byteToObjectForMap(Map<byte[], byte[]> lrange) {
		HashMap<String, Serializable> hashMap = new HashMap<String, Serializable>();
		Iterator<Entry<byte[], byte[]>> iterator = lrange.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<byte[], byte[]> next = iterator.next();
			hashMap.put(new String(next.getKey()), byteToObject(next.getValue()));
		}
		return hashMap;
	}

	public long lrem(String key, int count, Serializable value) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.lrem(key.getBytes(), count, objectToByte(value));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return 0;
	}

	public String lset(String key, int index, Serializable value) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.lset(key.getBytes(), index, objectToByte(value));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return null;
	}

	public String ltrim(String key, int start, int end) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.ltrim(key.getBytes(), start, end);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return null;
	}

	public Serializable rpoplpush(String srcKey, String detKey) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			byte[] rpoplpush = jedis.rpoplpush(srcKey.getBytes(), detKey.getBytes());
			return byteToObject(rpoplpush);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return null;
	}

	public long sadd(String key, Serializable value) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.sadd(key.getBytes(), objectToByte(value));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return 0;
	}

	public long sadd(String key, Set<? extends Serializable> values) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			long count = 0;
			for (Serializable s : values) {
				count += jedis.sadd(key.getBytes(), objectToByte(s));
			}
			return count;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return 0;
	}

	public long scard(String key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.scard(key.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return 0;
	}

	public boolean sismember(String key, Serializable value) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.sismember(key.getBytes(), objectToByte(value));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return false;
	}

	public Set<? extends Serializable> smembers(String key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			Set<byte[]> smembers = jedis.smembers(key.getBytes());
			Set<Serializable> set = byteToObjectforSet(smembers);
			return set;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return null;
	}

	private Set<Serializable> byteToObjectforSet(Set<byte[]> smembers) {
		Set<Serializable> set = new HashSet<Serializable>();
		for (byte[] bs : smembers) {
			set.add(byteToObject(bs));
		}
		return set;
	}

	public Object spop(String key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.spop(key.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return null;
	}

	public Object srandmember(String key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.srandmember(key.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return null;
	}

//	public List<Serializable> srandmember(String key, int count) {
//		Jedis jedis = null;
//		try {
//			jedis = jedisPool.getResource();
//			List<byte[]> srandmember = jedis.srandmember(key.getBytes(), count);
//			List<Serializable> byteToObjectForList = byteToObjectForList(srandmember);
//			return byteToObjectForList;
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			returnResource(jedis);
//		}
//		return null;
//	}

	public long srem(String key, Serializable value) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.srem(key.getBytes(), objectToByte(value));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return 0;
	}

	public long zadd(String key, double score, Serializable value) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.zadd(key.getBytes(), score, objectToByte(value));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return 0;
	}

	public long zcard(String key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.zcard(key.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return 0;
	}

	public long zcount(String key, double min, double max) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.zcount(key.getBytes(), min, max);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return 0;
	}

	public double zincrby(String key, double incrementscore, Serializable value) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.zincrby(key.getBytes(), incrementscore, objectToByte(value));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return 0;
	}

	public Set<? extends Serializable> zrange(String key, int start, int end) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.zrange(key.getBytes(), start, end);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return null;
	}

	public Set<? extends Serializable> zrangeByScore(String key, double min, double max) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.zrangeByScore(key.getBytes(), min, max);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return null;
	}

	public Set<? extends Serializable> zrangeByScore(String key, double min, double max, int offset, int count) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.zrangeByScore(key.getBytes(), min, max, offset, count);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return null;
	}

	public long zrem(String key, Serializable value) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.zrem(key.getBytes(), objectToByte(value));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return 0;
	}

	public long zremrangeByRank(String key, int start, int end) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.zremrangeByRank(key.getBytes(), start, end);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return 0;
	}

	public long zremrangeByScore(String key, double start, double end) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.zremrangeByScore(key.getBytes(), start, end);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return 0;
	}

	public Set<? extends Serializable> zrevrange(String key, int start, int end) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			Set<byte[]> zrevrange = jedis.zrevrange(key.getBytes(), start, end);
			return byteToObjectforSet(zrevrange);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return null;
	}

	public long zrank(String key, Serializable value) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.zrank(key.getBytes(), objectToByte(value));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return 0;
	}

	public long zrevrank(String key, Serializable value) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.zrevrank(key.getBytes(), objectToByte(value));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return 0;
	}

	public double zscore(String key, Serializable value) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.zscore(key.getBytes(), objectToByte(value));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return 0;
	}

	public long hset(String key, String field, Serializable value) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.hset(key.getBytes(), field.getBytes(), objectToByte(value));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return 0;
	}

	public boolean hexists(String key, String field) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.hexists(key.getBytes(), field.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return false;
	}

	public long hsetnx(String key, String field, Serializable value) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.hsetnx(key.getBytes(), field.getBytes(), objectToByte(value));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return 0;
	}

	public String hmset(String key, Map<String, Serializable> values) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.hmset(key.getBytes(), objectToByteForMapKey(values));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return null;
	}

	public Object hget(String key, String field) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			byte[] hget = jedis.hget(key.getBytes(), field.getBytes());
			return byteToObject(hget);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return null;
	}

	public List<Serializable> hmget(String key, List<String> fields) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			String[] fids = new String[fields.size()];
			fields.toArray(fids);
			byte[][] ids = new byte[fids.length][];
			for (int i = 0; i < fids.length; i++) {
				ids[i] = fids[i].getBytes();
			}
			List<byte[]> hmget = jedis.hmget(key.getBytes(), ids);
			List<Serializable> byteToObjectForList = byteToObjectForList(hmget);
			return byteToObjectForList;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return null;
	}

	public Map<String, Serializable> hgetAll(String key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			Map<byte[], byte[]> hgetAll = jedis.hgetAll(key.getBytes());
			return byteToObjectForMap(hgetAll);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return null;
	}

	public long hdel(String key, String... field) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.hdel(key, field);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return 0;
	}

	public long hlen(String key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.hlen(key.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return 0;
	}

	public Set<String> hkeys(String key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.hkeys(key);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return null;
	}

	public List<? extends Serializable> hvals(String key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			List<byte[]> hvals = jedis.hvals(key.getBytes());
			return byteToObjectForList(hvals);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return null;
	}

	public long setnx(String key, Serializable value) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.setnx(key.getBytes(), objectToByte(value));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return 0;
	}

	public long setnx(String key, Serializable value, int seconds) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			byte[] bytes = key.getBytes();
			Long setnx = jedis.setnx(bytes, objectToByte(value));
			jedis.expire(bytes, seconds);
			return setnx;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return 0;
	}

	public long append(String key, String value) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.append(key.getBytes(), value.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return 0;
	}

	public Serializable getSet(String key, Serializable value) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return byteToObject(jedis.getSet(key.getBytes(), objectToByte(value)));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return null;
	}

	// private boolean isNumber(Serializable value) {
	// return (value instanceof Number);// || (value instanceof String);
	// }

	public long decr(String key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.decr(key.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return 0;
	}

	public long decrBy(String key, long integer) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.decrBy(key.getBytes(), integer);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return 0;
	}

	public long incr(String key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.incr(key.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return 0;
	}

	public long incrBy(String key, long integer) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.incrBy(key.getBytes(), integer);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return 0;
	}

	public long ttl(String key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.ttl(key.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return 0;
	}

	public String type(String key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.type(key.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return null;
	}

	public long expire(String key, int seconds) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.expire(key.getBytes(), seconds);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return 0;
	}

	public long expireAt(String key, long timestamp) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.expireAt(key.getBytes(), timestamp);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return 0;
	}

	public boolean exists(String key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.exists(key.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return false;
	}

	public Long del(String key) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.del(key.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return null;
	}

	public Set<String> keys(String pattern) {
		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
			return jedis.keys(pattern);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return null;
	}

	public String watch(Jedis jedis, String... keys) {
		try {
			return jedis.watch(keys);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// returnResource(jedis);
		}
		return null;
	}

	public String unwatch(Jedis jedis) {
		try {
			return jedis.unwatch();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			returnResource(jedis);
		}
		return null;
	}

	public Transaction multi(Jedis jedis) {
		try {
			return jedis.multi();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// returnResource(jedis);
		}
		return null;
	}

	public Jedis getJedis() {
		return jedisPool.getResource();
	}

	public JedisPool getJedisPool() {
		return jedisPool;
	}

	public void setJedisPool(JedisPool jedisPool) {
		this.jedisPool = jedisPool;
	}

}
