package org.dockfx.persist;

import java.util.ArrayList;
import java.util.List;

import org.dockfx.UiUtil;
import org.dockfx.pane.ContentTabPane;

/**
 * Created by jding on 14/06/2017.
 */
public class PersistableTabPane implements Persistable<ContentTabPane> {

  Rec position;
  List<Persistable<?>> children = new ArrayList<>(10);
  
  @Override
  public ContentTabPane reconstruct() {
    ContentTabPane tabPane = new ContentTabPane();
//    for(Persistable<?> child : tabPane.getChildrenUnmodifiable()){
//    }
    return tabPane;
  }

  @Override
  public void persist(ContentTabPane tabPane) {
    position = UiUtil.getRec(tabPane);
  }

  public Rec getPosition() {
    return position;
  }

  public void setPosition(Rec position) {
    this.position = position;
  }

  public List<Persistable<?>> getChildren() {
    return children;
  }

  public void setChildren(List<Persistable<?>> children) {
    this.children = children;
  }

//  @Override
  public void addChild(Persistable<?> child) {
    children.add(child);
  }
}
