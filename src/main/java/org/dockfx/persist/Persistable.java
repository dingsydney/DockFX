package org.dockfx.persist;

/**
 * Created by ding jiangfeng on 14/06/2017.
 */
public interface Persistable<T> {
  T reconstruct();
  void persist(T t);
}
