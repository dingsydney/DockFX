package org.dockfx.persist;

import org.dockfx.dock.DockNode;

import javafx.collections.ObservableList;

/**
 * Created by jding on 16/06/2017.
 */
public interface Persistent {
  void load(String filePath) throws PersistanceException;
  void save(ObservableList<DockNode> allNodes, String filePath) throws  PersistanceException;
}
