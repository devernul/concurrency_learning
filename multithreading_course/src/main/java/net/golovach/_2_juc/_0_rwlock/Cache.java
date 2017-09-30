package net.golovach._2_juc._0_rwlock;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by kruart on 30.09.2017.
 */
public class Cache {
    private final Object lock = new Object();
//    private Map<Integer, String> map = Collections.synchronizedMap(new HashMap<>());
    private Map<Integer, String> map = new ConcurrentHashMap<>();


    public String get(Object key) {
        return map.get(key);
    }

    public String put(Integer key, String value) {
        return map.put(key, value);
    }

    public <K, V> Map<K, V> synchronizedMap(Map<K, V> m) {
        return new MyMap<>(m);
    }

    private static class MyMap<T0, T1> implements Map<T0, T1> {
        private final ReadWriteLock rwLock = new ReentrantReadWriteLock();
        private final Lock rLock = rwLock.readLock();
        private final Lock wLock = rwLock.writeLock();
        private final Map<T0, T1> m;

        private MyMap(Map<T0, T1> m) {
            this.m = m;
        }

        @Override
        public int size() {
            rLock.lock();
            try {
                return m.size();
            } finally {
                rLock.unlock();
            }
        }

        @Override
        public boolean isEmpty() {
            rLock.lock();
            try {
                return m.isEmpty();
            } finally {
                rLock.unlock();
            }
        }

        @Override
        public boolean containsKey(Object key) {
            rLock.lock();
            try {
                return m.containsKey(key);
            } finally {
                rLock.unlock();
            }
        }

        @Override
        public boolean containsValue(Object value) {
            rLock.lock();
            try {
                return m.containsValue(value);
            } finally {
                rLock.unlock();
            }
        }

        @Override
        public T1 get(Object key) {
            rLock.lock();
            try {
                return m.get(key);
            } finally {
                rLock.unlock();
            }
        }

        @Override
        public T1 put(T0 key, T1 value) {
            wLock.lock();
            try {
                return m.put(key, value);
            } finally {
                wLock.unlock();
            }
        }

        @Override
        public T1 remove(Object key) {
            wLock.lock();
            try {
                return m.remove(key);
            } finally {
                wLock.unlock();
            }
        }

        @Override
        public void putAll(Map<? extends T0, ? extends T1> newM) {
            wLock.lock();
            try {
                this.m.putAll(newM);
            } finally {
                wLock.unlock();
            }
        }

        @Override
        public void clear() {
            wLock.lock();
            try {
                this.m.clear();
            } finally {
                wLock.unlock();
            }
        }

        @Override
        public Set<T0> keySet() {
            rLock.lock();
            try {
                return this.m.keySet();
            } finally {
                rLock.unlock();
            }
        }

        @Override
        public Collection<T1> values() {
            rLock.lock();
            try {
                return this.m.values();
            } finally {
                rLock.unlock();
            }
        }

        @Override
        public Set<Entry<T0, T1>> entrySet() {
            rLock.lock();
            try {
                return this.m.entrySet();
            } finally {
                rLock.unlock();
            }
        }
    }
}

class TTT {
    public static void main(String[] args) {
        ReadWriteLock rw = new ReentrantReadWriteLock();
        Lock r = rw.readLock();
        Lock w = rw.writeLock();
        new Thread(() -> {
            r.lock();
            System.out.println(0);
            while (true);
        }).start();

        new Thread(() -> {
            r.lock();
            System.out.println(1);
            while (true);
        }).start();

        new Thread(() -> {
            w.lock();
            System.out.println(2);
            while (true);
        }).start();
    }
}
